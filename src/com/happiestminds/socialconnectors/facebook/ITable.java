package com.happiestminds.socialconnectors.facebook;

import java.util.List;

import com.restfb.FacebookClient;

public interface ITable {
	ITable createTable();
	
	String getQuery();
	String getSortColumn();
	void setQuery(FacebookClient fbClient, ITable table, String outputFile, List<String> postIdList,String delimit, String... qualifier);
	void createFile(FacebookClient fbClient, ITable table, String outputFile);
	String getQuailiferString(String... qualifier);
}
