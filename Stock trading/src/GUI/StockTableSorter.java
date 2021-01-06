package GUI;

import StockTrade.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/** 
 * StockTableSorter
 * inserts a custom model -- a sorter -- between the table
 * and its data model.  It also has column tool tips.
 */
public class StockTableSorter extends JPanel{
    private boolean DEBUG = false;
	

    public StockTableSorter() {
        super(new GridLayout(1,0));

        TableSorter sorter = new TableSorter(new MyTableModel(5)); //ADDED THIS
        JTable table = new JTable(sorter);             //NEW
        sorter.setTableHeader(table.getTableHeader()); //ADDED THIS
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //Set up tool tips for column headers.
        table.getTableHeader().setToolTipText(
                "Click to specify sorting");

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel implements Runnable{
    	
    	Thread runner;
        int delay;
        public DisplayData market = new DisplayData();
    	Vector rowData = market.dataVector("usa");
    	Vector columnData = market.colNames();
    	DateFormat dtf = DateFormat.getDateInstance();
    	NumberFormat nf = NumberFormat.getInstance();
    	DecimalFormat df = new DecimalFormat("###.###%");

        
        public MyTableModel(int initialDelay) {
          //market = new DisplayData();
            delay = initialDelay * 1000;
            Thread runner = new Thread(this);
            runner.start();
          }
        
       /* private String[] columnNames = {
		"Stock Key",
		"Stock Name",
		"Price",
		"Date",
		"Daily Change",
		"% Change"};*/
		
     
        public int getColumnCount() {
            //return columnNames.length;
        	return columnData.size();
        }

        public int getRowCount() {
            return rowData.size();
        }

        public String getColumnName(int col) {
           // return columnNames[col];
        	return (String)columnData.get(col);
        }
        
        
          public void setDelay(int seconds) {
            delay = seconds * 1000;
          }
          
        public Object getValueAt(int row, int col) {
         
         
           	Stock stock = (Stock)rowData.elementAt(row);
         
           if(col == 0)
           {
           	return stock.getName();
           }
           
		   			else if(col == 1)
					  {
						
					   return stock.getKey();
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
															
														   return new Double(stock.getDelta());
														  }
           
																else if(col == 5)
															  {
							
																   return new String(df.format(stock.getDeltaPercentage()));
																  }
															else {
														  	return  new String(" ");														
														  }
        }
        
        
      

          public void updateStocks() {
        	  int i = rowData.size();
        	  rowData = new Vector();
            
            for (int x = 0; x < i; x++) {
             
            	rowData.add(market.getQuote(x));
            }
          }

          public void run() {
            while (true) {
              // Blind update . . . we could check for real deltas if necessary
              updateStocks();

              // We know there are no new columns, so don't fire a data change,
              // only
              // fire a row update . . . this keeps the table from flashing
              fireTableRowsUpdated(0, rowData.size() - 1);
              try {
                Thread.sleep(delay);
              } catch (InterruptedException ie) {
              }
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
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
        
    }

	
}

        
        



