package Edu_Task1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		/* Reading the entire and then splitting it
		 * and storing it in array
		 */
		
		String line=value.toString();
		String []lineParts=line.split(",");
		
		String education=lineParts[1]; // storing the age
		String gender=lineParts[3]; // storing the income
		/* Passing age and income as key and value 
		 * respectively to the Reducer for further computation
		 */
		context.write(new Text(education), new Text(gender));
			
	}	

}
