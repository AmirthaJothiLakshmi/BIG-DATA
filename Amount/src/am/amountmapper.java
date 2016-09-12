package am;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class amountmapper extends Mapper<LongWritable, Text, Text, NullWritable> {
public void map(LongWritable name,Text v,Context context)throws IOException,InterruptedException{
	String value = v.toString();
	String [] val1 = value.split(",");
	double amt = Double.parseDouble(val1[3]);
if(amt>160.00){
	Text Key = new Text(value);
	context.write(Key,null);
}
}
}
