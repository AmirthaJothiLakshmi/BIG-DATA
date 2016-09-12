package Rjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Rdriver {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Reduce Side Join");
		job.setJarByClass(Rdriver.class);
		job.setMapperClass(Rmap1.class);
		job.setMapperClass(Rmap2.class);
		job.setReducerClass(Rreduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setNumReduceTasks(1);		
		MultipleInputs.addInputPath(job, new Path(args[0]),TextInputFormat.class);
		MultipleInputs.addInputPath(job, new Path(args[1]),TextInputFormat.class);		
		
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
	}


