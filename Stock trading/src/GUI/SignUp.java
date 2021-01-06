package GUI;
import StockTrade.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;


public class SignUp extends javax.swing.JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	/**
     * Creates new form LoginSignUpForm
     */
    
    int posX;
    int posY;
    
    public SignUp() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(255, 255, 255, 0));
        inpUsername.setBackground(new Color(255, 255, 255, 0));
        inpPassword.setBackground(new Color(255, 255, 255, 0));
        inpEmail.setBackground(new Color(255, 255, 255, 0));
        chkAgree.setBackground(new Color(255, 255, 255, 0));
        inpUsername.setText("");
        inpPassword.setText("");
        inpEmail.setText("");
       
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);

            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        btnslideSignUp=new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();

        inpEmail = new javax.swing.JTextField();
        inpUsername = new javax.swing.JTextField();
        inpPassword = new javax.swing.JPasswordField();
        chkAgree = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 650));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 650));
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(520, 310, 150, 30);

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 220, 150, 30);

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(520, 130, 150, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(520, 390, 320, 20);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(520, 210, 320, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(520, 300, 320, 20);

   
        btnSignUp.setOpaque(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        btnSignUp.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSignUp.setText("Sign Up");
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(520, 580, 140, 43);
        btnSignUp.setIcon(new ImageIcon("resources/last.png"));
        btnSignUp.setHorizontalTextPosition(SwingConstants.CENTER);

        btnSignUp.addActionListener(this);
        
       
     
        
       
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sign Up");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550,580,60,30);
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        
        
        exitbutton.setOpaque(false);
        exitbutton.setFocusPainted(false);
        exitbutton.setBorderPainted(false);
        exitbutton.setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exitbutton.setForeground(new java.awt.Color(255, 255, 255));
        exitbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(exitbutton);
        exitbutton.setBounds(500, 20, 70, 70);
        exitbutton.setIcon(new ImageIcon("resources/rszfinal.png"));
        exitbutton.setHorizontalTextPosition(SwingConstants.CENTER);

        exitbutton.addActionListener(this);

        inpEmail.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        inpEmail.setForeground(new java.awt.Color(255, 255, 255));
        inpEmail.setBorder(null);
        getContentPane().add(inpEmail);
        inpEmail.setBounds(520, 250, 320, 50);

        inpUsername.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        inpUsername.setForeground(new java.awt.Color(255, 255, 255));
        inpUsername.setBorder(null);
        getContentPane().add(inpUsername);
        inpUsername.setBounds(520, 160, 320, 50);

        inpPassword.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        inpPassword.setForeground(new java.awt.Color(255, 255, 255));
        inpPassword.setText("jPasswordField1");
        inpPassword.setBorder(null);
        getContentPane().add(inpPassword);
        inpPassword.setBounds(520, 340, 320, 50);
         
        
        
        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose your knowledge level");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 430, 200, 30);
        
        
        exlevel.setFont(new java.awt.Font("Berlin Sans FB",0,15));
        exlevel.setForeground(new java.awt.Color(255, 255, 255));
         getContentPane().add(exlevel);
         exlevel.setBounds(520, 460, 200, 30);

        
        
        chkAgree.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        chkAgree.setForeground(new java.awt.Color(255, 255, 255));
        chkAgree.setText("I agree to the terms and conditions");
        chkAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAgreeActionPerformed(evt);
                
            }
        });
        getContentPane().add(chkAgree);
        chkAgree.setBounds(520, 530, 310, 25);

        //jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       // ImageIcon img= new ImageIcon("resources/last.png");
       // jLabel6.setIcon(img); // NOI18N
       // getContentPane().add(jLabel6);
       // jLabel6.setBounds(520, 540, 123, 43);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sign Up");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(770, 40, 80, 30);
        
        
        
        
        

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Login");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(680, 40, 60, 30);
        
        
        
        btnslideSignUp.setOpaque(false);
        btnslideSignUp.setFocusPainted(false);
        btnslideSignUp.setBorderPainted(false);
        btnslideSignUp.setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        
        btnslideSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img1= new ImageIcon("resources/greenbgg.png");
        btnslideSignUp.setIcon(img1); // NOI18N
        getContentPane().add(btnslideSignUp);
        btnslideSignUp.setBounds(660, 30, 131, 49);
       btnslideSignUp.setHorizontalTextPosition(SwingConstants.CENTER);
        btnslideSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnslideSignUp.addActionListener(this);
        
        
        
      
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img9= new ImageIcon("resources/whitebg.png");
        jLabel3.setIcon(img9); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(730, 30, 131, 49);
        
        

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><p>Programming 3</p><p>Portfolio Manager</p></html>");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 130, 2450, 63);

        rightPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img3= new ImageIcon("resources/rightPanel.png");
        rightPanel.setIcon(img3); // NOI18N        
        getContentPane().add(rightPanel);
        rightPanel.setBounds(500, 0, 550, 660);

        leftPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img4= new ImageIcon("resources/np.png");
        leftPanel.setIcon(img4); // NOI18N       
        getContentPane().add(leftPanel);
        leftPanel.setBounds(-70, 0, 650, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setBorder(Border createEmptyBorder) {
		// TODO Auto-generated method stub
		
	}

	private void chkAgreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAgreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAgreeActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnslideSignUp;
    private javax.swing.JButton exitbutton;


    private javax.swing.JCheckBox chkAgree;
    private javax.swing.JTextField inpEmail;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel leftPanel;
    private javax.swing.JLabel rightPanel;
    String[] exLevel = new String[] {"Basic", "Medium",
            "Good", "Professional"};
    JComboBox<String> exlevel = new JComboBox<>(exLevel);

    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean check=true;
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnSignUp) {
			MyPortfolio.loaduser();
			for(MyPortfolio port: Controller.users) {
				if(inpUsername.getText().trim()==port.getUserName()) {
					check=false;
					break;
				}
			}
			
			
		if(!chkAgree.isSelected()|| inpEmail.getText().trim().isEmpty() || inpPassword.getText().trim().isEmpty() || inpUsername.getText().trim().isEmpty() ) {
		JOptionPane.showMessageDialog(getContentPane(), "Fill everything please");
		
	
		}
		
		else {
			if(!check)
				JOptionPane.showMessageDialog(getContentPane(), "The Username already exists please choose another username and try again");

			else
			JOptionPane.showMessageDialog(getContentPane(), "Successfully signed");
		
			MyPortfolio newUser= new MyPortfolio(inpUsername.getText(),inpEmail.getText(),String.valueOf(inpPassword.getPassword()));
			Controller.users.add(newUser);
			MyPortfolio.saveUser();
			
		  this.dispose();
          new SignIn().setVisible(true);
		
		
		
		
		}

		}
		
		if(arg0.getSource()==btnslideSignUp) {
			this.dispose();
			new SignIn().setVisible(true);
		}
		if(arg0.getSource()==exitbutton) {
			this.dispose();
		}
		
		
		
		
	}
}