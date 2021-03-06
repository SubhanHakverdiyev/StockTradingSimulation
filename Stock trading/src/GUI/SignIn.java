package GUI;

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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import StockTrade.Controller;
import StockTrade.MyPortfolio;


public class SignIn extends javax.swing.JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	/**
     * Creates new form LoginSignUpForm
     */
    
    int posX;
    int posY;
    
    public SignIn() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(255, 255, 255, 0));
        inpUsername.setBackground(new Color(255, 255, 255, 0));
        inpPassword.setBackground(new Color(255, 255, 255, 0));
        chkAgree.setBackground(new Color(255, 255, 255, 0));
        inpUsername.setText("");
        inpPassword.setText("");
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        btnslideSignUp=new javax.swing.JButton();
        exitbutton=new javax.swing.JButton();

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
        jLabel9.setText("Username");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 220, 150, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(520, 390, 320, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(520, 300, 320, 20);

  
   
        btnSignIn.setOpaque(false);
        btnSignIn.setFocusPainted(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        btnSignIn.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSignIn.setText("Sign In");
        getContentPane().add(btnSignIn);
        btnSignIn.setBounds(520, 540, 140, 43);
        btnSignIn.setIcon(new ImageIcon("resources/last.png"));
        btnSignIn.setHorizontalTextPosition(SwingConstants.CENTER);

        btnSignIn.addActionListener(this);
        
       
     
        
       
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sign In");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550,540,60,30);
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        

        inpUsername.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        inpUsername.setForeground(new java.awt.Color(255, 255, 255));
        inpUsername.setBorder(null);
        getContentPane().add(inpUsername);
        inpUsername.setBounds(520, 250, 320, 50);

     
        inpPassword.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        inpPassword.setForeground(new java.awt.Color(255, 255, 255));
        inpPassword.setText("jPasswordField1");
        inpPassword.setBorder(null);
        getContentPane().add(inpPassword);
        inpPassword.setBounds(520, 340, 320, 50);

     

        //jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       // ImageIcon img= new ImageIcon("resources/last.png");
       // jLabel6.setIcon(img); // NOI18N
       // getContentPane().add(jLabel6);
       // jLabel6.setBounds(520, 540, 123, 43);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sign Up");
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        getContentPane().add(jLabel5);
        jLabel5.setBounds(767, 40, 80, 30);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Login");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(690, 40, 60, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img1= new ImageIcon("resources/lgnnew.png");
        jLabel3.setIcon(img1); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 30, 131, 49);

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

        
        btnslideSignUp.setOpaque(false);
        btnslideSignUp.setFocusPainted(false);
        btnslideSignUp.setBorderPainted(false);
        btnslideSignUp.setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        btnslideSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon img2= new ImageIcon("resources/signupnew.png");
        btnslideSignUp.setIcon(img2); // NOI18N
        getContentPane().add(btnslideSignUp);
        btnslideSignUp.setHorizontalTextPosition(SwingConstants.CENTER);
        btnslideSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnslideSignUp.setBounds(730, 30, 131, 49);
        btnslideSignUp.addActionListener(this);

        
        
        
        

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

	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnslideSignUp;
    private javax.swing.JButton exitbutton;


    private javax.swing.JCheckBox chkAgree;
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
	private boolean registered;
    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==btnSignIn) {
			registered=false;

		   this.dispose();
		   MyPortfolio.loaduser();
		   for(MyPortfolio user:Controller.users) {
			   if(inpUsername.getText().equals(user.getUserName())) {
				   registered=true;
				   if(String.valueOf(inpPassword.getPassword()).equals(user.getPassword())) {
					
					StockMarketDisplay.createAndShowGUI(user);

				} 
				   
				   else 
						JOptionPane.showMessageDialog(getContentPane(), "Wrong password");
			   }
		   }
		   
		   
		   
		   if(registered==false) {
				JOptionPane.showMessageDialog(getContentPane(), "You have not registered. Please sign up and try again.");
			     new SignUp().setVisible(true);
		   }

		}
		if(arg0.getSource()==btnslideSignUp) {
			this.dispose();
			new SignUp().setVisible(true);
		}
	}
}