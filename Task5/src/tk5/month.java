package tk5;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class month extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable name,Text v,Context context)throws IOException{
	String value = v.toString();
	String [] val1 = value.split(",");
	String [] date = val1[1].split("-");
for(String mval:date)
{
	Text monthkey = new Text(date[0]);
	IntWritable monthval =new IntWritable(1);
	try {
		context.write(monthkey,monthval);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
