package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;

import StockTrade.*;

/*requires files InputDialog, StockTableSorter (requires DisplayData), TableSorter*/

public class StockMarketDisplay 
extends JFrame 
implements ActionListener, 
InternalFrameListener {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		static JFrame frame;
		private JPanel mainPanel;
		private JPanel optionsPanel;
		private JPanel displayPanel = new StockTableSorter();
		public static final JLabel label = new JLabel(" Welcome to Portfolio Manager! " +
				" To begin, please create a new Portfolio! ");
		public static final JLabel label1 = new JLabel(
        		   " To sort table, please click the respective column header");
		JButton createPortfolio;
		JButton clear;
		JDesktopPane desktop;
		JInternalFrame displayWindow;
		PortfolioFrame  portfolioFrame;
		MyPortfolio portfolio;
		public String name;
		public double amount;
		/*//Specify the look and feel to use.  Valid values:
		//null (use the default), "Metal", "System", "Motif", "GTK+"
		final static String LOOKANDFEEL = null;*/
		DateFormat dtf = DateFormat.getDateInstance();
		NumberFormat nf = NumberFormat.getInstance();
		DecimalFormat df = new DecimalFormat("###.###%");
		static final int desktopWidth = 900;
		static final int desktopHeight = 700;
		static final String SHOW = "show";
		static final String CLEAR = "clear";
       
		
		public StockMarketDisplay(MyPortfolio portfolio )
		{
					
					this.portfolio=portfolio;
				//Set up the GUIStockTrade.
				  desktop = new JDesktopPane();
				  desktop.putClientProperty("JDesktopPane.dragMode",
											"outline");
											
				  //Because we use pack, it's not enough to call setSize.
				  //We must set the desktop's preferred size.
				  desktop.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
				  setContentPane(desktop);

				//creates the internal frame where all the other components are	
				createComponents();
				  
			desktop.add(displayWindow); //DON'T FORGET THIS!!!
  			Dimension displaySize = displayWindow.getSize();
  			displayWindow.setSize(desktopWidth, displaySize.height);					
			
		}
		
		
		
		
		public void createComponents() 
		
		{
			//create buttons
			createPortfolio = new JButton("Go to My profile");
			createPortfolio.setActionCommand(SHOW);
			createPortfolio.addActionListener(this);

			clear = new JButton("Log out");
			clear.addActionListener(this);
			
			//create the window into where everything is going to be shown
			displayWindow = new JInternalFrame("Stock Market",
													   true,  //resizable
													   false, //not closable
													   true, //maximizable
													   true); //iconifiable
				   
			
 
 //create the different panels (displayPanel already created) and add all of them
 //into a main panel 
 
 			optionsPanel = new JPanel();
 			
 			optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
			optionsPanel.add(createPortfolio);
			optionsPanel.add(Box.createRigidArea(new Dimension(0,10)));
			
 			optionsPanel.add(clear);
		
			optionsPanel.add(Box.createRigidArea(new Dimension(0,10)));
			optionsPanel.add(label);
			optionsPanel.add(Box.createRigidArea(new Dimension(0,5)));
			optionsPanel.add(label1);
					

			
			
				//Add a border around the display panel which contains stock table.
				
				displayPanel.setBorder(BorderFactory.createCompoundBorder(
				  BorderFactory.createTitledBorder("Stock Market Display Board"), 
				  BorderFactory.createEmptyBorder(5,5,5,5)));
				
			
				//Create the main panel to contain the two sub panels.
				  mainPanel = new JPanel();
				  mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
				  mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

				  //Add the options and display panels to the main panel.
				mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
				mainPanel.add(optionsPanel);
				mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
				mainPanel.add(displayPanel);
			
			//make sure our internal frame displays the main panel	
			displayWindow.setContentPane(mainPanel);
			displayWindow.pack();
			displayWindow.setVisible(true);
				  	  
		}
		
		//keep the user informed about what is happening in the portfolio window
	    public void internalFrameClosing(InternalFrameEvent e) {
	        label.setText("Portfolio frame closing");
	    }

	    public void internalFrameClosed(InternalFrameEvent e) {
	    	label.setText("Portfolio frame closed");
	    }

	    public void internalFrameOpened(InternalFrameEvent e) {
	    	label.setText("Portfolio frame open");
	    }

	    public void internalFrameIconified(InternalFrameEvent e) {
	    	label.setText("Portfolio frame iconified");
	    }

	    public void internalFrameDeiconified(InternalFrameEvent e) {
	    	label.setText("Portfolio frame deiconified ");
	    }

	    public void internalFrameActivated(InternalFrameEvent e) {
	    	label.setText("Portfolio frame activated");
	    }

	    public void internalFrameDeactivated(InternalFrameEvent e) {
	    	label.setText("Portfolio frame deactivated");
	    }
	
	//create a new portfolio when the appropriate button is clicked
	public void actionPerformed(ActionEvent e) {
				
		         if(e.getSource()==clear) {
		        	 this.dispose();
		 			new SignIn().setVisible(true);

		         }
				if (SHOW.equals(e.getActionCommand())) {
				//They clicked the Show button.
				
				//show a pop up dialog which registers the name and amt for 
				//creating a portfolio
				//label.setText("Please wait while a portfolio is created for you. . . . ."); 
			
		
		
				
				//we would like the console to speak to the user
				{ 
				
				//create portfolio from name and amt given by user
				name=portfolio.getUserName();
				amount=portfolio.myBalance;
				
			
				//create the internal frame for the new portfolio if necessary.
	            if (portfolioFrame == null) {
	            	portfolioFrame = new PortfolioFrame(portfolio);
	            	
	                portfolioFrame.setDefaultCloseOperation(
	                  WindowConstants.HIDE_ON_CLOSE);

	                //Add an internal frame listener so we can see
	                //what internal frame events it generates.
	                portfolioFrame.addInternalFrameListener(this);

	                //And we mustn't forget to add it to the desktop pane!
	                desktop.add(portfolioFrame);
	               

	                //Set its size and location.  We use pack() to set the size
	                //as the window contains something.
	                portfolioFrame.pack();
	                portfolioFrame.setLocation(
	                    desktopWidth/2 - portfolioFrame.getWidth()/2,
	                    desktopHeight - portfolioFrame.getHeight());
	            }
	                
				}

	            //Show the internal frame.
	            portfolioFrame.setVisible(true);
				
				
			
				
				}
							
					else 
					{ //They clicked the Clear button.
								label.setText("Closing Portfolio Manager . . . . .");
								
								
								dispose();
								
					}
							
				}
		
				 
	 
	 
	 
	 
	 public static void createAndShowGUI(MyPortfolio portfolio) 
	 {
        //Make sure we have nice window decorations.

		StockMarketDisplay  display = new StockMarketDisplay (portfolio);
		
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				//Display the window.
				display.pack();
				display.setVisible(true);

    }

 
    
}

	