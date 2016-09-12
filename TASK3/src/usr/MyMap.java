package usr;


import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMap extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
			String line = value.toString();
			String lineParts[] = line.split(",");
			Text mapinputkey = new Text(lineParts[2]);
			DoubleWritable mapoutvalue = new DoubleWritable(Double.parseDouble(lineParts[3]));
			
			context.write(mapinputkey,mapoutvalue );
			
		}
	}
