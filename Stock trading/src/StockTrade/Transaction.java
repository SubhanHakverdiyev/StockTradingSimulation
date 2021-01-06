package StockTrade;

public class Transaction extends SpotPrice
{
public String stockKey;
public int volume;

Transaction(Stock stock, int volume){

super(stock.getSpotPrice());
stockKey = stock.getKey();
this.volume = volume;

}

}
