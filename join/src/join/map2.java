package join;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class map2 extends Mapper<LongWritable,Text,Text,Text>{

	public void map(LongWritable inkey, Text inval,Context context)
	{
	String line = inval.toString();
	String [ ] lineparts = line.split(",");
String Uid = "Uid:"+lineparts[2];
String Amt = "Amt:"+lineparts[3];
	
	Text mapoutKey = new Text(Uid);
	Text mapoutval= new Text(Amt);
	try {
		context.write(mapoutKey, mapoutval);
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	}
	

