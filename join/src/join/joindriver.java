package join;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class joindriver {
	public static void main(String [] args) throws IOException, ClassNotFoundException, InterruptedException{
		Configuration conf = new Configuration();
		Job job = new Job (conf, "Reduce Join");
		job.setJarByClass(joindriver.class);
		job.setReducerClass(joinreducer.class);
		job.setNumReduceTasks(2);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class,map1.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class,map2.class);
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
			System.exit(job.waitForCompletion(true)? 0 : 1);
		}
		}

