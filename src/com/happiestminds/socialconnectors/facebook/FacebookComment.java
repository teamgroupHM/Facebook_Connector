package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.tool.facebook.FBComment;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookException;

@SuppressWarnings("unused")
public class FacebookComment implements ITable{
	private static final String TABLE_NAME = "comment";
	private static final String SORT_COLUMN = null;
	private static final String MANDATORY_COLUMNS = "";
	
	public static int TOTAL_COMMENTS = 0;
	public List<String> postIdList = new ArrayList<String>();
	
	String query = "null";
	//String dlm = SocialConnectorClient.DEL;
	String dlm=null;
	
	public ITable createTable(){
		return new FacebookComment();
	}
	
	@Override
	public String getQuery() {
		return query;
	}
//
//	public void setQuery(FacebookClient fbClient, ITable table, String outputFile, List<String> postIdList, String... qualifier) {
//		this.postIdList = postIdList;
//		setQuery(fbClient, table, outputFile, qualifier);
//	}
	

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
				System.out.println("Loading comments....................started");
//				System.out.println("Delimiter for Comments table");
//				System.out.println(dlm);
				
				List<String> pid = getPostIdList(fbClient, qualifier[0]);
				// default limit for comments table is 5000
				// always keep divident factor smaller to avoid any data loss
				List<String> dividedPids = Utility.getQualifierString(pid, 50.00, true);
				
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
						List<FBComment> result = query(fbClient, query, FBComment.class);
						for (FBComment each : result) {
							String[] columns = TableMap.columnMap.get(TABLE_NAME).split(",");
							HashMap<String, String> map = each.getObjectMap();
							
							//modifications by prakash
//							ExtraClass ec=new ExtraClass();
//							HashMap<String, String> map = ec.getObjectMap();
							
							for (String string : columns) {
								bw.write(map.get(string.trim())+dlm);  //*****Delimiter is here
							}
							bw.write("~");
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				bw.close();
				
				System.out.println("total comments loaded: " + TOTAL_COMMENTS);
				System.out.println("Loading comments..................completed");
				System.out.println("###########################################");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getPostIdList(FacebookClient fb, String postId){
		List<String> returnQualifier = new ArrayList<String>();
		
		for (String each : this.postIdList) {
			String ids[] = each.split("_");
			returnQualifier.add(ids[1]);
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
	
	public static List<String> query(FacebookClient fbClient, String query) throws FacebookException {
	    System.out.println(query);
	    List<String> stringList = new ArrayList<String>();
	    try{stringList = fbClient.executeFqlQuery( query, String.class);}catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("failed");
	    }
	    
	    TOTAL_COMMENTS += stringList.size();
	    System.out.println("Result size: " + stringList.size());
	    return stringList;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<FBComment> query(FacebookClient fbClient, String query, Class cls) throws FacebookException {
	    System.out.println(query);
	    List<FBComment> json = new ArrayList<FBComment>();
	    try{json = fbClient.executeFqlQuery( query, cls);}catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("failed");}
	    
	    System.out.println("Result size: " + json.size());
	    return json;
 }
}

