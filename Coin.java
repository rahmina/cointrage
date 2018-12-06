/**
 * Constructor of coin object. Represents a cryptocurrency listed on an exchange 
 * 
 * @author AustinKRahmin
 *
 */
public class Coin {
	
	String exchange; 
	String asset; 
	double bid; 
	double ask; 
	
/**
 *  Constructor of coin object 
 * @param exchange the exchange the cryptocurrency is listed on 
 * @param asset the name of the cryptocurrency
 * @param bid the current bid price of the cryptocurrency on the given exchange 
 * @param ask the current ask price of the cryptocurrency on the given exchange
 */
	public Coin(String exchange, String asset, double bid, double ask) {
		this.exchange = exchange; 
		this.asset = asset; 
		this.bid = bid; 
		this.ask = ask;
	}

	/** Setter for exchange
	 * 
	 * @param name exchange name 
	 */
	public void setExchange(String name) {
		this.exchange = name;
	}
/** Setter for the coinname
 * 
 * 
 * @param asset coin name
 */
	public void setAsset(String asset) {
		this.asset = asset;
	}

/** Getter for the exchange 
 * 
 * 
 * @return exchange name
 */
	public String getExchange() {
		return exchange;
	}
/** Getter for coin name 
 * 
 * 
 * @return asset's name 
 */
	public String getAsset() {
		return asset;
	}
/** Getter for bid price 
 * 
 * 
 * @return bid price 
 */
	public double getBidPrice() {
		return bid;
	}

	/** Getter for ask price 
	 * 
	 * 
	 * @return ask price 
	 */
	public double getAskPrice() {
		return ask;
	}
	
	

}
