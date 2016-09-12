package lp;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class logmapper extends Mapper<LongWritable, Text, Text,NullWritable>{
public void map(LongWritable inkey, Text inval,Context context)throws IOException, InterruptedException
{
String nam  = inval.toString();
String [ ] namparts = nam.split("\t");
String n = namparts[3];
if(n== "[TRACE]" || n=="[ERROR]"||n=="[DEBUG]"){
	Text Key = new Text(nam);
	try {
		context.write(Key,null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
}
}
}