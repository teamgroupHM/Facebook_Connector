package com.happiestminds.socialconnectors.tool.facebook;

import java.util.HashMap;

import com.happiestminds.demo.SocialConnectorClient;
import com.restfb.Facebook;

public class FBUser implements FBTable{
	
//	  @Facebook
//	  private String uid;
//
//	  @Facebook
//	  private String name;
//	  
//	  @Facebook
//	  private String timezone;
//	  
//	  @Facebook
//	  private String sex;
//	  
//	  @Facebook
//	  private String birthday;
//	  
//	  @Facebook
//	  private String hometown_location;
//	  
//	  @Facebook
//	  private String current_location;
//	  
//	  @Facebook
//	  private String relationship_status;
//	  
//
//	public String getUid() {
//		return uid;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getTimezone() {
//		return timezone;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public String getBirthday() {
//		return birthday;
//	}
//
//	public String getHometown_location() {
//		return hometown_location;
//	}
//
//	public String getCurrent_location() {
//		return current_location;
//	}
//
//	public String getRelationship_status() {
//		return relationship_status;
//	}
	
	 @Facebook
	 private String about_me; 

	 @Facebook
	 private String activities; 

	 @Facebook
	 private String affiliations; 

	 @Facebook
	 private String age_range; 

	 @Facebook
	 private String allowed_restrictions; 

	 @Facebook
	 private String birthday; 

	 @Facebook
	 private String birthday_date; 

	 @Facebook
	 private String books; 

	 @Facebook
	 private String can_message; 

	 @Facebook
	 private String can_post; 

	 @Facebook
	 private String contact_email; 

	 @Facebook
	 private String currency; 

	 @Facebook
	 private String current_address; 

	 @Facebook
	 private String current_location; 

	 @Facebook
	 private String devices; 

	 @Facebook
	 private String education; 

	 @Facebook
	 private String email; 

	 @Facebook
	 private String email_hashes; 

	 @Facebook
	 private String first_name; 

	 @Facebook
	 private String friend_count; 

	 @Facebook
	 private String friend_request_count; 

	 @Facebook
	 private String has_timeline; 

	 @Facebook
	 private String hometown_location; 

	 @Facebook
	 private String inspirational_people; 

	 @Facebook
	 private String install_type; 

	 @Facebook
	 private String interests; 

	 @Facebook
	 private String is_app_user; 

	 @Facebook
	 private String is_blocked; 

	 @Facebook
	 private String is_verified; 

	 @Facebook
	 private String languages; 

	 @Facebook
	 private String last_name; 

	 @Facebook
	 private String likes_count; 

	 @Facebook
	 private String locale; 

	 @Facebook
	 private String meeting_for; 

	 @Facebook
	 private String meeting_sex; 

	 @Facebook
	 private String middle_name; 

	 @Facebook
	 private String movies; 

	 @Facebook
	 private String music; 

	 @Facebook
	 private String mutual_friend_count; 

	 @Facebook
	 private String name; 

	 @Facebook
	 private String name_format; 

	 @Facebook
	 private String notes_count; 

	 @Facebook
	 private String online_presence; 

	 @Facebook
	 private String payment_pricepoints; 

	 @Facebook
	 private String pic; 

	 @Facebook
	 private String pic_big; 

	 @Facebook
	 private String pic_big_with_logo; 

	 @Facebook
	 private String pic_cover; 

	 @Facebook
	 private String pic_small; 

	 @Facebook
	 private String pic_small_with_logo; 

	 @Facebook
	 private String pic_square; 

	 @Facebook
	 private String pic_square_with_logo; 

	 @Facebook
	 private String pic_with_logo; 

	 @Facebook
	 private String political; 

	 @Facebook
	 private String profile_blurb; 

	 @Facebook
	 private String profile_update_time; 

	 @Facebook
	 private String profile_url; 

	 @Facebook
	 private String proxied_email; 

	 @Facebook
	 private String quotes; 

	 @Facebook
	 private String relationship_status; 

	 @Facebook
	 private String religion; 

	 @Facebook
	 private String search_tokens; 

	 @Facebook
	 private String security_settings; 

	 @Facebook
	 private String sex; 

	 @Facebook
	 private String significant_other_id; 

	 @Facebook
	 private String sort_first_name; 

	 @Facebook
	 private String sort_last_name; 

	 @Facebook
	 private String sports; 

	 @Facebook
	 private String subscriber_count; 

	 @Facebook
	 private String third_party_id; 

	 @Facebook
	 private String timezone; 

	 @Facebook
	 private String tv; 

	 @Facebook
	 private String uid; 

	 @Facebook
	 private String verified; 

	 @Facebook
	 private String video_upload_limits; 

	 @Facebook
	 private String viewer_can_send_gift; 

	 @Facebook
	 private String website; 

	 @Facebook
	 private String work;
	 
	 
	public String getAbout_me() {
		return about_me;
	}

	public String getActivities() {
		return activities;
	}

	public String getAffiliations() {
		return affiliations;
	}

	public String getAge_range() {
		return age_range;
	}

	public String getAllowed_restrictions() {
		return allowed_restrictions;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getBirthday_date() {
		return birthday_date;
	}

	public String getBooks() {
		return books;
	}

	public String getCan_message() {
		return can_message;
	}

	public String getCan_post() {
		return can_post;
	}

	public String getContact_email() {
		return contact_email;
	}

	public String getCurrency() {
		return currency;
	}

	public String getCurrent_address() {
		return current_address;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public String getDevices() {
		return devices;
	}

	public String getEducation() {
		return education;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail_hashes() {
		return email_hashes;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getFriend_count() {
		return friend_count;
	}

	public String getFriend_request_count() {
		return friend_request_count;
	}

	public String getHas_timeline() {
		return has_timeline;
	}

	public String getHometown_location() {
		return hometown_location;
	}

	public String getInspirational_people() {
		return inspirational_people;
	}

	public String getInstall_type() {
		return install_type;
	}

	public String getInterests() {
		return interests;
	}

	public String getIs_app_user() {
		return is_app_user;
	}

	public String getIs_blocked() {
		return is_blocked;
	}

	public String getIs_verified() {
		return is_verified;
	}

	public String getLanguages() {
		return languages;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getLikes_count() {
		return likes_count;
	}

	public String getLocale() {
		return locale;
	}

	public String getMeeting_for() {
		return meeting_for;
	}

	public String getMeeting_sex() {
		return meeting_sex;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public String getMovies() {
		return movies;
	}

	public String getMusic() {
		return music;
	}

	public String getMutual_friend_count() {
		return mutual_friend_count;
	}

	public String getName() {
		return name;
	}

	public String getName_format() {
		return name_format;
	}

	public String getNotes_count() {
		return notes_count;
	}

	public String getOnline_presence() {
		return online_presence;
	}

	public String getPayment_pricepoints() {
		return payment_pricepoints;
	}

	public String getPic() {
		return pic;
	}

	public String getPic_big() {
		return pic_big;
	}

	public String getPic_big_with_logo() {
		return pic_big_with_logo;
	}

	public String getPic_cover() {
		return pic_cover;
	}

	public String getPic_small() {
		return pic_small;
	}

	public String getPic_small_with_logo() {
		return pic_small_with_logo;
	}

	public String getPic_square() {
		return pic_square;
	}

	public String getPic_square_with_logo() {
		return pic_square_with_logo;
	}

	public String getPic_with_logo() {
		return pic_with_logo;
	}

	public String getPolitical() {
		return political;
	}

	public String getProfile_blurb() {
		return profile_blurb;
	}

	public String getProfile_update_time() {
		return profile_update_time;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public String getProxied_email() {
		return proxied_email;
	}

	public String getQuotes() {
		return quotes;
	}

	public String getRelationship_status() {
		return relationship_status;
	}

	public String getReligion() {
		return religion;
	}

	public String getSearch_tokens() {
		return search_tokens;
	}

	public String getSecurity_settings() {
		return security_settings;
	}

	public String getSex() {
		return sex;
	}

	public String getSignificant_other_id() {
		return significant_other_id;
	}

	public String getSort_first_name() {
		return sort_first_name;
	}

	public String getSort_last_name() {
		return sort_last_name;
	}

	public String getSports() {
		return sports;
	}

	public String getSubscriber_count() {
		return subscriber_count;
	}

	public String getThird_party_id() {
		return third_party_id;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getTv() {
		return tv;
	}

	public String getUid() {
		return uid;
	}

	public String getVerified() {
		return verified;
	}

	public String getVideo_upload_limits() {
		return video_upload_limits;
	}

	public String getViewer_can_send_gift() {
		return viewer_can_send_gift;
	}

	public String getWebsite() {
		return website;
	}

	public String getWork() {
		return work;
	}

	public String toString(){
		return this.getUid()+SocialConnectorClient.DEL+
				this.getName()+SocialConnectorClient.DEL+
				this.getTimezone()+SocialConnectorClient.DEL+
				this.getSex()+SocialConnectorClient.DEL+
				this.getBirthday()+SocialConnectorClient.DEL+
				this.getHometown_location()+SocialConnectorClient.DEL+
				this.getCurrent_location()+SocialConnectorClient.DEL+
				this.getRelationship_status();
	}
	
	public HashMap<String, String> getObjectMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("about_me",getAbout_me());
		map.put("activities",getActivities());
		map.put("affiliations",getAffiliations());
		map.put("age_range",getAge_range());
		map.put("allowed_restrictions",getAllowed_restrictions());
		map.put("birthday",getBirthday());
		map.put("birthday_date",getBirthday_date());
		map.put("books",getBooks());
		map.put("can_message",getCan_message());
		map.put("can_post",getCan_post());
		map.put("contact_email",getContact_email());
		map.put("currency",getCurrency());
		map.put("current_address",getCurrent_address());
		map.put("current_location",getCurrent_location());
		map.put("devices",getDevices());
		map.put("education",getEducation());
		map.put("email",getEmail());
		map.put("email_hashes",getEmail_hashes());
		map.put("first_name",getFirst_name());
		map.put("friend_count",getFriend_count());
		map.put("friend_request_count",getFriend_request_count());
		map.put("has_timeline",getHas_timeline());
		map.put("hometown_location",getHometown_location());
		map.put("inspirational_people",getInspirational_people());
		map.put("install_type",getInstall_type());
		map.put("interests",getInterests());
		map.put("is_app_user",getIs_app_user());
		map.put("is_blocked",getIs_blocked());
		map.put("is_verified",getIs_verified());
		map.put("languages",getLanguages());
		map.put("last_name",getLast_name());
		map.put("likes_count",getLikes_count());
		map.put("locale",getLocale());
		map.put("meeting_for",getMeeting_for());
		map.put("meeting_sex",getMeeting_sex());
		map.put("middle_name",getMiddle_name());
		map.put("movies",getMovies());
		map.put("music",getMusic());
		map.put("mutual_friend_count",getMutual_friend_count());
		map.put("name",getName());
		map.put("name_format",getName_format());
		map.put("notes_count",getNotes_count());
		map.put("online_presence",getOnline_presence());
		map.put("payment_pricepoints",getPayment_pricepoints());
		map.put("pic",getPic());
		map.put("pic_big",getPic_big());
		map.put("pic_big_with_logo",getPic_big_with_logo());
		map.put("pic_cover",getPic_cover());
		map.put("pic_small",getPic_small());
		map.put("pic_small_with_logo",getPic_small_with_logo());
		map.put("pic_square",getPic_square());
		map.put("pic_square_with_logo",getPic_square_with_logo());
		map.put("pic_with_logo",getPic_with_logo());
		map.put("political",getPolitical());
		map.put("profile_blurb",getProfile_blurb());
		map.put("profile_update_time",getProfile_update_time());
		map.put("profile_url",getProfile_url());
		map.put("proxied_email",getProxied_email());
		map.put("quotes",getQuotes());
		map.put("relationship_status",getRelationship_status());
		map.put("religion",getReligion());
		map.put("search_tokens",getSearch_tokens());
		map.put("security_settings",getSecurity_settings());
		map.put("sex",getSex());
		map.put("significant_other_id",getSignificant_other_id());
		map.put("sort_first_name",getSort_first_name());
		map.put("sort_last_name",getSort_last_name());
		map.put("sports",getSports());
		map.put("subscriber_count",getSubscriber_count());
		map.put("third_party_id",getThird_party_id());
		map.put("timezone",getTimezone());
		map.put("tv",getTv());
		map.put("uid",getUid());
		map.put("verified",getVerified());
		map.put("video_upload_limits",getVideo_upload_limits());
		map.put("viewer_can_send_gift",getViewer_can_send_gift());
		map.put("website",getWebsite());
		map.put("work",getWork());

//		map.put("uid", getUid());
//		map.put("name", getName());
//		map.put("timezone", getTimezone());
//		map.put("sex", getSex());
//		map.put("birthday", getBirthday());
//		map.put("hometown_location", getHometown_location());
//		map.put("current_location", getCurrent_location());
//		map.put("relationship_status", getRelationship_status());
		
		return map;
	}
}
