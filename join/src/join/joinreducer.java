package join;


import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class joinreducer extends Reducer<Text,Text,Text,NullWritable> {
	public void reduce(Text inkey,Iterable<Text> invals,Context context)
	{
		String name ="";
		int count=0;
		Double Total = 0.0;
		for(Text a: invals){
		String lparts[] = a.toString().split(":");
		if (lparts[0].equals("Name")){
			name = lparts[1];
		}
		else if (lparts[0].equals("Amt"))
			{
			Total+=Double.parseDouble(lparts[1]);
  
		}
		
	}
	
		String Output = name+count+"INR."+Total;
		try {
			context.write(new Text(Output), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
