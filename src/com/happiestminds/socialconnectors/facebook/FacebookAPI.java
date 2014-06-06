package com.happiestminds.socialconnectors.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;


public class FacebookAPI {
	
	@SuppressWarnings("rawtypes")
	public static void processMandatoryTables(String... args) throws Exception {
		// register any new factory class here
		new LoadTables();
		
		String configLine = args[0];
		String pageId = args[1];
		String appId = args[2];
		String secretKey = args[3];
		String delimit = args[4];
		
		
		AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(appId, secretKey);
		String oAuth=accessToken.getAccessToken();
		FacebookClient fbClient = new DefaultFacebookClient(oAuth);
		
		FacebookAPI api = new FacebookAPI();
		api.readConfigLine(configLine);
		
		String[] arg = {pageId};
		
		Iterator it = TableMap.columnMap.entrySet().iterator();
		System.out.println("Start size: " + FacebookStream.postIdAssoc.size());
		//Utility.postOnly = true;
		while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        String key = (String)pairs.getKey();
	        
	        if(TableFactory.m_RegisteredTables.get(key) != null){
	        	ITable table = ((ITable)TableFactory.m_RegisteredTables.get(key)).createTable();
	        	
	        	String outfileName = TableMap.fileMap.get(key) + "/" + key;
	        	
	        	table.setQuery(fbClient, table, outfileName, new ArrayList<String>(),delimit, arg);
	        	table.createFile(fbClient, table, outfileName);
	        }
	    }
		//Utility.postOnly = false;
	    System.out.println("size now: " + FacebookStream.postIdAssoc.size());
	    
	    //return FacebookStream.postIdAssoc;
	}
	
	public void readConfigLine(String line) {
	        if (line != null && !line.equals("")) {
	        	TableMap.columnMap = new LinkedHashMap<String, String>();
	        	TableMap.fileMap = new HashMap<String, String>();
	        	
	            String[] tableColumn = line.split("::");
	            String table = tableColumn[0] != null ? tableColumn[0].trim() : null;
	            String columns = tableColumn[1] != null ? tableColumn[1].trim() : null;
	            String outputFile = tableColumn[2] != null ? tableColumn[2].trim() : null;
	            
	            if(table != null && columns != null && outputFile != null){
	            	TableMap.columnMap.put(table, columns);
	            	TableMap.fileMap.put(table, outputFile);
	            }   
	        }
	}
	
	@SuppressWarnings("rawtypes")
	public static void processTables(int reducerkey, List<String> postIdList, String... args) throws Exception {
		// register any new factory class here
		new LoadTables();
		
		String pageId = args[0];
		String appId = args[1];
		String secretKey = args[2];
		String delimit = args[3];
		
		AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(appId, secretKey);
		String oAuth=accessToken.getAccessToken();
	
		String[] arg = {pageId};
		FacebookClient fbClient = new DefaultFacebookClient(oAuth);
		
		/*
		 * for each row/table in config file
		 * fetch data and create output file
		 */
		System.out.println("tables recieved: " + TableMap.columnMap.size());
		Iterator it = TableMap.columnMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        String key = (String)pairs.getKey();
	        
	        System.out.println("working on table: " + key);
	        
	        if(TableFactory.m_RegisteredTables.get(key) != null){
	        	ITable table = ((ITable)TableFactory.m_RegisteredTables.get(key)).createTable();
	        	String outputFileName = TableMap.fileMap.get(key) + "/" + key + reducerkey;
	        	table.setQuery(fbClient, table, outputFileName, postIdList,delimit,arg);
	        	table.createFile(fbClient, table, key);
	        }
	    }
	}
}
