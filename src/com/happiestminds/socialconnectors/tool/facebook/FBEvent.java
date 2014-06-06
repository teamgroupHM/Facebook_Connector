package com.happiestminds.socialconnectors.tool.facebook;

import java.util.HashMap;

import com.happiestminds.demo.SocialConnectorClient;
import com.restfb.Facebook;

public class FBEvent implements FBTable{
		
//	  @Facebook
//	  private String eid;
//
//	  @Facebook
//	  private String name;
//	  
//	  @Facebook
//	  private String description;
//	  
//	  @Facebook
//	  private String start_time;
//	  
//	  @Facebook
//	  private String end_time;
//	  
//	  @Facebook
//	  private String creator;
//	  
//	  @Facebook
//	  private String update_time;
//	  
//	  @Facebook
//	  private String location;
//	  
//	  @Facebook
//	  private String venue;
//
//	public String getEid() {
//		return eid;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public String getStart_time() {
//		return start_time;
//	}
//
//	public String getEnd_time() {
//		return end_time;
//	}
//
//	public String getCreator() {
//		return creator;
//	}
//
//	public String getUpdate_time() {
//		return update_time;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public String getVenue() {
//		return venue;
//	}
	
	
	 @Facebook
	 private String all_members_count; 

	 @Facebook
	 private String app_id; 

	 @Facebook
	 private String attending_count; 

	 @Facebook
	 private String can_invite_friends; 

	 @Facebook
	 private String creator; 

	 @Facebook
	 private String creator_cursor; 

	 @Facebook
	 private String declined_count; 

	 @Facebook
	 private String description; 

	 @Facebook
	 private String eid; 

	 @Facebook
	 private String end_time; 

	 @Facebook
	 private String feed_targeting; 

	 @Facebook
	 private String has_profile_pic; 

	 @Facebook
	 private String hide_guest_list; 

	 @Facebook
	 private String host; 

	 @Facebook
	 private String is_date_only; 

	 @Facebook
	 private String location; 

	 @Facebook
	 private String name; 

	 @Facebook
	 private String not_replied_count; 

	 @Facebook
	 private String parent_group_id; 

	 @Facebook
	 private String pic; 

	 @Facebook
	 private String pic_big; 

	 @Facebook
	 private String pic_cover; 

	 @Facebook
	 private String pic_small; 

	 @Facebook
	 private String pic_square; 

	 @Facebook
	 private String privacy; 

	 @Facebook
	 private String start_time; 

	 @Facebook
	 private String ticket_uri; 

	 @Facebook
	 private String timezone; 

	 @Facebook
	 private String unsure_count; 

	 @Facebook
	 private String update_time; 

	 @Facebook
	 private String venue; 

	 @Facebook
	 private String version;
	 
	 public String getAll_members_count() {
			return all_members_count;
		}

		public String getApp_id() {
			return app_id;
		}

		public String getAttending_count() {
			return attending_count;
		}

		public String getCan_invite_friends() {
			return can_invite_friends;
		}

		public String getCreator() {
			return creator;
		}

		public String getCreator_cursor() {
			return creator_cursor;
		}

		public String getDeclined_count() {
			return declined_count;
		}

		public String getDescription() {
			return description;
		}

		public String getEid() {
			return eid;
		}

		public String getEnd_time() {
			return end_time;
		}

		public String getFeed_targeting() {
			return feed_targeting;
		}

		public String getHas_profile_pic() {
			return has_profile_pic;
		}

		public String getHide_guest_list() {
			return hide_guest_list;
		}

		public String getHost() {
			return host;
		}

		public String getIs_date_only() {
			return is_date_only;
		}

		public String getLocation() {
			return location;
		}

		public String getName() {
			return name;
		}

		public String getNot_replied_count() {
			return not_replied_count;
		}

		public String getParent_group_id() {
			return parent_group_id;
		}

		public String getPic() {
			return pic;
		}

		public String getPic_big() {
			return pic_big;
		}

		public String getPic_cover() {
			return pic_cover;
		}

		public String getPic_small() {
			return pic_small;
		}

		public String getPic_square() {
			return pic_square;
		}

		public String getPrivacy() {
			return privacy;
		}

		public String getStart_time() {
			return start_time;
		}

		public String getTicket_uri() {
			return ticket_uri;
		}

		public String getTimezone() {
			return timezone;
		}

		public String getUnsure_count() {
			return unsure_count;
		}

		public String getUpdate_time() {
			return update_time;
		}

		public String getVenue() {
			return venue;
		}

		public String getVersion() {
			return version;
		}
	
	public String toString(){
		return this.getEid()+SocialConnectorClient.DEL+
				this.getName()+SocialConnectorClient.DEL+
				this.getDescription().replaceAll("\\r|\\n", "")+SocialConnectorClient.DEL+
				this.getStart_time()+SocialConnectorClient.DEL+
				this.getEnd_time()+SocialConnectorClient.DEL+
				this.getUpdate_time()+SocialConnectorClient.DEL+
				this.getLocation()+SocialConnectorClient.DEL+
				this.getVenue();
	}
	
	public HashMap<String, String> getObjectMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
//all_members_count,app_id,attending_count,can_invite_friends,creator,creator_cursor,declined_count,description,eid,end_time,
//pic_small,pic_square,privacy,start_time,ticket_uri,timezone,unsure_count,update_time,venue,version,feed_targeting,
//has_profile_pic,hide_guest_list,host,is_date_only,location,name,not_replied_count,parent_group_id,pic,pic_big,pic_cover
		
		map.put("parent_group_id", getParent_group_id());
		map.put("not_replied_count", getNot_replied_count());
		map.put("is_date_only", getIs_date_only());
		map.put("host",getHost());
		map.put("hide_guest_list", getHide_guest_list());
		map.put("feed_targeting", getFeed_targeting());
		map.put("version", getVersion());
		map.put("all_members_count", getAll_members_count());
		map.put("eid", getEid());
		map.put("name", getName());
		map.put("description", getDescription());
		map.put("start_time", getStart_time());
		map.put("end_time", getEnd_time());
		map.put("creator", getCreator());
		map.put("update_time", getUpdate_time());
		map.put("location", getLocation());
		map.put("venue", getVenue());
		map.put("update_time", getUpdate_time());
		map.put("unsure_count", getUnsure_count());
		map.put("timezone",getTimezone());
		map.put("ticket_uri", getTicket_uri());
		//map.put("start_time", getStart_time());
		map.put("privacy", getPrivacy());
		//map.put("end_time", getEnd_time());
		map.put("eid", getEid());
		map.put("description", getDescription());
		map.put("creator_cursor", getCreator_cursor());
		map.put("declined_count",getDeclined_count());
		map.put("can_invite_friends", getCan_invite_friends());
		map.put("attending_count", getAttending_count());
		map.put("app_id", getApp_id());
		
		//map.put("venue", getVenue());
		
		return map;
	}

	

}
