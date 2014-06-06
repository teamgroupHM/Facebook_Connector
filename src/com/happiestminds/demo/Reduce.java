package com.happiestminds.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import com.happiestminds.socialconnectors.facebook.FacebookAPI;
import com.happiestminds.socialconnectors.facebook.TableMap;

public class Reduce extends MapReduceBase implements Reducer<IntWritable, Text, IntWritable, IntWritable> {
	  private String pageId;
	  private String appId;
	  private String secretKey;
	  private String delimit;
	  //private Path[] localFiles;
	  private URI[] localFiles;
	  
	  @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	  public void configure(JobConf job) { // works on unix env.
		  pageId = job.get("post_id");
	      appId = job.get("appId");
	      secretKey = job.get("secretKey");
	      delimit = job.get("delimit");
	      
	      TableMap.columnMap = new TreeMap();
	      
	       try {
	        	localFiles = DistributedCache.getCacheFiles(job);
	        	
	        	if (localFiles != null && localFiles.length > 0) {
					Configuration conf = new Configuration();
					FileSystem fs = FileSystem.get(localFiles[0], conf);
					
					if (true) {
						BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(new Path(localFiles[0]))));
						
						try {
							  String line = br.readLine();
							  System.out.println("line: " + line);
							  System.out.println("The delimiter coming from job conf is "+delimit);
							  
							  while (line != null && !line.equals("")) {
								  System.out.println("config line: " + line);  
								  String[] tableColumn = line.split("::");
						            String table = tableColumn[0] != null ? tableColumn[0].trim() : null;
						            String columns = tableColumn[1] != null ? tableColumn[1].trim() : null;
						            String outputFile = tableColumn[2] != null ? tableColumn[2].trim() : null;
						            
						            if(table != null && columns != null && outputFile != null){
						            	TableMap.columnMap.put(table, columns);
						            	TableMap.fileMap.put(table, outputFile);
						            }
						         line = br.readLine();    
						        }
							} catch(Exception e){
								e.printStackTrace();
							}finally {
							  br.close();
							}
					}
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  /*public void configure(JobConf job) { // works on VM eclipse
		  System.out.println("configured");
		  pageId = job.get("post_id");
	      appId = job.get("appId");
	      secretKey = job.get("secretKey");
	      
	      TableMap.columnMap = new TreeMap();
	      
	       try {
	        	localFiles = DistributedCache.getLocalCacheFiles(job);
	        	
	        	if (localFiles != null && localFiles.length > 0) {
					Configuration conf = new Configuration();
					FileSystem fs = FileSystem.get(conf);
					
					Path inFile = localFiles[0];
					System.out.println("config file name: " + localFiles[0]);
					if (fs.exists(inFile)) {
						System.out.println("file exist");
						BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(inFile)));
						System.out.println("buffer reader got");
						try {
							  String line = br.readLine();
							  System.out.println("line: " + line);
							  while (line != null && !line.equals("")) {
								  System.out.println("config line: " + line);  
								  String[] tableColumn = line.split("::");
						            String table = tableColumn[0] != null ? tableColumn[0].trim() : null;
						            String columns = tableColumn[1] != null ? tableColumn[1].trim() : null;
						            String outputFile = tableColumn[2] != null ? tableColumn[2].trim() : null;
						            
						            if(table != null && columns != null && outputFile != null){
						            	TableMap.columnMap.put(table, columns);
						            	TableMap.fileMap.put(table, outputFile);
						            }
						         line = br.readLine();    
						        }
							} catch(Exception e){
								e.printStackTrace();
							}finally {
							  br.close();
							}
					}
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/
	  
public void reduce(IntWritable key, Iterator<Text> values, OutputCollector<IntWritable, IntWritable> output, Reporter reporter) throws IOException {
    int sum = 0;
    System.out.println("I am reducer for key: " + key);
    List<String> postIdList = new ArrayList<String>();
    while (values.hasNext()) {
    	  postIdList.add(values.next().toString());
    	  sum++;
    }
    try{
    	System.out.println("processing for postId: " + sum);
    	FacebookAPI.processTables(key.get(), postIdList, pageId,appId,secretKey,delimit);
    	}
    catch(Exception e){
    	e.printStackTrace();
    }
    
    System.out.println("total post got: " + sum);
    output.collect(key, new IntWritable(sum));
  }
}
