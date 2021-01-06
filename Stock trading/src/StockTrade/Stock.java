package StockTrade;


import java.text.*;
import java.util.*;


public class Stock {

	 private String name;
	 private String key;
	 ArrayList<SpotPrice> priceHistory = new ArrayList<SpotPrice>();
	 SpotPrice currentPrice; 
	 
	 private double delta;
     private double deltaPercentage;
     private double change;
     private double changePercentage;
	
     
     
     NumberFormat nf = NumberFormat.getInstance();
     DecimalFormat df = new DecimalFormat("###.###%");
     
     
     
     public Stock(String key, String name, double price, int year, int month, int date){
 		this.key = key;
 		this.name = name;
 		currentPrice = new SpotPrice(price, year, month, date);
 		priceHistory = new ArrayList<SpotPrice>();
 		}
     
     
     public Stock(String key, String name, double price){
			this.key = key;
			this.name = name;
			GregorianCalendar date = new GregorianCalendar();
			currentPrice = new SpotPrice(price, date);
			priceHistory = new ArrayList<SpotPrice>();	
     	}
     
     
     void setPrice(double price, int year, int month, int date){
 		SpotPrice oldPrice = new SpotPrice(currentPrice);
 		priceHistory.add(oldPrice);
 		currentPrice = new SpotPrice(price, year, month, date);
 		change = (currentPrice.getPrice()-oldPrice.getPrice());
 		changePercentage = change/ oldPrice.getPrice();
 		}
 		
     void setPrice(double price){
		
    	 SpotPrice oldPrice = new SpotPrice(currentPrice);
			priceHistory.add(oldPrice);
			GregorianCalendar date = new GregorianCalendar();
			date.add(Calendar.DATE, 1);
			currentPrice = new SpotPrice(price, date);
			change = (currentPrice.getPrice()-oldPrice.getPrice());
			changePercentage = change/ oldPrice.getPrice();
			}
	
     public void update(double d) {
 	    delta = d;
 	    deltaPercentage = d/currentPrice.price;
 	    currentPrice.price += delta;
 	  }
     
     
     public double getPrice(){
 		return currentPrice.getPrice(); 
 		
       }
     
     public GregorianCalendar getDate(){
			return currentPrice.getDate(); 
			}
     
     void getPriceHistory(){
    		
    	 for (SpotPrice spot : priceHistory) {
			    System.out.println(spot.toString());
			}
    	 
    	 	}
    		
     public String toString(){	
    			return("Share: "+ name+" "+key+" "+currentPrice.toString()+" Daily change: "+nf.format(change)+" , "+df.format(changePercentage));}

    		

     public SpotPrice getSpotPrice() {
    			return currentPrice;
    		}

     
     
     public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setPriceHistory(ArrayList<SpotPrice> priceHistory) {
		
		this.priceHistory = priceHistory;
	}
	
	public double getDelta() {
		return delta;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	public double getDeltaPercentage() {
		return deltaPercentage;
	}
	public void setDeltaPercentage(double deltaPercentage) {
		this.deltaPercentage = deltaPercentage;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getChangePercentage() {
		return changePercentage;
	}
	public void setChangePercentage(double changePercentage) {
		this.changePercentage = changePercentage;
	}
	
	
}
