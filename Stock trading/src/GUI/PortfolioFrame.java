package GUI;

import StockTrade.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class PortfolioFrame 
extends JInternalFrame 
implements ActionListener
{
	
	Frame frame;
	MyPortfolio portfolio;
    static HashMap stockList = StockMarket.stockList;
    static String [] stocks  = DisplayData.getSortedStocks(stockList); 
    Stock stock;
    int number;
    String stockKey;
    Position pos;
    public static double valueToday; 
    public static double realisedCash;
    public static double changeInValue;
    public static double bal;
	
    public static JLabel welcome = new JLabel();
    public static JLabel currentValue = new JLabel();
    public static JLabel realisedCF= new JLabel();
    public static JLabel changeValue= new JLabel();
    public static JLabel balance= new JLabel();
	JPanel optionsPanel;
	JPanel mainPanel;
	JPanel textPanel;
	PortfolioTableSorter displayPanel;
	JButton buy;
	JButton sell;
	JButton deposit;
	JButton withdraw;
	JButton tips;
	static int openFrameCount = 0;
	static final int xOffset = 30 ;
	static final int yOffset = 30 ;
	NumberFormat nf = NumberFormat.getInstance();
	DecimalFormat df = new DecimalFormat("###.###%");
	DateFormat dtf = DateFormat.getDateInstance();
	


	public PortfolioFrame(MyPortfolio portfolio) {
		super(portfolio.getUserName().toUpperCase()+"'s"+" Portfolio Manager", 
			  true, //resizable
			  false, //closable
			  true, //maximizable
			  true);//iconifiable

		this.portfolio = portfolio;
		valueToday = portfolio.portfolioValueToday(); 
	    realisedCash = portfolio.realisedValue();
	    changeInValue = portfolio.changeValue();
	    bal = portfolio.balance();
		welcome.setText("Hello "+portfolio.getUserName()+" ! "+ " You can now buy or sell shares");
		//...Create the GUIStockTrade and put it in the window...

		//...Then set the window size or call pack...
		//setSize(300,300);
		pack();

		//Set the window's location.
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		
		//createComponents();
		getContentPane().add(createComponents());
		
		
	}
	
	
		public Component createComponents() 
		
				{

			
					JButton buy = new JButton("Buy Share");
					buy.setActionCommand("BUY");
					buy.addActionListener(this);
								  
											  
					JButton sell = new JButton("Sell Share");
					sell.setActionCommand("SELL");
					sell.addActionListener(this);
					
					JButton deposit = new JButton("Add Balance");
					deposit.setActionCommand("DEPOSIT");
					deposit.addActionListener(this);
								  
											  
					JButton withdraw = new JButton("Withdraw Balance");
					withdraw.setActionCommand("WITHDRAW");
					withdraw.addActionListener(this);
					
					JButton tips = new JButton("Market Tips");
					tips.setActionCommand("MARKETTIPS");
					tips.addActionListener(this);
			
					
	
 
		 //create the different panels (displayPanel already created) and add all of them
		 //into a main panel which is then returned 
		 
		 //create options panel which will have buttons for buying ans selling shares 
		 // text panel which displays portfolio details
					optionsPanel = new JPanel();
					optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.LINE_AXIS));
					
					optionsPanel.add(buy);
					optionsPanel.add(Box.createHorizontalStrut(15));
					optionsPanel.add(sell);
					optionsPanel.add(Box.createHorizontalStrut(15));
					optionsPanel.add(deposit);
					optionsPanel.add(Box.createHorizontalStrut(15));
					optionsPanel.add(withdraw);
					optionsPanel.add(Box.createHorizontalStrut(15));
					optionsPanel.add(tips);
					
					
					textPanel = new JPanel();
					textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
					currentValue.setText("Current Stock Portfolio Value : "+nf.format(valueToday));
					realisedCF.setText("Of which realised as cash : "+nf.format(realisedCash));
					changeValue.setText("Change in Value : "+nf.format(changeInValue));
					balance.setText("Account Balance : "+nf.format(bal));
					
					textPanel.add(welcome);
					textPanel.add(Box.createRigidArea(new Dimension(0,2)));
					textPanel.add(currentValue);
					textPanel.add(Box.createRigidArea(new Dimension(0,2)));
					textPanel.add(realisedCF);
					textPanel.add(Box.createRigidArea(new Dimension(0,2)));
					textPanel.add(changeValue);
					textPanel.add(Box.createRigidArea(new Dimension(0,2)));
					textPanel.add(balance);
					textPanel.add(Box.createRigidArea(new Dimension(0,2)));
					
					
					//create display Panel which is our portfolio table- this will show portfolio contents
					//in a similar fashion to the table in StockMarketDisplay
						
						displayPanel = new PortfolioTableSorter(portfolio);
						
						//	Add a border around the display panel.
						displayPanel.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Portfolio Display Board"), 
						BorderFactory.createEmptyBorder(5,5,5,5)));
						//BorderFactory.createTitledBorder("Portfolio Display Board").setTitleFont(font);
			
						//Create the main panel to contain the two sub panels.
						 mainPanel = new JPanel();
						 mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
						 mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

						//Add the options and display panels to the main panel.
						mainPanel.add(Box.createRigidArea(new Dimension(0,1)));
						mainPanel.add(optionsPanel);
						optionsPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
						mainPanel.add(Box.createRigidArea(new Dimension(0,2)));
						mainPanel.add(textPanel);
						textPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
						mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
						mainPanel.add(displayPanel);
						
						
				  
						  return mainPanel;
				  
				}
		
		
		
		public void actionPerformed(ActionEvent e) {
			if ("BUY".equals(e.getActionCommand())) {
				
            //User clicked the buy button: show list of stocks user can buy
             ListDialog.showDialog(
                                    frame,
                                    buy,
                                    "Number of Stocks you wish to buy",
                                    "All stocks available for sale: ",
                                    "Stock chooser",
                                    stocks,
                                    stocks[0],
                                    " ");
             
            
             
            //get how much of which stock user needs to buy 
           stockKey = ListDialog.value;
           number = ListDialog.amount;
           
           //trivial but looks nice: get stock and name for information and for display
           stock = (Stock)stockList.get(stockKey);
           String name = stock.getName();
           
           if (portfolio.buyError(stock, number))
           {
        	   welcome.setText("No Purchase Executed: Please enter valid details!"+
	        		   " To sort table please click the respective column header !");
           }
           else
           {
           welcome.setText("Last Purchase: "+number+" shares of "+name +'\n'+
        		   "!  Please click the respective column header to sort table");
           
           //now do the buy transaction and add resulting position to row data
           //rowData accessed directly in a static way
           //PortfolioTableSorter could contain a method which returns this data instead
           	pos = portfolio.buy(stockList,stockKey,number);
           	
           	valueToday = portfolio.portfolioValueToday(); 
            realisedCash = portfolio.realisedValue();
            changeInValue = portfolio.changeValue();
            bal = portfolio.balance();
           	currentValue.setText("Current Stock Portfolio Value : "+nf.format(valueToday));
			realisedCF.setText("Of which realised as cash : "+nf.format(realisedCash));
			changeValue.setText("Change in Value : "+nf.format(changeInValue));
			balance.setText("Account Balance : "+nf.format(bal));
           	
            bal = portfolio.balance();
            
           	int row = 1;
           	
           	if(PortfolioTableSorter.rowData.contains(pos))
           	{}
           	
           	else{          		
           	PortfolioTableSorter.rowData.addElement(pos);          
           	}
           	
           	for(int i=0; i < 10; i++)
           	{
           		displayPanel.myTableModel.setValueAt(pos, row, i);
           	}
           	
            }
			}
			
			else if ("SELL".equals(e.getActionCommand()))
			{
//				User clicked the sell button: show list of stocks user can sell
				HashMap posList = portfolio.positionList;
			    //static String [] stocks  = DisplayData.getSortedStocks(stockList); 
			    String [] positions = DisplayData.getSortedStocks(posList);
				
				ListDialog.showDialog(
	                                    frame,
	                                    sell,
	                                    "Number of Stocks you wish to sell",
	                                    "All stocks available for sale: ",
	                                    "Stock chooser",
	                                    positions,
	                                    positions[0],
	                                    " ");

				//	get how much of which stock user needs to sell 
		           stockKey = ListDialog.value;
		           number = ListDialog.amount;
//		         
		           //trivial but looks nice: get stock and name for information and for display
		           stock = (Stock)stockList.get(stockKey);
		           String name = stock.getName();
		           
		           if(portfolio.sellError(stockKey, number))
		           {
		        	   welcome.setText("No Sale Executed: Please enter valid details!"+
	        		   " To sort table please click the respective column header !");   
		           }
		           else
		           {
		           welcome.setText("Last Sale: "+number+" shares of "+name+
		        		   "!  Please click the respective column header to sort table!");
		           
		           //now do the sell transaction and add resulting position to row data
		           //rowData accessed directly in a static way
		           //PortfolioTableSorter could contain a method which returns this data instead
		           	pos = portfolio.sell(stockList,stockKey,number);
		           	
		           	valueToday = portfolio.portfolioValueToday(); 
		            realisedCash = portfolio.realisedValue();
		            changeInValue = portfolio.changeValue();
		            bal = portfolio.balance();
		           	currentValue.setText("Current Stock Portfolio Value : "+nf.format(valueToday));
					realisedCF.setText("Of which realised as cash : "+nf.format(realisedCash));
					changeValue.setText("Change in Value : "+nf.format(changeInValue));
					balance.setText("Account Balance : "+nf.format(bal));
		           }       	
			}
			
			else if ("DEPOSIT".equals(e.getActionCommand()))
			{
				InputDialog.showDialog(
						frame,
						deposit,
						" ",
						"Add to Balance",
						0);

				double amount = InputDialog.amount;
				
				if (portfolio.depositError(amount))
				{
					welcome.setText("Action Not Executed: Please enter valid details!"+
			        		   " To sort table please click the respective column header !");
				}
					
				else
				{
					welcome.setText("Last Deposit: "+nf.format(amount)+
	        		   "!  Please click the respective column header to sort table!");
				portfolio.deposit(amount);
				
				valueToday = portfolio.portfolioValueToday(); 
		        realisedCash = portfolio.realisedValue();
		        changeInValue = portfolio.changeValue();
		        bal = portfolio.balance();
		       	currentValue.setText("Current Stock Portfolio Value : "+nf.format(valueToday));
				realisedCF.setText("Of which realised as cash : "+nf.format(realisedCash));
				changeValue.setText("Change in Value : "+nf.format(changeInValue));
				balance.setText("Account Balance : "+nf.format(bal));
				}
			}
			
			else if ("WITHDRAW".equals(e.getActionCommand()))
			{
				InputDialog.showDialog(
						frame,
						deposit,
						" ",
						"Withdraw frm Balance",
						0);

				double amount = InputDialog.amount;
				
				
				if (portfolio.withdrawError(amount))
				{
					welcome.setText("Action Not Executed: Please enter valid details!"+
			        		   " To sort table please click the respective column header !");
				}
					
				else
				{
				welcome.setText("Last Withdrawal: "+nf.format(amount)+
	        		   "!  Please click the respective column header to sort table!");
				portfolio.withdraw(amount);
				
				valueToday = portfolio.portfolioValueToday(); 
		        realisedCash = portfolio.realisedValue();
		        changeInValue = portfolio.changeValue();
		        bal = portfolio.balance();
		       	currentValue.setText("Current Stock Portfolio Value : "+nf.format(valueToday));
				realisedCF.setText("Of which realised as cash : "+nf.format(realisedCash));
				changeValue.setText("Change in Value : "+nf.format(changeInValue));
				balance.setText("Account Balance : "+nf.format(bal));
				}
			}
			else if ("MARKETTIPS".equals(e.getActionCommand()))
			{
				JLabel text [] = new JLabel [5];
			text[0] = new JLabel("Try to buy stocks that are relatively cheap.");
			text[1] = new JLabel("Try to buy stocks whose prices have fallen recently");
			text [2] = new JLabel("Keep a diversified portfolio. Do not sell immediately when price drops.");
			text [3] = new JLabel("When price is increasing, realise part of it in cash.");
			text [4] = new JLabel("Remember that stock prices are listed in cents");
			JOptionPane.showInternalMessageDialog(this,text); }
	else{
		System.out.println("PortfolioFrame Button Error: Please notify administrator at shuba.narasimhan@gmail.com");
		}

			}


			
			


						

}
