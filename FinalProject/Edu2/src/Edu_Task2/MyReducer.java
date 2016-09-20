package Edu_Task2;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int count=0;
		int num=0;
		
		for(Text it:value)
		{
			String n=it.toString();
			int work=Integer.parseInt(n);
			if(work>0)
			{
				count++;
			}
			else 
				num++;
			
		}
		String output= key+" "+count +" "+num;
		context.write(key,new Text(output));
	}
	

}
