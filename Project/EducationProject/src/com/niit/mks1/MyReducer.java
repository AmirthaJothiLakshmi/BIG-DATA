package com.niit.mks1;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int numberOfEmployed=0;
		int numberOfUnEmployed=0;
		
		for(Text it:value)
		{
			String intermediateData=it.toString();
			int numberOfDaysWorked=Integer.parseInt(intermediateData);
			if(numberOfDaysWorked>0)
			{
				numberOfEmployed++;
			}
			else 
				numberOfUnEmployed++;
			
		}
		String outputValue="Number of Employed Person with"+key+"\n are"+numberOfEmployed +"\n And Number of UnEmployed Person are"+numberOfUnEmployed;
		context.write(key,new Text(outputValue));
	}
	

}
