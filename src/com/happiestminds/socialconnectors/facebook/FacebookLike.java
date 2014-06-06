package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.tool.facebook.FBLike;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;

@SuppressWarnings("unused")
public class FacebookLike implements ITable{
	private static final String TABLE_NAME = "like";
	private static final String SORT_COLUMN = null;
	private static final String MANDATORY_COLUMNS = "";
	private String dlm=null;
	
	public static int LIKES_COUNT = 0;
	public List<String> postIdList = new ArrayList<String>();
	
	String query = "null";
	
	public ITable createTable(){
		return new FacebookLike();
	}
	
	@Override
	public String getQuery() {
		return query;
	}

	public void setQuery(FacebookClient fbClient, ITable table, String outputFile, List<String> postIdList,String delimit, String... qualifier) {
		this.postIdList = postIdList;
		setQuery(fbClient, table, outputFile,delimit, qualifier);
	}
	
	public void setQuery(FacebookClient fbClient, ITable table, String outputFile,String delimit, String... qualifier) {
		if(TableMap.columnMap.containsKey(TABLE_NAME)){
			dlm=delimit;
			try {
				BufferedWriter bw = Utility.getWriter(outputFile);
				
				System.out.println("###########################################");
				System.out.println("Loading likes.......................started");
				
				List<String> pid = getPostIdList(fbClient, qualifier[0]);
				// default limit for comments table is 1000
				// always keep divident factor smaller to avoid any data loss
				List<String> dividedPids = Utility.getQualifierString(pid, 2.00, true);
				
				for (int i=0; i < dividedPids.size(); i++){
					String qualifierString = getQuailiferString(dividedPids.get(i));
					
					StringBuilder sb = new StringBuilder();
					sb.append("SELECT ");
					sb.append(TableMap.columnMap.get(TABLE_NAME) + MANDATORY_COLUMNS);
					sb.append(" FROM ");
					sb.append(TABLE_NAME);
					sb.append(" WHERE ");
					sb.append(qualifierString);
					
					query = sb.toString();
					
					try{
						List<FBLike> result = query(fbClient, query, FBLike.class);
						for (FBLike each : result) {
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
				}
				bw.close();
				
				System.out.println("total likes loaded: " + LIKES_COUNT);
				System.out.println("Loading likes.....................completed");
				System.out.println("###########################################");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getPostIdList(FacebookClient fb, String postId){
		List<String> returnQualifier = new ArrayList<String>();
		
		for (String each : this.postIdList) {
			returnQualifier.add(each);
		}
		
		return returnQualifier;
	}
	
	public String getQuailiferString(String... qualifier) {
		return " post_id in (" + qualifier[0] +") ";
	}

	@Override
	public String getSortColumn() {
		return SORT_COLUMN;
	}

	@Override
	public void createFile(FacebookClient fbClient, ITable table,
			String outputFile) {
		//setQuery runs this parts also
	}
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<FBLike> query(FacebookClient fbClient, String query, Class cls) throws FacebookException {
		    System.out.println(query);
		    List<FBLike> json = new ArrayList<FBLike>();
		    try{json = fbClient.executeFqlQuery( query, cls);}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("failed");}
		    
		    System.out.println("Result size: " + json.size());
		    return json;
	 }
	 
	 public static List<String> query(FacebookClient fbClient, String query) throws FacebookException {
		    System.out.println(query);
		    List<String> stringList = new ArrayList<String>();
		    try{stringList = fbClient.executeFqlQuery( query, String.class);}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("failed");
		    }
		    
		    LIKES_COUNT += stringList.size();
		    System.out.println("Result size: " + stringList.size());
		    return stringList;
	 }
}

