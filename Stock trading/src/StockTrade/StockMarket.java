package StockTrade;
import java.util.*;

public class StockMarket {
	
	 String name;
	public static HashMap<String, Stock> stockList;

	 
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public StockMarket(String name) {
		
		this.name = name;
		stockList= new HashMap<String,Stock>();
	}
	
	//add stock to the list
	public void add (Stock stock){
		String stockKey = stock.getKey();
		stockList.put(stockKey,stock);
		
	}
	 
	//removes stock from list
	
	public void delete (Stock stockKey) {
		
		stockList.remove(stockKey.getKey());
		
	}
	
	//returns stock from list
	
	 public Stock getStock(String stockKey){
			Stock stock = (Stock) stockList.get(stockKey);
			return stock;
			
	 }
	 
	 //returns stock list
	 
	 public void writeStockList(){
		 
		 for (String key : stockList.keySet()) {
			    
			 Stock mystock= (Stock)stockList.get(key);
			    System.out.println(mystock.toString());
			}
		  
	 }
	 
	 public HashMap<String,Stock> getStockList()
	
	 {
	 	return stockList;
	 }
	

}
