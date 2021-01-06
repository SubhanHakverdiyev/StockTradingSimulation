package GUI;


import java.util.*;
import java.awt.BorderLayout;
import java.text.*;
import javax.swing.*;

import StockTrade.*;

public class DisplayData extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DateFormat dtf = DateFormat.getDateInstance();
	NumberFormat nf = NumberFormat.getInstance();
	DecimalFormat df = new DecimalFormat("###.###%");
	public static String[] keys;
	public static HashMap<String,StockMarket> marketList = new HashMap<String,StockMarket>();
	public static StockMarket usa = createUSAMarket();
	boolean monitor;
	Random rg = new Random();
	Thread runner;
	
	
	public DisplayData() {
	    // Not meant to be shown as a real frame
	    super("Thread only version . . .");
	    runner = new Thread(this);
	    runner.start();
	  }

	
	  public DisplayData(boolean monitorOn) {
	    super("Stock Market Monitor");
	    setSize(400, 100);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    monitor = monitorOn;

	    getContentPane().add(
	        new JLabel("Trading is active.  "
	            + "Close this window to close the market."),
	        BorderLayout.CENTER);
	    runner = new Thread(this);
	    runner.start();
	  }

	  
	
	public static StockMarket createUSAMarket()
	{
		
		StockMarket usa = new StockMarket("usa");
	
							Stock google = new Stock("GOOG", "Google",1764.77);
							Stock aapl = new Stock("AAPL", "IBM",127.23);
							Stock microsoft = new Stock("MSI", "Microsoft",3000);
							Stock amazon = new Stock("AMZN", "Amazon",3157);
							Stock fb = new Stock("FB", "Facebook",273.11);
							Stock tesla = new Stock("TSLA", "Tesla",633.53);
							Stock brk = new Stock("BRK.B", "Berkshire Hathaway",225.28);
							Stock visa = new Stock("V", "Visa",209.24);
							Stock wallamrt = new Stock("WMT", "Visa",145.65);
							Stock jnj = new Stock("JNJ", "Johnson & Johnson",150.45);
							Stock morgan = new Stock("JPM", "JPMorgan",120.34);
							Stock mscard = new Stock("MA", "Nvidia",531.20);
							Stock nvidia = new Stock("NVDA", "Visa",209.24);
							Stock pypl = new Stock("PYPL", "Paypal",219.71);
							Stock ko = new Stock("KO", "Coca-Cola",54.04);
							Stock nke = new Stock("NKE", "Nike",138.72);
							Stock nflx = new Stock("NFLX", "Netflix",520.38);
							Stock intc = new Stock("INTC", "Intel",50.35);
							Stock cvx = new Stock("CVX", "Chevron",89.87);
							Stock qcom = new Stock("QCOM", "Qualcomm",148.18);
							Stock exxon = new Stock("XOM", "ExxonMobil",43.17);
							Stock pfizer = new Stock("PFE", "Pfizer",38.69);
							
						
							//create stock market
						 
							//add stocks to stock market
							usa.add(google);
							usa.add(aapl);
							usa.add(microsoft);
							usa.add(amazon);
							usa.add(fb);
							usa.add(tesla);
							usa.add(brk);
							usa.add(visa);
							usa.add(wallamrt);
							usa.add(jnj);
							usa.add(morgan);
							usa.add(mscard);
							usa.add(nvidia);
							usa.add(pypl);
							usa.add(ko);
							usa.add(nke);
							usa.add(nflx);
							usa.add(intc);
							usa.add(cvx);
							usa.add(qcom);
							usa.add(exxon);
							usa.add(pfizer);




							
	marketList.put("usa", usa);						
	return usa;
	}				
	

	
		//a vector that contains the headings of our stock market table
		public Vector<String> colNames()
		{
			Vector <String>colNames = new Vector<String>();
			colNames.addElement("Stock Name");
			colNames.addElement("Stock Key");
			colNames.addElement("Stock Price");
			colNames.addElement("Date");
			colNames.addElement("Price Change");
			colNames.addElement("% Change");
			
			
			return colNames;
		}
		
		
		//this method is vital to my stock market; 
		//it is the data source for the display table
		public Vector <Stock>dataVector(String name)
		{
			
			
		StockMarket test = (StockMarket)marketList.get(name);
		Vector <Stock>data = new Vector<Stock>();
		HashMap<String,Stock> stockList;
		
		//create vector to get and store data to be displayed
						
		stockList = test.getStockList();
		for(String aKey: stockList.keySet()) {
			Stock stock=(Stock) stockList.get(aKey);
			data.addElement(stock);
		}
		   return data;
		   }		
	
	//2 versions of this method exist
	//the first one takes a HashMap (can be any)as its argument 
	//and gives a sorted array of its keys back
	//the second one takes a stock market name (i.e, stock market must exist!!)
	//and returns a sorted array of its stock keys	
	
	public static String[] getSortedStocks(HashMap<String,Stock> list){
		
			//need to put all stock keys from stock list into an array , here keys
		
			HashMap<String,Stock> dummyStockList = list;

			keys= new String[dummyStockList.size()];
			int i=0;
			for(String key:dummyStockList.keySet()) {
			    keys[i] = key;
               i++;
			}
		
			

			//once stock keys have been extracted to the array, sort array and return as list
			 Arrays.sort(keys);
			 Arrays.asList(keys);
			return keys;
		}
	
	public static String[] getSortedStocks(String name){
		
		//need to put all stock keys from stock list into an array , here keys
		StockMarket test = (StockMarket)marketList.get(name);
		HashMap<String,Stock> dummyStockList = test.getStockList();

		keys= new String[dummyStockList.size()];
	    int i=0;
		for(String key:dummyStockList.keySet()) {
		    keys[i] = key;
           i++;
		}

		//once stock keys have been extracted to the array, sort array and return as list
		 Arrays.sort(keys);
		 Arrays.asList(keys);
		return keys;
	}

	
      //This is the heart of  program. If data
      //is to be gotten from elsewhere, this is where it would be updated
      //Since this has not been implemented, a random number generator is used
      //In an infinite loop, it just picks a random stock and updates its price 
      //The update time interval is kept realistic
	  public void run() {
		  
		  
		  Vector<Stock> data = dataVector("usa");
	    
		  while (true) {
	     
	    	int whichStock = Math.abs(rg.nextInt()) % data.size();
	      double delta = rg.nextDouble() - 5;
	      Stock stock = (Stock) data.get(whichStock);
	      stock.update(delta);
	      if (monitor) {
	        stock.toString();
	      }
	      try {
	        Thread.sleep(1000);
	      } catch (InterruptedException ie) {
	      }
	    }
	  }
	  
	  public Stock getQuote(int index) {
		  Vector <Stock>data = dataVector("usa");
		    return (Stock)data.get(index);
		  }

		
	

	  

	  public static void main(String args[]) {
	    DisplayData myMarket = new DisplayData(args.length > 0);
	    myMarket.setVisible(true);
	    StockMarket austria = (StockMarket)marketList.get("usa");
	    austria.writeStockList();
	  }






	
	}  