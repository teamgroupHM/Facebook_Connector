package com.happiestminds.socialconnectors.facebook;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Utility {
	
	/*
	 * takes huge list and creates smaller qualifierString 
	 * by dividing bigger list into smaller list using iterationFactor
	 */
	//public static final String DELIMITER = "~~";
	
	public static BufferedWriter getWriter(String outputFile) throws Exception{
		Configuration config = new Configuration();
		FileSystem fs = FileSystem.get(config);
		
		Path filenamePath = new Path(outputFile); // Specifies a new file in HDFS.
		if (fs.exists(filenamePath)) // remove file if exist
			fs.delete(filenamePath, true);
		
		return new BufferedWriter(new OutputStreamWriter(fs.create(new Path(outputFile), true)));
	}
	
	public static List<String> getQualifierString(List<String> idsList, Double iterationFactor, boolean quotes){
		Double iteration = Math.ceil(idsList.size()/iterationFactor);
		
		int lower = 0;
		int upper = 0;
		
		List<String> qualifierList = new ArrayList<String>();
		for (int i=0; i < iteration; i++){
			String qualifierString = "";
			if(i != 0)
				lower = upper;
			
			upper = (int)((i+1) * iterationFactor);
			upper = ( upper >= idsList.size() ) ? idsList.size()-1 : upper;
			
			List<String> subIds = idsList.subList(lower, upper);
			
			for (String id : subIds) {
				id = quotes ? "'"+id+"'" : id;
				qualifierString += id + ", ";
			}
			
			if(qualifierString.length() > 2)
				qualifierString = qualifierString.substring(0, qualifierString.length()-2);
			
			qualifierList.add(qualifierString);
		}
		
		return qualifierList;
	}
}
