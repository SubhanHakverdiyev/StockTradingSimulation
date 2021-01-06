package GUI;


import StockTrade.*;
import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class PortfolioTableSorter extends JPanel {
			private boolean DEBUG = false;
			MyPortfolio portfolio;
			AbstractTableModel myTableModel;
			PortfolioTableSorter sorter;
			public static Vector rowData; 
			DateFormat dtf = DateFormat.getDateInstance();
			NumberFormat nf = NumberFormat.getInstance();
			DecimalFormat df = new DecimalFormat("###.###%");


	public PortfolioTableSorter(MyPortfolio portfolio) {
		
		super(new GridLayout(1,0));

						//	First, get all our positions from the portfolio into a vector (rowData) which can
					  //then be used for our TableModel
					  
					  this.portfolio = portfolio;
					  rowData = getRowData(portfolio);
					  
				//now set out how the table should look like and where it should get its data frm
				myTableModel = new MyTableModel(5);
				TableSorter sorter = new TableSorter(myTableModel); //ADDED THIS
				JTable table = new JTable(sorter);             //NEW
				sorter.setTableHeader(table.getTableHeader()); //ADDED THIS
				table.setPreferredScrollableViewportSize(new Dimension(500, 70));

				//Set up tool tips for column headers.
				table.getTableHeader().setToolTipText(
						"Click to specify sorting; Control-Click to specify secondary sorting");

				//Create the scroll pane and add the table to it.
				JScrollPane scrollPane = new JScrollPane(table);

				//Add the scroll pane to this panel.
				add(scrollPane);
					}
				
		Vector getRowData(MyPortfolio portfolio)
		{
			HashMap<String,Position> posList = portfolio.positionList;
								
								  rowData = new Vector();
								  
								  for(String aKey: posList.keySet()) {
										 Position pos = (Position) posList.get(aKey);
										 rowData.addElement(pos);

								  }
								 
								  
								  return rowData;
			
		}
		

	
	
	class MyTableModel extends AbstractTableModel implements Runnable{
		
		Thread runner;
        int delay;
        
        public MyTableModel(int initialDelay) {
              delay = initialDelay * 1000;
              Thread runner = new Thread(this);
              runner.start();
            }
    	
    	
			private String[] columnNames = {
			"Stock Key",
			"Stock Name",
			"Price",
			"Date",
			"Daily Change" ,
			"Number",
			"Cost",
			"Realised CF",
			"Current Value"};
		

			public int getColumnCount() {
				return columnNames.length;
			}

			public int getRowCount() {
				
				return rowData.size();
			}

			public String getColumnName(int col) {
				return columnNames[col];
			}

			public Object getValueAt(int row, int col) {
         
			
				Position pos = (Position)rowData.elementAt(row);
				Stock stock = pos.stock;
         
			   if(col == 0)
			   {
				return stock.getKey();
			   }
           
						else if(col == 1)
						  {
							
							return stock.getName();
						  }
			
									else if(col == 2)
									  {
										
									   return new Double(stock.getPrice());
									  }
								  
												else if(col == 3)
												  {
													
												   return (dtf.format(stock.getDate().getTime()));
												  }								  
											  
																else if(col == 4)
															  {
																
															   return new Double(stock.getChange());
															  }
																				else if(col == 5)
																			  {
																				
																			   return new Integer(pos.getVolume());
																			  }
	
																								else if(col == 6)
																							  {
																								
																							   return new Double(pos.cost);
																							  }
																												else if(col == 7)
																											  {
																												
																											   return new Double(pos.realisedCashFlow);
																											  }
																																else if(col == 8)
																															  {
																																
																															   return new Double(pos.currentValue());
																															  }
														  else {
																return  new String(" ");														
															  }
			}

	
	
	/*
			 * JTable uses this method to determine the default renderer/
			 * editor for each cell.  If we didn't implement this method,
			 * then the last column would contain text ("true"/"false"),
			 * rather than a check box.
			 */
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}

			/*
			 * Don't need to implement this method unless your table's
			 * editable.
			 */
			public boolean isCellEditable(int row, int col) {
				//Note that the data/cell address is constant,
				//no matter where the cell appears onscreen.
				if (col < 12) {
					return false;
				} else {
					return true;
				}
			}
			
			public void updatePositions() {
	        	  int i = rowData.size();
	        	  
	        	  rowData = new Vector();
	            
	            for (int x = 0; x < i; x++) {
	           
	             
	            	rowData.add(portfolio.getPosition(x));
	            }
	          }

	          public void run() {
	            while (true) {
	              // Blind update . . . we could check for real deltas if necessary
	              updatePositions();
	              
	              PortfolioFrame.valueToday = portfolio.portfolioValueToday(); 
	              PortfolioFrame.realisedCash = portfolio.realisedValue();
	              PortfolioFrame.changeInValue = portfolio.changeValue();
	              PortfolioFrame.bal = portfolio.balance();
	              PortfolioFrame.currentValue.setText("Current Stock Portfolio Value : "+nf.format(PortfolioFrame.valueToday));
	              PortfolioFrame.realisedCF.setText("Of which realised as cash : "+nf.format(PortfolioFrame.realisedCash));
	              PortfolioFrame.changeValue.setText("Change in Value : "+nf.format(PortfolioFrame.changeInValue));
	              PortfolioFrame.balance.setText("Account Balance : "+nf.format(PortfolioFrame.bal));
	  			

	              // We know there are no new columns, so don't fire a data change,
	              // only
	              // fire a row update . . . this keeps the table from flashing
	              fireTableRowsInserted(0, rowData.size() - 1);
	              try {
	                Thread.sleep(delay);
	              } catch (InterruptedException ie) {
	              }
	            }
	          }
	        

			

	}
	}
