package com.restdemo.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class DataFetcher {
	
	
	BufferedReader br =null;

	public DataFetcher(String filePath)  {
		super();
		try{
			FileInputStream fis = null;
			File homedir = new File(System.getProperty("user.home"));
			File fileToRead = new File(homedir, filePath);
			fis = new FileInputStream(fileToRead);
			InputStreamReader input = new InputStreamReader(fis);
			br = new BufferedReader(input);
		}catch(Exception e)
		{
			System.out.println("In Constructor");
		}
	}


	public String getDataFromFileAsJson()
	{
			try
			{
				String line = null;
				String info[] = null;
				List<DemoData> resultList= new ArrayList<DemoData>();
				SimpleDateFormat ft = new SimpleDateFormat("y-M-d_H:m:s");
				if ((line = br.readLine())== null) return null;//skip the first line, exit if the file is null
				
				while((line = br.readLine())!= null)
				{ 
					info = line.split("\\s");
					Date d = ft.parse(info[0]);
					DemoData data= new DemoData(d,Integer.parseInt(info[1]), Integer.parseInt(info[2]), Float.parseFloat(info[3]));
					resultList.add(data);
	            }
				String str = new Gson().toJson(resultList);
				return str;
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
			return null;
	}
	
	
	public String getDataFromFileAsJson(String [] feild)
	{
		JsonParser parser = new JsonParser();
		JsonArray arr = (JsonArray) parser.parse(getDataFromFileAsJson());
		
		Iterator<JsonElement> itr = arr.iterator();
		while (itr.hasNext()) {
			boolean flag = true;
			JsonObject obj =(JsonObject)itr.next();
		Set<Entry<String,JsonElement>> entry= obj.entrySet();
			for (Iterator iterator = entry.iterator(); iterator.hasNext();) {
				flag=true;
				Entry<String, JsonElement> entry2 = (Entry<String, JsonElement>) iterator.next();
				String key=entry2.getKey();
				for(int i=0;i<feild.length;i++ )
				{
					String str = feild[i];
					if(key.compareTo(str)!=0)
					{
						flag=false;
					}
					else{
						flag=true;
						break;
					}
				}
				if(flag == false)
				{
					obj.remove(entry2.getKey());
					flag=true;
				}	
			}
		}
		
		return arr.toString();
	}
	
	
	public String getDataFromFileAsJson( String startingDate ,String lastDate ){
		try
		{
			
			String line = null;
			String info[] = null;
			List<DemoData> resultList= new ArrayList<DemoData>();
			SimpleDateFormat ft = new SimpleDateFormat("y-M-d_H:m:s");
			if ((line = br.readLine())== null) 
				return null;
			Date dateStart= ft.parse(startingDate+"_00:00:00");
			Date dateEnd= ft.parse(lastDate+"_23:59:59");
			while((line = br.readLine())!= null)
			{ 
	           info = line.split("\\s");
	           Date d = ft.parse(info[0]);
	           if(dateStart.compareTo(d)<=0 && dateEnd.compareTo(d)>0)
	           {
	        	   DemoData data= new DemoData(d,Integer.parseInt(info[1]), Integer.parseInt(info[2]), Float.parseFloat(info[3]));
	        	   resultList.add(data);
	           }      
			}
			String str = new Gson().toJson(resultList);
	    return str;
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
			return null;
	}
	
}
