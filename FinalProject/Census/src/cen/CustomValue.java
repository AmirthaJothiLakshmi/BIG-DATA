package cen;



import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class CustomValue implements Writable{
	
	private Text gender;
	private DoubleWritable income;
	private DoubleWritable taxper;
	private Text taxfiler;

	public CustomValue(DoubleWritable income, DoubleWritable taxper, Text gender,Text taxfiler)
	{
		this.income = income;
		this.taxper = taxper;
		this.gender = gender;
		this.taxfiler=taxfiler;
		
	}
	
	public CustomValue(){
		
		gender = new Text();
		income = new DoubleWritable();
		taxper = new DoubleWritable();
		taxfiler = new Text();
		
	}
	
	public DoubleWritable getincome(){
		return income;
	}
	
	public void setincome(DoubleWritable income) {
		this.income = income;
	}


	public DoubleWritable getTaxper() {
		return taxper;
	}

	public void setTaxper(DoubleWritable taxper) {
		this.taxper = taxper;
	}

	public Text getGender() {
		return gender;
	}

	public void setGender(Text gender) {
		this.gender = gender;
	}
	
	Text getTaxfiler() {
		return taxfiler;
	}

	void setTaxfiler(Text taxfiler) {
		this.taxfiler = taxfiler;
	}
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		gender.readFields(arg0);
		income.readFields(arg0);
		taxper.readFields(arg0);
		taxfiler.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		gender.write(arg0);
		income.write(arg0);
		taxper.write(arg0);
		taxfiler.write(arg0);
	}
	

}
