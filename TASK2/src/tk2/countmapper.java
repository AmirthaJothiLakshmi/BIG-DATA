package tk2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class countmapper extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable name,Text v,Context context)throws IOException,InterruptedException{
	String value = v.toString();
	String [] val1 = value.split(",");
	double amt = Double.parseDouble(val1[3]);
if(amt>160.00){
	Text Key = new Text("Amount");
	IntWritable mapnum = new IntWritable(1);
	context.write(Key,mapnum);
}
}
}
