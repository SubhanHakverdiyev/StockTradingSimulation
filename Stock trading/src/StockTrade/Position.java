package StockTrade;
import java.io.Serializable;
import java.util.*;


public class Position implements Serializable {
	public Stock stock;
	private int volume;
	 
	 

	public double cost;
	 public double realisedCashFlow;
	 ArrayList<Transaction> transactionHistory;
	
	 public Position (Stock stock, int volume ){
	  	this.stock = stock;
	  	this.volume = volume;
	  	transactionHistory = new ArrayList<Transaction>();
	  	
	 }
	 
	 public Position ()
	  {
		this.stock = null;
		this.volume = 0;
		transactionHistory = new ArrayList<Transaction>();
		}
 	
	 
	 public double currentValue()
	 {
	 	return volume * stock.getPrice();
	 	}
	 
	 
	 public GregorianCalendar CurrentDate()
	 {
	 	return stock.getDate();
	 }
	 
	 
	 public void addTransaction(Transaction transaction)
	 {
	 	transactionHistory.add(transaction);
	 }
	 
	 public void update(int vol, int buySell)
	 {
		 //volume =+vol;
		 String stockKey = stock.getKey();
		 if(buySell == 0)
		 {
			 //volume =volume - vol;
			// int vol1 = vol;
			 for(Transaction trans: transactionHistory) {
			//shares by volume*bought price 
		
			 double value = 0;
			 if(trans.stockKey == stockKey && trans.volume>0)
			 for(int i = 1; i <= trans.volume && i<=vol; i++)
			 {
				 value=  (i*trans.getPrice());
			 }
			 cost = cost - value; 
			 //volume =volume - vol;
											}
		 }
		 else
		 {
			 //cost = cost + stock.getPrice()*vol;
			// volume =volume + vol;
		 }
	 }
	 
	 public void getTransactionHistory()
	 {
		 for(Transaction trans: transactionHistory) {
			 System.out.println(trans.toString());
		 }
	 			
	 }
	  public String toString()
	  {
	  	return(stock.toString()+
	"  Number : "+volume+ "  Cost : "+cost + " Realised Cash Flow : "+
	realisedCashFlow +"  Current Value : "+currentValue());
	}
	
		 public int getVolume() {
				return volume;
			}

			public void setVolume(int volume) {
				this.volume = volume;
			}
	
	
}
