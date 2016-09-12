package lp;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class logreducer extends Reducer<Text,IntWritable, Text, IntWritable>{
public void reduce(Text inkey,Iterable<IntWritable> vals,Context context) 
{
int count = 0;
for(IntWritable value : vals){
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
