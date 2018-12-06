import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
/** Class that access CoinAPI.io in order to get data on the cryptocurrency
 * 
 * 
 * @author AustinKRahmin
 *
 */
public class CoinAPI {
	
	/**
	 * 
	 * 
	 * @param url CoinAPI.io's website 
	 * @return the accessed API as a string 
	 * @throws IOException
	 */
	public String makeAPICall(String url) throws IOException {
		URL coinAPI; 
		URLConnection yc; 
		BufferedReader in; 
		
		
		
		
		coinAPI = new URL(url);
		yc = coinAPI.openConnection();
		yc.setRequestProperty("X-CoinAPI-Key", "A3D5C5F1-3027-4511-B5B2-4EBB3AE7CE50");
		
		in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
		String inputLine;
		
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
		     response.append(inputLine);
		}
		in.close();
		     
		return response.toString();
		
	}
	
	/** Takes in the website's API as a JSONArray and saves the data as arrayList of Cryptocurrencies 
	 * 
	 * 
	 * @param jArray the JSONArray of CoinAPI's website
	 * @return ArrayList<Coin> that represents all the cryptocurrencies available in the market with their current prices on the current exchanges
	 * @throws JSONException
	 */
	public ArrayList<Coin> quoteCoins(JSONArray jArray) throws JSONException{
		ArrayList<Coin> market = new ArrayList<>();
		
		for(int i=0;i<jArray.length();i++) {
			String title=jArray.getJSONObject(i).getString("symbol_id");
			String exchange = title.split("_")[0];
			String asset = title.split("_")[2] + "_" + title.split("_")[3];
			double bid =jArray.getJSONObject(i).getDouble("bid_price");
			double ask =jArray.getJSONObject(i).getDouble("ask_price");
			Coin coin = new Coin(exchange, asset, bid, ask);
			market.add(coin);
		}
		return market; 
	}

	
	
}
