package com.happiestminds.socialconnectors.tool.facebook;

import java.util.HashMap;

import com.happiestminds.demo.SocialConnectorClient;
import com.restfb.Facebook;

public class FBLike implements FBTable{

	
	  @Facebook
	  private String post_id;

	  @Facebook
	  private String user_id;
	  
	  @Facebook
	  private String object_id;

	public String getObject_id() {
		return object_id;
	}

	public String getPost_id() {
		return post_id;
	}

	public String getUser_id() {
		return user_id;
	}
	 
	public String toString(){
		return this.getPost_id()+SocialConnectorClient.DEL+
				this.getUser_id();
	}
	
	public HashMap<String, String> getObjectMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("post_id", getPost_id());
		map.put("user_id", getUser_id());
		map.put("object_id", getObject_id());
		
		return map;
	}
}
