package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.tool.facebook.FBEvent;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;

@SuppressWarnings("unused")
public class FacebookEvent implements ITable{

	private static final String TABLE_NAME = "event";
	private static final String SORT_COLUMN = "update_time";
	private static final String MANDATORY_COLUMNS = ", update_time";
	private String dlm=null;
	
	public static int EVENTS_COUNT = 0;
	String query = "null";
	
	public ITable createTable(){
		return new FacebookEvent();
	}
	
	@Override
	public String getQuery() {
		return query;
	}


//	
//	public void setQuery(FacebookClient fbClient, ITable table, String outputFile, List<String> postIdList, String... qualifier) {
//		//this.postIdList = postIdList;
//		setQuery(fbClient, table, outputFile, qualifier);
//	}
	
	public void setQuery(FacebookClient fbClient, ITable table, String outputFile, List<String> postIdList,String delimit, String... qualifier) {
		//this.postIdList = postIdList;
		setQuery(fbClient, table, outputFile,delimit, qualifier);
	}
	
	public void setQuery(FacebookClient fbClient, ITable table, String outputFile,String delimit, String... qualifier) {
		if(TableMap.columnMap.containsKey(TABLE_NAME)){
			dlm=delimit;
			String qualifierString = getQuailiferString(qualifier);
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append(TableMap.columnMap.get(TABLE_NAME) + MANDATORY_COLUMNS);
			sb.append(" FROM ");
			sb.append(TABLE_NAME);
			sb.append(" WHERE ");
			sb.append(qualifierString);
			
			query = sb.toString();
		}
	}

	public String getQuailiferString(String... qualifier) {
		return " creator in (" + qualifier[0] +" )";
	}

	@Override
	public String getSortColumn() {
		return SORT_COLUMN;
	}

	@Override
	public void createFile(FacebookClient fbClient, ITable table, String outputFile) {

		
		String query = table.getQuery();
		
		try {
			BufferedWriter bw = Utility.getWriter(outputFile);
			
			boolean keeploading = true;
			String timeStamp = "";
			int counter = 0;
			
			System.out.println("###########################################");
			System.out.println("Loading comments....................started");
			
			while(keeploading){
				String addnQualifier = "";
				if(table.getSortColumn() != null)
					addnQualifier = (counter != 0) ? " and " + table.getSortColumn() + " < '" + timeStamp +"' limit 500 " : " limit 500 ";
				
				String execQuery =  query +  addnQualifier;
				String localTimeStamp = timeStamp;
				try{
					List<FBEvent> result = query(fbClient, execQuery, FBEvent.class);
					for (FBEvent each : result) {
						localTimeStamp = table.getSortColumn() != null ? each.getUpdate_time() : "";

						String[] columns = TableMap.columnMap.get(TABLE_NAME).split(",");
						HashMap<String, String> map = each.getObjectMap();
						for (String string : columns) {
							bw.write(map.get(string.trim())+dlm);
						}
						bw.write("\n");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				if( (timeStamp.equals(localTimeStamp) && counter != 0) || table.getSortColumn() == null){
					keeploading = false;
				}else{
					timeStamp = localTimeStamp;
				}
				System.out.println("loaded iteration" + ++counter);
			}

			bw.close();
			
			System.out.println("total events loaded: " + EVENTS_COUNT);
			System.out.println("Loading events................completed");
			System.out.println("###########################################");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FBEvent> query(FacebookClient fbClient, String query, Class cls) throws FacebookException {
		    System.out.println(query);
		    List<FBEvent> json = new ArrayList<FBEvent>();
		    try{json = fbClient.executeFqlQuery( query, cls);}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("failed");}
		    
		    EVENTS_COUNT += json.size();
		    System.out.println("Result size: " + json.size());
		    return json;
	 }
}
