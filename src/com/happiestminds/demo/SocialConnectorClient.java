package com.happiestminds.demo;

import java.io.File;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.server.namenode.status_jsp;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

@SuppressWarnings("unused")
public class SocialConnectorClient extends Configured implements Tool {

	public static String DEL;// = "~";
	
	//@Override
    @SuppressWarnings("deprecation")
	public int run(String[] args) throws Exception {
		Configuration config = getConf();
		//config.reloadConfiguration();
		String pageId = config.get("pageId");
		int numberOfReducers = config.getInt("reducers", 4);
		String appId = config.get("appId");
		String secretKey = config.get("secretKey");
		String inputPath = config.get("inputPath");
		String outputPath = config.get("outputPath");
		String sampleRun = config.get("sample");
		String tables = config.get("tablesFile");
		String delimit = config.get("delimiter");
		
		
		if(delimit != null) DEL = delimit;
		else DEL = "~";
		
		if(pageId == null || appId == null || secretKey == null || inputPath == null || outputPath == null || tables == null){
			throw new Exception("Usage: \n" +
					"-D pageId=<pageId> -D appId=<appId> -D secretKey=<key> -D delimiter=<Delimiter>" +
					"-D inputPath=<path> -D outputPath=<path> -D tablesFile=<config file>");
		}
		
		JobConf conf = new JobConf(SocialConnectorClient.class);

		DistributedCache.addCacheFile(new File(tables).toURI(), conf); //(works on windows)
		//DistributedCache.addCacheFile(new URI(tables),conf); // (works on linux/unix)
		conf.setJobName("Facebook load client");

		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(Text.class);

		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setMapperClass(Map.class);
		conf.setReducerClass(Reduce.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(MultiFileOutput.class);

		// configuration should contain reference to your namenode
		FileSystem fs = FileSystem.get(new Configuration());
		fs.delete(new Path(outputPath), true); // true stands for recursively, deleting the folder you gave

		conf.setStrings("post_id", pageId); 						
		conf.setInt("machinesInCluster", numberOfReducers);	
		conf.setStrings("appId", appId);
		conf.setStrings("secretKey", secretKey);
		conf.setStrings("delimit", delimit);
		FileInputFormat.setInputPaths(conf, new Path(inputPath));		
		FileOutputFormat.setOutputPath(conf, new Path(outputPath)); 	
		conf.setBoolean("sampleRun", sampleRun == null ? false : sampleRun.equals("true") ? true : false);
		
		System.out.println(DEL);
		JobClient.runJob(conf);
		
		return 0;
    }        

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new SocialConnectorClient(), args);
		System.exit(exitCode);
	}
	
	/*public static void main(String[] rawArgs) throws Exception {
		
		GenericOptionsParser parser = new GenericOptionsParser(rawArgs);
        //Configuration conf1 = parser.getConfiguration();
        String[] args = parser.getRemainingArgs();
		
		JobConf conf = new JobConf(SocialConnectorClient.class);

		DistributedCache.addCacheFile(new File("facebook/config").toURI(), conf); //(works on windows)
		//DistributedCache.addCacheFile(new URI(args[7]),conf); // (works on linux/unix)
		conf.setJobName("Facebook load client");

		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(Text.class);

		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setMapperClass(Map.class);
		conf.setReducerClass(Reduce.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(MultiFileOutput.class);

		// configuration should contain reference to your namenode
		FileSystem fs = FileSystem.get(new Configuration());
		fs.delete(new Path(args[5]), true); // true stands for recursively, deleting the folder you gave

		conf.setStrings("post_id", args[0]); 						// post_id
		conf.setInt("machinesInCluster", Integer.parseInt(args[1]));// number of reducers	
		conf.setStrings("appId", args[2]);// number of reducers
		conf.setStrings("secretKey", args[3]);// number of reducers
		FileInputFormat.setInputPaths(conf, new Path(args[4]));		// input path
		FileOutputFormat.setOutputPath(conf, new Path(args[5])); 	// output path
		conf.setBoolean("sampleRun", args[6] == null ? false : args[6].equals("true") ? true : false);// number of reducers
		
		JobClient.runJob(conf);
	}*/
}
