package com.happiestminds.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import com.happiestminds.socialconnectors.facebook.FacebookAPI;
import com.happiestminds.socialconnectors.facebook.FacebookStream;

@SuppressWarnings("unused")
public class Map extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, Text> {
	   	private String pageId;
	    private int machinesInCluster;
		private String appId;
	    private String secretKey;
	    private Boolean sampleRun;
	    private String delimit;
	    BufferedReader cacheReader;
	    
	    public void configure(JobConf job) {
	        pageId = job.get("post_id");
	        machinesInCluster = job.getInt("machinesInCluster", 4);
	        appId = job.get("appId");
	        secretKey = job.get("secretKey");
	        sampleRun = job.getBoolean("sampleRun", false);
	        delimit=job.get("delimit");
	    }
	    
	    public void map(LongWritable key, Text value, OutputCollector<IntWritable, Text> output, Reporter reporter) throws IOException {
	      String line = value.toString();
	      
	      if(line == null || line.trim().equals("") || !line.contains("::"))
	    	  return;
	      
	      if(sampleRun)
	    	  FacebookStream.sampleRun = true;
	      
	      String tableName = line.substring(0, line.indexOf("::")).trim();
	      try{
	    	  FacebookAPI.processMandatoryTables(line,pageId,appId,secretKey,delimit);
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	      
	      if(tableName.equals("stream")){
	    	  List<String> postIds = FacebookStream.postIdAssoc;
	    	  for (int i=0; i<postIds.size(); i++) {
	    		  int keyGroup = i % machinesInCluster;
	    		  output.collect(new IntWritable(keyGroup), new Text(postIds.get(i)));
	      		}
	      }
	    }
	  }
