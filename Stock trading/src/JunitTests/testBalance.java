package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import StockTrade.MyPortfolio;

public class testBalance {

	@Test
	public void test() {
		MyPortfolio mp= new MyPortfolio("Hasan","test@gmail.com","123456");
		double balance=mp.getMyBalance();
		assertEquals(0,balance,1e-15); // for delta paramater I used 1e-15 for just letting small differences to occur.
		
	}
	

	@Test
	public void testDeposit() {
		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);
       assertEquals(100,m.getMyBalance(),1e-15);		
	}
	

	@Test
	public void testWithdraw() {
		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);

		m.withdraw(50);
       assertEquals(50,m.balance(),1e-15);		
	}
	

}
