package com.happiestminds.socialconnectors.facebook;

public class LoadTables {
	static{
		TableFactory.registerProduct("stream", (ITable)new FacebookStream());
		TableFactory.registerProduct("event", (ITable)new FacebookEvent());
		TableFactory.registerProduct("user", (ITable)new FacebookUser());
		TableFactory.registerProduct("comment", (ITable)new FacebookComment());
		TableFactory.registerProduct("like", (ITable)new FacebookLike());
	}
}
