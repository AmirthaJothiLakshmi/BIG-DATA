package tk4;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class sdriver{
public static void main(String [ ] args) throws IOException{
Configuration conf = new Configuration();
Job job = new Job (conf, "fourth Reduce");
job.setJarByClass(sdriver.class);
job.setMapperClass(smonth.class);
job.setReducerClass(sreducer.class);
job.setNumReduceTasks(2);
job.setMapOutputKeyClass(Text.class);
job.setMapOutputValueClass(IntWritable.class);
FileInputFormat.addInputPath(job, new Path(args [0]));
FileOutputFormat.setOutputPath(job, new Path(args [1]));
try {
	System.exit(job.waitForCompletion(true)? 0 : 1);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}