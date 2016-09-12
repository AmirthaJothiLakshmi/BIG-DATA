package wc;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mymapper extends Mapper<LongWritable , Text, Text, IntWritable>{
public void map(LongWritable inkey, Text inval,Text name,Context context)
{
String line = inval.toString();
String [ ] lineparts = line.split(" ");

for(String singlevalue : lineparts){
Text mapoutKey = new Text(singlevalue);
IntWritable mapoutval = new IntWritable(1);
try {
	context.write(mapoutKey, mapoutval);
} catch (IOException | InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
}