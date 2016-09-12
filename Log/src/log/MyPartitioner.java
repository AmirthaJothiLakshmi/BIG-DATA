package log;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, Text> {

		public int getPartition(Text key, Text value, int numPartitions) {

			String RecordType = key.toString();
			if(RecordType.equalsIgnoreCase("error"))
			{
				return 0;
				
			}
			else if(RecordType.equalsIgnoreCase("debug"))
			{
				return 1;
			}
			else if(RecordType.equalsIgnoreCase("trace"))
			{
				return 2;
			}			
			else
			{
				return 3;
			}		
		}

	}
