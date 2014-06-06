package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.tool.facebook.FBUser;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;

@SuppressWarnings("unused")
public class FacebookUser implements ITable{
	private static final String TABLE_NAME = "user";
	private static final String SORT_COLUMN = null;
	private static final String MANDATORY_COLUMNS = "";
	private String dlm=null;
	
	public static int USER_COUNT = 0;
	List<String> postIdList = new ArrayList<String>();
	
	String query = "null";
	
	public ITable createTable(){
		return new FacebookUser();
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
				System.out.println("Loading users.....................started");
				
				List<String> uid = getUserIdList(fbClient, qualifier[0]);
				USER_COUNT = uid.size();
				List<String> dividedUids = Utility.getQualifierString(uid, 500.00, false);
				
				for (int i=0; i < dividedUids.size(); i++){
					String qualifierString = getQuailiferString(dividedUids.get(i));
					
					StringBuilder sb = new StringBuilder();
					sb.append("SELECT ");
					sb.append(TableMap.columnMap.get(TABLE_NAME) + MANDATORY_COLUMNS);
					sb.append(" FROM ");
					sb.append(TABLE_NAME);
					sb.append(" WHERE ");
					sb.append(qualifierString);
					sb.append(" LIMIT 500");
					
					query = sb.toString();
					
					try{
						List<FBUser> result = query(fbClient, query, FBUser.class);
						for (FBUser each : result) {
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
				
				System.out.println("total users loaded: " + USER_COUNT);
				System.out.println("Loading users...................completed");
				System.out.println("###########################################");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getUserIdList(FacebookClient fb, String postId){
		List<String> returnQualifier = new ArrayList<String>();
		
		// fail case testing pending
		List<String> dividedPostIdsAssoc = Utility.getQualifierString(this.postIdList/*.subList(0, 100)*/, 20.00, true);
		for(String queryQualifier : dividedPostIdsAssoc){
			String userFromCommentsQuery = "select fromid from comment where post_id in (" + queryQualifier + ") ";
			List<String> result = query(fb, userFromCommentsQuery);
			for (String each : result) {
				String[] parts = each.split(":");
				returnQualifier.add(parts[1].substring(0, parts[1].length()-1));
			}
			
			String userFromLikesQuery = "select user_id from like where post_id in (" + queryQualifier + ") ";
			result = query(fb, userFromLikesQuery);
			for (String each : result) {
				String[] parts = each.split(":");
				returnQualifier.add(parts[1].substring(0, parts[1].length()-1));
			}
		}
		
		return returnQualifier;
	}
		
	public String getQuailiferString(String... qualifier) {
		return " uid in (" + qualifier[0] +") ";
	}

	@Override
	public String getSortColumn() {
		return SORT_COLUMN;
	}

	@Override
	public void createFile(FacebookClient fbClient, ITable table,
			String outputFile) {
		// setQuery runs this parts also
	}
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FBUser> query(FacebookClient fbClient, String query, Class cls) throws FacebookException {
		    System.out.println(query);
		    List<FBUser> json = new ArrayList<FBUser>();
		    try{json = fbClient.executeFqlQuery( query, cls);}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("failed");}
		    return json;
	 }
	 
	 public List<String> query(FacebookClient fbClient, String query) throws FacebookException {
		    System.out.println(query);
		    List<String> stringList = new ArrayList<String>();
		    try{stringList = fbClient.executeFqlQuery( query, String.class);}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("failed");
		    }
		    System.out.println("Result size: " + stringList.size());
		    return stringList;
	 }
}

