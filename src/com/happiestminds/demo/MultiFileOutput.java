package com.happiestminds.demo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat;

class MultiFileOutput extends MultipleTextOutputFormat<IntWritable, IntWritable> {
    protected String generateFileNameForKeyValue(IntWritable key, IntWritable value,String name) {
            return key.toString();
    }
}
