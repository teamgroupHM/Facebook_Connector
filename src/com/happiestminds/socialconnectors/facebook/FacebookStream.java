package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.tool.facebook.FBStream;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;

@SuppressWarnings("unused")
public class FacebookStream implements ITable{
	private static final String TABLE_NAME = "stream";
	private static final String SORT_COLUMN = "created_time";
	private static final String MANDATORY_COLUMNS = ", created_time";
	public static List<String> postIdAssoc = new ArrayList<String>();
	public static int POST_COUNT = 0;
	public static boolean sampleRun = false;
	private String dlm=null;
	
	String query = "null";
	
	public ITable createTable(){
		return new FacebookStream();
	}
	
	@Override
	public String getQuery() {
		return query;
	}

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
			//sb.append(" ORDER BY ");
			//sb.append(SORT_COLUMN);
			
			
			query = sb.toString();
		}
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.happiestminds.socialconnectors.facebook.ITable#getQuailiferString(java.lang.String[])
	 * 
	 * 
	 * 
	 * 
	 * Need to alter this for actor id to get posts from other users as well
	 * 
	 * 
	 *
	 * 
	 */
	
	
	public String getQuailiferString(String... qualifier) {
		return " source_id in (" + qualifier[0] +") and actor_id in (" + qualifier[0] + ") ";
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
			System.out.println("Loading streams.....................started");
			
			while(keeploading){
				String addnQualifier = "";
				System.out.println("Loading iteration: " + (counter+1) );
				if(table.getSortColumn() != null)
					addnQualifier = (counter != 0) ? " and " + table.getSortColumn() + " < '" + timeStamp +"' limit 500 " : " limit 500 ";
				
				String execQuery =  query +  addnQualifier;
				String localTimeStamp = timeStamp;
				try{
					List<FBStream> result = query(fbClient, execQuery, FBStream.class);
					for (FBStream each : result) {
						localTimeStamp = table.getSortColumn() != null ? each.getCreated_time() : "";

						String[] columns = TableMap.columnMap.get(TABLE_NAME).split(",");
						HashMap<String, String> map = each.getObjectMap();
						for (String string : columns) {
							bw.write(map.get(string.trim())+dlm);
						}
						bw.write("\n");
						postIdAssoc.add(each.getPost_id());
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				if( (timeStamp.equals(localTimeStamp) && counter != 0) || table.getSortColumn() == null){
					keeploading = false;
				}else{
					timeStamp = localTimeStamp;
				}
				counter++;
				
				if(sampleRun)
					keeploading = false;
			}

			bw.close();
			
			System.out.println("total stream loaded: " + POST_COUNT);
			System.out.println("Loading streams...................completed");
			System.out.println("###########################################");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FBStream> query(FacebookClient fbClient, String query, Class cls) throws FacebookException {
	    System.out.println(query);
	    List<FBStream> json = new ArrayList<FBStream>();
	    try{json = fbClient.executeFqlQuery( query, cls);}catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("failed");}
	    POST_COUNT += json.size();
	    System.out.println("Result size: " + json.size());
	    return json;
 }
	
}
