package tk5;

import javax.xml.soap.Text;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class monthpartitioner extends Partitioner<Text,IntWritable>{
	public int getPartition(Text inval, IntWritable mapval,int numred){
		String line = inval.toString();
		
		if(line.equalsIgnoreCase("01"))
		{
			return 0;
	}
		else if(line.equalsIgnoreCase("02"))
		{
			return 1;
		}
		
		else if(line.equalsIgnoreCase("03"))
		{
			return 3;
		}
		else if(line.equalsIgnoreCase("04"))
		{
			return 4;
		}
		else if(line.equalsIgnoreCase("05"))
		{
			return 5;
		}
		else if(line.equalsIgnoreCase("06"))
		{
			return 6;
		}
		else if(line.equalsIgnoreCase("07"))
		{
			return 7;
		}
		else if(line.equalsIgnoreCase("08"))
		{
			return 8;
		}
		else if(line.equalsIgnoreCase("09"))
		{
			return 9;
		}
		else if(line.equalsIgnoreCase("10"))
		{
			return 10;
		}
		else if(line.equalsIgnoreCase("11"))
		{
			return 11;
		}
		else 
		{
			return 12;
		}
	}
}

