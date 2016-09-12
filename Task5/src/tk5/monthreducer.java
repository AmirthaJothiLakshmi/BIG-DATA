package tk5;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class monthreducer extends Reducer<Text,Text,Text,NullWritable>{
	public void reduce (Text val,Iterable<Text> name,Context context)
	{
		try {
			context.write(val,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
