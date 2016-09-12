package wc;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class myreducer extends Reducer<Text,IntWritable, Text, IntWritable>{
public void reduce(Text inkey,Iterable<IntWritable> invals,Context context) 
{
int count = 0;
for(IntWritable singlevalue : invals){
count++;
}
try {
	context.write(inkey, new IntWritable(count));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
