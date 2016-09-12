package join;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class map1 extends Mapper<LongWritable,Text,Text,Text> {

	public void map(LongWritable inkey, Text inval,Context context)
	{
	String line = inval.toString();
	String [ ] lineparts = line.split(",");
String Uid = "Uid:"+lineparts[0];
String name = "Name:"+lineparts[1];
	
	Text outKey = new Text(Uid);
	Text outval= new Text(name);
	try {
		context.write(outKey, outval);
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	}
	
