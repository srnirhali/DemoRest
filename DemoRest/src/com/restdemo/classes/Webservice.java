package com.restdemo.classes;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("/demodata")
public class Webservice {
	@GET
	@Path("/data/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetData(){
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson();
	}
	
	
	@GET
	@Path("/data+json/{sdate}/{edate}")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataPath(@PathParam("sdate") String startingDate, @PathParam("edate") String lastDate){
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson(startingDate,lastDate);
	}
	
	@GET
	@Path("/jsonq")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataQuery(@QueryParam("sdate") String startingDate, @QueryParam("edate") String lastDate){
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		
		return dataFetcher.getDataFromFileAsJson(startingDate,lastDate);
	}
	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataQuery(@QueryParam("fields") String feilds)
	{
		String [] feild = feilds.split(",");
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson(feild);
		
	}
	@GET
	@Path("/data/{feilds}")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataPathWithOne(@PathParam("feilds") List<String> feilds)
	{
		String [] feild =feilds.toArray(new String[0]);
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson(feild);
		
	}
	@GET
	@Path("/data/{feilds}/{feilds}")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataPathWithTwo(@PathParam("feilds") List<String> feilds)
	{
		String [] feild =feilds.toArray(new String[0]);
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson(feild);
		
	}
	@GET
	@Path("/data/{feilds}/{feilds}/{feilds}")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetDataPathWithThree(@PathParam("feilds") List<String> feilds)
	{
		String [] feild =feilds.toArray(new String[0]);
		DataFetcher dataFetcher = new DataFetcher("demo.txt");
		return dataFetcher.getDataFromFileAsJson(feild);
		
	}
	
}
