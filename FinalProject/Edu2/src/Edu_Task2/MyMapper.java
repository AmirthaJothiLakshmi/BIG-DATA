package Edu_Task2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String line=value.toString();
		String []lineParts=line.split(",");
		
		String workedDays=lineParts[9];
		String education=lineParts[1];
		context.write(new Text(education),new Text(workedDays));
		
	}
	

}
