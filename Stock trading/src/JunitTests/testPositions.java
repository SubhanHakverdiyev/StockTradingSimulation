package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import StockTrade.Position;
import StockTrade.Stock;

public class testPositions {

	@Test
	public void test() {
		
		
		Stock berkshire= new Stock("BRK","Berkshire",150,2020,12,17);
		Position pos= new Position(berkshire,2);
       assertEquals(300,pos.currentValue(),1e-15);
	}
	
	@Test
	public void testVolume() {
		
		
		Stock berkshire= new Stock("BRK","Berkshire",150,2020,12,17);
		Position pos= new Position(berkshire,2);
       assertEquals(2,pos.getVolume());
	}

}
