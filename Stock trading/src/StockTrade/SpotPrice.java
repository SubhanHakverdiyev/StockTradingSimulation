package StockTrade;
import java.text.*;
import java.util.*;



public class SpotPrice {
	
	public  double price;
	public GregorianCalendar date = new GregorianCalendar();
	NumberFormat nf = NumberFormat.getInstance();
	DecimalFormat df = new DecimalFormat("###.###%");
	DateFormat dtf = DateFormat.getDateInstance();
	
	
	public SpotPrice(double price, int year, int month, int date)
	
	{
		this.price = price;
		this.date.set(year, month-1, date);
	}
	
	
	SpotPrice(SpotPrice price)
	{
		this.price = price.price;
		this.date = price.date;
	}
	
	SpotPrice(double price, GregorianCalendar date)
	{
		this.price = price;
		this.date = date;
	}
	
	
	GregorianCalendar getDate()
	{
			return date;
	}
	
	
	public String toString()
	{
	
		Date d = date.getTime();
	return(nf.format(price) +"  "+dtf.format(d));
	
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
