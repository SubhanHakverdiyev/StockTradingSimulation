package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import StockTrade.MyPortfolio;
import StockTrade.Stock;
import StockTrade.StockMarket;

public class testBuyandSell {

	@Test
	public void testBuy() {
		
		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);
		Stock berkshire= new Stock("BRK","Berkshire",150,2020,12,17);
       assertEquals(true,m.buyError(berkshire, 1));	
	}
	
	
	
	@Test
	public void testSell() {
		
		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);
		Stock berkshire= new Stock("BRK","Berkshire",30,2020,12,17);
		StockMarket usa = new StockMarket("usa");
		usa.add(berkshire);
		m.buy(usa, "BRK",2);
		
       assertEquals(true,m.sellError("BRK", 3));	
	}

	@Test
	public void testSell2() {
		
		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);
		Stock berkshire= new Stock("BRK","Berkshire",30,2020,12,17);
		StockMarket usa = new StockMarket("usa");
		usa.add(berkshire);
		m.buy(usa, "BRK",2);
		
       assertEquals(true,m.sellError("BRK", -2));	
	}

	@Test
	public void testbuy2() {
		

		MyPortfolio m = new MyPortfolio("Hasan","test@gmail.com","123456");
		m.deposit(100);
		Stock berkshire= new Stock("BRK","Berkshire",150,2020,12,17);
       assertEquals(true,m.buyError(berkshire, -1));	
	}


}
