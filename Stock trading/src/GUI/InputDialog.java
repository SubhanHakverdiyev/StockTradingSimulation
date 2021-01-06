package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * Requires no additional files. Generates two versions of input dialogs: with one
 *  or two text fields for user to feed in data 
 */
public class InputDialog extends JDialog implements ActionListener{
	
	private static InputDialog dialog;
	private JTextField nameField;
	private JTextField amountField;
	public static String name = "";
	public static double amount = 0;
	public static String cancel = "";
	
    /**
     * Set up and show the dialog.  The first Component argument
     * determines which frame the dialog depends on; it should be
     * a component in the dialog's controlling frame. The second
     * Component argument should be null if you want the dialog
     * to come up with its left corner in the center of the screen;
     * otherwise, it should be the component on top of which the
     * dialog should appear.The last argument specifies whether the 
     * dialog is to have 1 or 2 text fields
     */
    
	public static void showDialog(Component frameComp,
										Component locationComp,
										String labelText,
										String title,
										int type) 
										{
			Frame frame = JOptionPane.getFrameForComponent(frameComp);
			
			dialog = new InputDialog(frame,
									locationComp,
									labelText,
									title,
									type);
			dialog.setVisible(true);
			
		}
	
	
	private void setValue(String newName) {
			name = newName;
			
		}
		
	private void setValue(Double newAmount) {
				amount = newAmount.doubleValue();
				
			}
		
	private InputDialog(Frame frame,
						   Component locationComp,
						   String labelText,
						   String title,
						   int type) {
			super(frame, title, true);

			//Create and initialize the buttons.
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("CANCEL");
			cancelButton.addActionListener(this);
			
			final JButton setButton = new JButton("Set");
			setButton.setActionCommand("SET");
			setButton.addActionListener(this);
			getRootPane().setDefaultButton(setButton);
			
			nameField = new JTextField(5);
			amountField = new JTextField(5);

				//Create an array of the text and components to be displayed.
				String msgString1 = "Your Name : ";
				String msgString2 = "Amount you would like to start with : ";
				String msgString3 = "Amount : ";
				
				JLabel label = new JLabel(msgString1);
				JLabel label1 = new JLabel(msgString2);
				JLabel label2 = new JLabel(msgString3);
						  
				//Lay out the label and scroll pane from top to bottom.
					   JPanel listPane = new JPanel();
					   listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
					   
					  if (type == 1)
					  {
					   listPane.add(label);
					   listPane.add(nameField);
					   listPane.add(Box.createRigidArea(new Dimension(0,5)));
					   
					   listPane.add(label1);
						listPane.add(amountField);
						listPane.add(Box.createRigidArea(new Dimension(0,5)));
					  }
					  
					  else if(type == 0)
					  {
						  listPane.add(label2);
							listPane.add(amountField);
							listPane.add(Box.createRigidArea(new Dimension(0,5)));
					  }
					  
					   listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

					   //Lay out the buttons from left to right.
					   JPanel buttonPane = new JPanel();
					   buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
					   buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
					   buttonPane.add(Box.createHorizontalGlue());
					   buttonPane.add(cancelButton);
					   buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
					   buttonPane.add(setButton);

					   //Put everything together, using the content pane's BorderLayout.
					   Container contentPane = getContentPane();
					   contentPane.add(listPane, BorderLayout.CENTER);
					   contentPane.add(buttonPane, BorderLayout.PAGE_END);

					   //Initialize values.
					   setValue(" ");
					   setValue(new Double(0));
					   pack();
					   setLocationRelativeTo(locationComp);
				   }

				   //Handle clicks on the Set and Cancel buttons.
				   public void actionPerformed(ActionEvent e) {
					   if ("SET".equals(e.getActionCommand())) {
						   setValue((String)(nameField.getText()));
						   setValue(new Double(amountField.getText()));
						   
					   }
					   
					   else if("CANCEL".equals(e.getActionCommand()))
				        {
				         setValue(new Double(-1));
				        }
					   InputDialog.dialog.setVisible(false);
				   }

				
			   }
			   