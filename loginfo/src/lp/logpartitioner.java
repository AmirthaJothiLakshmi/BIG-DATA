package lp;

import javax.xml.soap.Text;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class logpartitioner extends Partitioner<Text,IntWritable>{
	public int getPartition(Text inval, IntWritable mapval,int numred){
		String line = inval.toString();
		String [ ] lineparts = line.split("\t");
		String day =lineparts[3];
		if(day == "[ERROR]")
		{
			return 0;
	}
		else if(day =="[DEBUG]")
		{
			return 1;
		}
		
		else if(day == "[TRACE]")
		{
			return 2;
		}
		else 
		{
			return 3;
		}
	}
}
