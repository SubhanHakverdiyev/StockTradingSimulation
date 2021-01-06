package StockTrade;
import GUI.SignUp;
import GUI.*;
import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

public class Controller {
	
	
	public static String userurl="C:\\Users\\Admin\\Documents\\users";

	public static ArrayList<MyPortfolio> users = new ArrayList<MyPortfolio>();

	
	public static void main(String[] args) {

		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        }
        //</editor-fold>
 catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   MyPortfolio.loaduser();
           MyPortfolio.saveUser();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
		
        
		
		
		
		
		
		
		
		
		
	
	}
}
