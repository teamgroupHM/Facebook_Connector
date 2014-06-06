package com.happiestminds.socialconnectors.tool.facebook;


import java.util.HashMap;



import com.happiestminds.demo.SocialConnectorClient;
import com.happiestminds.socialconnectors.facebook.TableMap;
import com.restfb.Facebook;

@SuppressWarnings("unused")
public class FBComment implements FBTable{	
	
	@Facebook
	private String app_id; 

	@Facebook
	private String attachment; 

	@Facebook
	private String can_comment; 

	@Facebook
	private String can_like; 

	@Facebook
	private String can_remove; 

	@Facebook
	private String comment_count; 

	@Facebook
	private String fromid; 

	@Facebook
	private String id; 

	@Facebook
	private String is_private; 

	@Facebook
	private String likes; 

	@Facebook
	private String object_id; 

	@Facebook
	private String object_id_cursor; 

	@Facebook
	private String parent_id; 

	@Facebook
	private String parent_id_cursor; 

	@Facebook
	private String post_fbid; 

	@Facebook
	private String post_id; 

	@Facebook
	private String post_id_cursor; 

	@Facebook
	private String text; 

	@Facebook
	private String text_tags; 

	@Facebook
	private String time; 

	@Facebook
	private String user_likes;

	@Facebook
	private String username;
	
	
	public String getApp_id() {
		return app_id;
	}

	public String getAttachment() {
		return attachment;
	}

	public String getCan_comment() {
		return can_comment;
	}

	public String getCan_like() {
		return can_like;
	}

	public String getCan_remove() {
		return can_remove;
	}

	public String getComment_count() {
		return comment_count;
	}

	public String getId() {
		return id;
	}

	public String getIs_private() {
		return is_private;
	}

	public String getObject_id() {
		return object_id;
	}

	public String getObject_id_cursor() {
		return object_id_cursor;
	}

	public String getParent_id() {
		return parent_id;
	}

	public String getParent_id_cursor() {
		return parent_id_cursor;
	}

	public String getPost_fbid() {
		return post_fbid;
	}

	public String getPost_id_cursor() {
		return post_id_cursor;
	}

	public String getText_tags() {
		return text_tags;
	}

	public String getTime() {
		return time;
	}

	public String getUser_likes() {
		return user_likes;
	}

	
	public String getPost_id() {
		return post_id;
	}

	public String getFromid() {
		return fromid;
	}

	public String getText() {
		return text.replaceAll("[\n\r]", "");  // removing all new line characters
	}

	public String getLikes() {
		return likes;
	}

	public String getUsername() {
		return username;
	}

	public String toString(){
		return this.getPost_id()+SocialConnectorClient.DEL+
				this.getFromid()+SocialConnectorClient.DEL+
				this.getText()+SocialConnectorClient.DEL+
				this.getLikes()+SocialConnectorClient.DEL+
				this.getTime()+SocialConnectorClient.DEL+
				this.getCan_like()+SocialConnectorClient.DEL+
				this.getApp_id()+SocialConnectorClient.DEL+
				this.getAttachment()+SocialConnectorClient.DEL+
				this.getCan_comment()+SocialConnectorClient.DEL+
				this.getParent_id()+SocialConnectorClient.DEL+
				this.getUser_likes()+SocialConnectorClient.DEL+
				this.getPost_fbid()+SocialConnectorClient.DEL+
				this.getId()+SocialConnectorClient.DEL+
				this.getComment_count();
	}

////Making the method dynamic to populate the columns as per the config file	
//	
//	private String[] columns = TableMap.columnMap.get(TABLE_NAME).split(",");
//	private String[] colmap = new String[columns.length];
//	
//	
//	// Creating a new array to hold all the getField function names
//	{
//		for (int ij=0;ij<columns.length;ij++)
//		{
//			colmap[ij]="get"+WordUtils.capitalize(columns[ij]+"()");
//		}
//	}
//		

	public HashMap<String, String> getObjectMap(){
		
		HashMap<String, String> map = new HashMap<String, String>();
		//app_id, attachment, can_comment, can_like, comment_count, fromid, id, likes, parent_id, post_fbid, post_id, text, time, user_likes
		map.put("post_id", getPost_id());
		map.put("fromid", getFromid());
		map.put("text", getText());
		map.put("likes", getLikes());
		map.put("time", getTime());
		map.put("can_like", getCan_like());
		map.put("app_id", getApp_id());
		map.put("attachment", getAttachment());
		map.put("can_comment", getCan_comment());
		map.put("parent_id", getParent_id());
		map.put("user_likes", getUser_likes());
		map.put("post_fbid", getPost_fbid());
		map.put("id", getId());
		map.put("comment_count", getComment_count());

//		{
//			for (int ik=0;ik<columns.length;ik++)
//			{
//				map.put(columns[ik].toString(), colmap[ik]);
//				
//			}
//		}
		


		return map;
	}

}
