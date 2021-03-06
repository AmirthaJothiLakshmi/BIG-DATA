package log;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,Text,NullWritable,Text> {
	
	public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
		for (Text value : values) {
			context.write(null, value);
		}		
	}
}
