package StockTrade;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.*;
import java.util.*;
import java.io.Serializable;

public class MyPortfolio implements Serializable{
	public String username;
	public double myBalance;
	private String password;
	public String getPassword() {
		return password;
	}

	String email;
	public double expense;
	public double totalCost;
	public double totalRealisedCF;
	public HashMap<String,Position> positionList;
	ArrayList<PortfolioValue> valueHistory;
	
	NumberFormat nf = NumberFormat.getInstance();
	DecimalFormat df = new DecimalFormat("###.###%");
	
	//constructor
	public MyPortfolio(String username,String email,String password){
			
		this.username = username;
		this.email=email;
		this.password=password;
		myBalance = 0 ;
		positionList = new HashMap<String,Position>();
		valueHistory = new ArrayList<PortfolioValue>();
			
	}
	//method to buy a share
	//select stock market, key of stock and number of stocks you want to buy
		
	public void buy(StockMarket stockMarket, String stockKey, int volume )	{
		
	    Stock stock = stockMarket.getStock(stockKey);	//stock points to the stock in stock list in selected stock market identified by the stock key	
		Position pos;
			
		//if portfolio already holds stock, add required number to existing position
		if (positionList.containsKey(stockKey)){	
			
			pos = (Position) positionList.get(stockKey);
					//pos.update(volume, 1);}
			pos.setVolume(pos.getVolume()+volume);
		}
				
		else 
		
		{
			
			pos = new Position (stock, volume);	// if portfolio doesnt hold stock, create a new position for this stock with required number
			positionList.put(stockKey, pos);
			
		}
				
			Transaction transaction = new Transaction(stock, volume);
			pos.addTransaction(transaction); //create a new transaction object and save this buy transaction in history
				
			double cost = stock.getPrice()*volume; //cost of transaction is unit stock price * volume brought
			pos.cost = pos.cost + cost;		// cost of current transaction is added to cumulative cost
			totalCost = totalCost + cost;
				
			expense = expense + cost;	// book a minus to our credit balance
				
	}

     //method to buy a share

      public Position buy(HashMap<String,Stock> stockList, String stockKey, int volume) {
			Stock stock = (Stock)stockList.get(stockKey);
            double cost= stock.getPrice()*volume;//cost of transaction is unit stock price * volume bought
    	    Position pos;
    	  
    	    //if portfolio already holds stock, add required number to existing position
    	    if(positionList.containsKey(stockKey)) {
    	    	pos=(Position)positionList.get(stockKey);
    			pos.setVolume(pos.getVolume()+volume);
    	    	
    	    }
    	    else {
    	    	// if portfolio doesnt hold stock, create a new position for this stock with required number
    	    	pos= new Position(stock,volume);
    	    	positionList.put(stockKey,pos);
    	    	
    	    }
    	    Transaction transaction = new Transaction(stock, volume);
			pos.addTransaction(transaction);	//create a new transaction object and save this buy transaction in history
			pos.cost = pos.cost + cost;		// cost of current transaction is added to cumulative cost
			totalCost = totalCost + cost;
				
			expense = expense + cost;	// book a minus to our credit balance//bolek 100 var
    	      	return pos; 	  
      }
      
    //method to sell a share
      public Position sell(HashMap <String,Stock>stockList, String stockKey,int volume) {
    	  Position pos= (Position)positionList.get(stockKey);
  		//position points to the position in position list identified by the stock key
          
    	  if(pos.getVolume()>0 && pos.getVolume()>=volume) {
    		  Stock stock = (Stock)stockList.get(stockKey);
    		  pos.setVolume(pos.getVolume()-volume); //reduce volume held by number sold
    		  double cashFlow= stock.getPrice()*volume; //cash flow  = today's unit price * number sold
    		  pos.realisedCashFlow= pos.realisedCashFlow+cashFlow; //add today's cash flow to cumulative cash flow
    		  totalRealisedCF = totalRealisedCF + cashFlow;
    		  Transaction transaction = new Transaction(stock, volume);
  			  pos.addTransaction(transaction);	//create a new transaction object and save this buy transaction in history
  			  pos.update(volume, 0);
    	  
  		 myBalance = myBalance+(cashFlow); //book a plus in our debit balance
    	  }
  		  return pos;
      
      }
      //method to sell a share
      public void sell(StockMarket stockMarket, String stockKey, int volume)
		{
    	  Position pos = (Position) positionList.get(stockKey);  //position points to the position in position list identified by the stock key
		
		  Stock stock = stockMarket.getStock(stockKey);  //stock points to the stock in stock list in selected stock market identified by the stock key
		 
		  pos.setVolume(pos.getVolume()-volume); //reduce volume held by number sold
		  pos.update(volume,0);	//reduce cost of position by subtracting volume*bought price from it
		  double cashFlow = stock.getPrice()*volume;		//cash flow  = today's unit price * number sold
		  pos.realisedCashFlow = pos.realisedCashFlow + cashFlow;	//add today's cash flow to cumulative cash flow
		  totalRealisedCF = totalRealisedCF + cashFlow;
		
		  Transaction transaction = new Transaction(stock, -volume);
		  pos.addTransaction(transaction);	//create a new transaction object and save this sell transaction in history
		  myBalance = myBalance+cashFlow;//book a plus in our debit balance
		
		}
      public void deposit(double amount)
		{
    	  if(amount<1000) {
    		  System.out.println("Please deposit more than 1000");
    	  }
			myBalance += amount;
		}
      
      public void withdraw(double amount)
		{
    	  if(amount<100)
    		  System.out.println("Withdraw more than 100");
			expense += amount;
		}
		
      public boolean buyError(Stock stock, int volume)
		{	
			double cost = stock.getPrice()*volume;
		
			if ((myBalance < expense + cost) || volume < 0)
				return true;
			else 
				return false;
		}
      
      public boolean sellError(String stockKey, int volume)
		{	
			Position pos = (Position) positionList.get(stockKey);  //position points to the position in position list identified by the stock key
			
			if (pos.getVolume() < 0 || pos.getVolume() < volume || volume < 0)
				return true;
			else 
				return false;
		}
	
      public boolean depositError(double amount)
      {
			if ( amount < 1000) {
				return true;
			}
			else
				return false;
		}
      
      public boolean withdrawError(double amount)
      {
			if ( balance()<amount || amount < 100) {
				return true;
			}
			
			else
				return false;
		}
      
      
      
      public Position getPosition(int index)
		{
		HashMap<String,Position>  posList = positionList;
		
		Vector<Position> positions = new Vector<Position> ();
		
		 for (String aKey : posList.keySet()) {
			 Position pos= (Position)posList.get(aKey);
			 positions.addElement(pos);

			}
		 
		  return (Position)positions.get(index);
		}
      
      
      
      void getPortfolio()
		{
		double balance = myBalance - expense;
		System.out.println("Hello "+username+"!"+" Your account status is as follows:");
		System.out.println("Current Stock Portfolio Value : "+nf.format(portfolioValueToday()));
		System.out.println("Of which realised as cash : "+nf.format(totalRealisedCF));
		System.out.println("Change in Value : "+nf.format((portfolioValueToday()-(totalCost))));
		System.out.println("Account Balance : "+nf.format(balance));
		System.out.println("Portfolio contents : ");
		 for (String aKey : positionList.keySet()) {
			 Position pos= (Position)positionList.get(aKey);
			   System.out.println(pos.toString());
			}
		
		 }
      
      public double portfolioValueToday()
		{
		double valueToday = 0;
		
		 for (String aKey : positionList.keySet()) {
			 Position pos= (Position)positionList.get(aKey);
			 valueToday =  valueToday + (pos.currentValue());
			}
											
				
				   return (valueToday+totalRealisedCF);// bolek 100 var
		}
      
      public double realisedValue(){
  		
  		return (totalRealisedCF);
  		
  	}
      
      public double changeValue() {
  		return (portfolioValueToday()-(totalCost));
  	}
      
      
      public double balance() {
		return myBalance - expense;
	}
      
      GregorianCalendar dateToday()
		{
		GregorianCalendar dateToday = new GregorianCalendar();
		
		 for (String aKey : positionList.keySet()) {
			 Position pos= (Position)positionList.get(aKey);
			 dateToday=pos.CurrentDate();
			 
		 }
		 
			 return dateToday;
			
		}
      void savePortfolioValue()
		{
			/*value of our portfolio is current value of all stocks held (need to subtract 
			 * portfolioVaueToday by the totalRealisedCF since this already added to 
			 * to our cash balance by increasing dr bal (balanceDebit-balanceCredit)
			 */
			PortfolioValue old = new PortfolioValue(((portfolioValueToday())-totalRealisedCF)+(myBalance-expense), dateToday());
			valueHistory.add(old);
		}
    
      public void getValueHistory()
  	{
    	  
    	  for (PortfolioValue pValue: valueHistory) {
 			
				System.out.println(pValue.toString());

 		 }
    	  
  		
  	}
      
      public void getFullTransactionHistory()
		{
    	  
    	  for (String aKey: positionList.keySet()) {
 			 Position pos= (Position)positionList.get(aKey);

 			 pos.getTransactionHistory();
		 }	
		}
      
      void getTransactionHistory(String stockKey)
		{
    	  for (String aKey: positionList.keySet()) {
  			 Position pos= (Position)positionList.get(aKey);
  			 if(pos.stock.getKey() == stockKey)
  				pos.getTransactionHistory();
		}
		}
      
      void removeStock(String stockKey)
		{
			positionList.remove(stockKey);
		}

      
	public String getUserName() {
		return username;
	}
	public void setUserName(String name) {
		this.username = name;
	}
	public double getMyBalance() {
		return myBalance;
	}
	public void setMyBalance(double balanceDebit) {
		this.myBalance = balanceDebit;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double balanceCredit) {
		this.expense = balanceCredit;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getTotalRealisedCF() {
		return totalRealisedCF;
	}
	public void setTotalRealisedCF(double totalRealisedCF) {
		this.totalRealisedCF = totalRealisedCF;
	}
	public HashMap<String,Position> getPositionList() {
		return positionList;
	}
	
	public void setPositionList(HashMap<String,Position> positionList) {
		this.positionList = positionList;
	}

	public void setValueHistory(ArrayList<PortfolioValue> valueHistory) {
		this.valueHistory = valueHistory;
	}
	
	public static void loaduser() {
		try {
			FileInputStream inputFile = new FileInputStream(Controller.userurl);
			ObjectInputStream input = new ObjectInputStream(inputFile);
			boolean read = true;
			while(read) {
				MyPortfolio portfolio = (MyPortfolio) input.readObject();
				if(portfolio!=null) {
					Controller.users.add(portfolio);
				}
				else 
					read=false;
			} 
			
			input.close();
			inputFile.close();
		}
       catch(EOFException e) {
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	public  static void saveUser()  {	        
          try {
	       FileOutputStream fileOut =new FileOutputStream(Controller.userurl);
	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
		   for(int i=0; i<Controller.users.size(); i++) {
		   out.writeObject(Controller.users.get(i));}
		   out.close();
		   fileOut.close();
          }
		  // System.out.printf("Serialized data is saved");	
          catch(EOFException e) {
  			
  		}
          catch(IOException e) {
  			e.printStackTrace();
          }
		}
	
	
}
