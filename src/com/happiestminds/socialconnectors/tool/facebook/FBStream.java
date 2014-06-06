package com.happiestminds.socialconnectors.tool.facebook;

import java.util.HashMap;

import com.happiestminds.demo.SocialConnectorClient;
import com.restfb.Facebook;

public class FBStream implements FBTable{
	
//	  @Facebook
//	  private String post_id;
//
//	  @Facebook
//	  private String source_id;
//	  
//	  @Facebook
//	  private String created_time;
//	  
//	  @Facebook
//	  private String actor_id;
//	  
//	  @Facebook
//	  private String message;
//	  
//	  @Facebook
//	  private String attachment;
//
//	public String getPost_id() {
//		return post_id;
//	}
//
//	public String getSource_id() {
//		return source_id;
//	}
//
//	public String getCreated_time() {
//		return created_time;
//	}
//
//	public String getActor_id() {
//		return actor_id;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public String getAttachment() {
//		return attachment;
//	}
	
	 @Facebook
	 private String action_links; 

	 @Facebook
	 private String actor_id; 

	 @Facebook
	 private String app_data; 

	 @Facebook
	 private String app_id; 

	 @Facebook
	 private String attachment; 

	 @Facebook
	 private String attribution; 

	 @Facebook
	 private String call_to_action; 

	 @Facebook
	 private String claim_count; 

	 @Facebook
	 private String comment_info; 

	 @Facebook
	 private String created_time; 

	 @Facebook
	 private String description; 

	 @Facebook
	 private String description_tags; 

	 @Facebook
	 private String expiration_timestamp; 

	 @Facebook
	 private String feed_targeting; 

	 @Facebook
	 private String filter_key; 

	 @Facebook
	 private String impressions; 

	 @Facebook
	 private String is_exportable; 

	 @Facebook
	 private String is_hidden; 

	 @Facebook
	 private String is_popular; 

	 @Facebook
	 private String is_published; 

	 @Facebook
	 private String like_info; 

	 @Facebook
	 private String message; 

	 @Facebook
	 private String message_tags; 

	 @Facebook
	 private String parent_post_id; 

	 @Facebook
	 private String permalink; 

	 @Facebook
	 private String place; 

	 @Facebook
	 private String post_id; 

	 @Facebook
	 private String privacy; 

	 @Facebook
	 private String promotion_status; 

	 @Facebook
	 private String scheduled_publish_time; 

	 @Facebook
	 private String share_count; 

	 @Facebook
	 private String share_info; 

	 @Facebook
	 private String source_id; 

	 @Facebook
	 private String subscribed; 

	 @Facebook
	 private String tagged_ids; 

	 @Facebook
	 private String target_id; 

	 @Facebook
	 private String targeting; 

	 @Facebook
	 private String timeline_visibility; 

	 @Facebook
	 private String type; 

	 @Facebook
	 private String updated_time; 

	 @Facebook
	 private String via_id; 

	 @Facebook
	 private String viewer_id; 

	 @Facebook
	 private String with_location; 

	 @Facebook
	 private String with_tags;  
	 
	 @Facebook
	 private String xid;
	
	public String getAction_links() {
		return action_links;
	}

	public String getActor_id() {
		return actor_id;
	}

	public String getApp_data() {
		return app_data;
	}

	public String getApp_id() {
		return app_id;
	}

	public String getAttachment() {
		return attachment;
	}

	public String getAttribution() {
		return attribution;
	}

	public String getCall_to_action() {
		return call_to_action;
	}

	public String getClaim_count() {
		return claim_count;
	}

	public String getComment_info() {
		return comment_info;
	}

	public String getCreated_time() {
		return created_time;
	}

	public String getDescription() {
		return description;
	}

	public String getDescription_tags() {
		return description_tags;
	}

	public String getExpiration_timestamp() {
		return expiration_timestamp;
	}

	public String getFeed_targeting() {
		return feed_targeting;
	}

	public String getFilter_key() {
		return filter_key;
	}

	public String getImpressions() {
		return impressions;
	}

	public String getIs_exportable() {
		return is_exportable;
	}

	public String getIs_hidden() {
		return is_hidden;
	}

	public String getIs_popular() {
		return is_popular;
	}

	public String getIs_published() {
		return is_published;
	}

	public String getLike_info() {
		return like_info;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage_tags() {
		return message_tags;
	}

	public String getParent_post_id() {
		return parent_post_id;
	}

	public String getPermalink() {
		return permalink;
	}

	public String getPlace() {
		return place;
	}

	public String getPost_id() {
		return post_id;
	}

	public String getPrivacy() {
		return privacy;
	}

	public String getPromotion_status() {
		return promotion_status;
	}

	public String getScheduled_publish_time() {
		return scheduled_publish_time;
	}

	public String getShare_count() {
		return share_count;
	}

	public String getShare_info() {
		return share_info;
	}

	public String getSource_id() {
		return source_id;
	}

	public String getSubscribed() {
		return subscribed;
	}

	public String getTagged_ids() {
		return tagged_ids;
	}

	public String getTarget_id() {
		return target_id;
	}

	public String getTargeting() {
		return targeting;
	}

	public String getTimeline_visibility() {
		return timeline_visibility;
	}

	public String getType() {
		return type;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public String getVia_id() {
		return via_id;
	}

	public String getViewer_id() {
		return viewer_id;
	}

	public String getWith_location() {
		return with_location;
	}

	public String getWith_tags() {
		return with_tags;
	}

	public String getXid() {
		return xid;
	}


	public String toString(){
		return this.getPost_id() +SocialConnectorClient.DEL+
				this.getSource_id() +SocialConnectorClient.DEL+
				this.getCreated_time() +SocialConnectorClient.DEL+
				this.getActor_id() +SocialConnectorClient.DEL+
				this.getMessage().replaceAll("\\r|\\n", "") +SocialConnectorClient.DEL+
				this.getAttachment();
	}
	 
	public HashMap<String, String> getObjectMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("actor_id", getActor_id());
		map.put("created_time", getCreated_time());
		map.put("message", getMessage());
		map.put("post_id", getPost_id());
		map.put("source_id", getSource_id());
				
		map.put("attachment", getAttachment());
		map.put("action_links", getAction_links());
		map.put("app_data", getApp_data());
		map.put("app_id", getApp_id());
		map.put("attachment", getAttachment());
		map.put("attribution", getAttribution());
		map.put("call_to_action", getCall_to_action());
		map.put("claim_count", getClaim_count());
		map.put("comment_info", getComment_info());
		map.put("description", getDescription());
		map.put("description_tags", getDescription_tags());
		map.put("expiration_timestamp", getExpiration_timestamp());
		map.put("feed_targeting", getFeed_targeting());
		map.put("filter_key", getFilter_key());
		map.put("is_exportable", getIs_exportable());
		map.put("is_hidden", getIs_hidden());
		map.put("is_popular", getIs_popular());
		map.put("like_info", getLike_info());
		map.put("message_tags", getMessage_tags());
		map.put("parent_post_id", getParent_post_id());
		map.put("permalink", getPermalink());
		map.put("place", getPlace());
		map.put("privacy", getPrivacy());
		map.put("promotion_status", getPromotion_status());
		map.put("scheduled_publish_time", getScheduled_publish_time());
		map.put("share_count", getShare_count());
		map.put("share_info", getShare_info());
		map.put("subscribed", getSubscribed());
		map.put("tagged_ids",getTagged_ids());
		map.put("target_id", getTarget_id());
		map.put("targeting",getTargeting());
		map.put("timeline_visibility", getTimeline_visibility());
		map.put("type",getType());
		map.put("updated_time", getUpdated_time());
		map.put("via_id", getVia_id());
		map.put("viewer_id", getViewer_id());
		map.put("with_location", getWith_location());
		map.put("with_tags", getWith_tags());
		map.put("xid", getXid());
		
//action_links,actor_id,app_data,app_id,attachment,attribution,call_to_action,claim_count,comment_info,created_time,description
//description_tags,expiration_timestamp,feed_targeting,filter_key,impressions,is_exportable,is_hidden,is_popular,is_published,like_info,
//message,message_tags,parent_post_id,permalink,place,post_id,privacy,promotion_status,scheduled_publish_time,share_count,share_info,source_id,
//subscribed,tagged_ids,target_id,targeting,timeline_visibility,type,updated_time,via_id,viewer_id,with_location,with_tags,xid
	
		
		return map;
	}
}
