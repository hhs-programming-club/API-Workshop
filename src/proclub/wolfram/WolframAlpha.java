package proclub.wolfram;

import com.wolfram.alpha.*;
import proclub.api.API;

public class WolframAlpha extends API {
	private static WAEngine engine = new WAEngine()	;
	private static WAQuery query;

	/**
	 * Instantiates a WolframAlpha Object and adds a Programming
	 * Club APP_ID
	 */
	public WolframAlpha(){
		super("Wolfram Alpha");
		map("APP_ID", "2EW9AH-6QWKL5HYWU");
	}
	/**
	 * Must be called before executing a query. This assures the Wolfram Alpha API
	 * that you are an authorized user capable of making requests 
	 */
	public void auth(){
		engine.setAppID(map("APP_ID"));
	}
	/**
	 * Must be called before executing a query. This prepares the query prior to
	 * execution. 
	 * @param input - the String that you would like to "ask" Wolfram Alpha about
	 * @return boolean - whether or not the input was an acceptable query
	 */
	public boolean prepareQuery(String input){
		if("".equals(input) || null == input)
			return null != warn("prepareQuery(input) had no input!");

		query = engine.createQuery();
		query.setInput(input);
		return true;
	}
	/**
	 * Must have called both auth() and prepareQuery(input) prior to calling this method.
	 * Sends the prepared query to Wolfram Alpha and gets the response, wrapped in a Wolfram Response object.
	 * @return WolframResponse - returns one WolframResponse, an HHS Programming Club made wrapper object, which provides simple methods for accessing the data of this API
	 */
	public WolframResponse executeQuery(){
		return executeQuery("plain");
	}
	/**
	 * Must have called both auth() and prepareQuery(input) prior to calling this method.
	 * Sends the prepared query to Wolfram Alpha and gets the response, wrapped in a Wolfram Response object.
	 * @param type - specifies the type of the return format;
	 * @return WolframResponse - returns one WolframResponse, an HHS Programming Club made wrapper object, which provides simple methods for accessing the data of this API
	 */
	public WolframResponse executeQuery(String type){
		if(null == query) return (WolframResponse) warn("executeQuery() requires that you call prepareQuery(input) first!");

		try {
			WAQueryResult queryResult = engine.performQuery(query);
			if(queryResult.isError())    return (WolframResponse) warn("Query error\n\terror code: " + queryResult.getErrorCode() + "\n\terror message: " + queryResult.getErrorMessage());
			if(!queryResult.isSuccess()) return (WolframResponse) warn("Yikes! You're query was not understood.");
			if(queryResult.isSuccess())  return new WolframResponse(queryResult);
			
		} catch (WAException e) { return (WolframResponse) warn(e.getMessage()); }
		return null;
	}
	/**
	 * Must have called prepareQuery(input) prior to calling this method.
	 * Resolves the URL that would be used to execute the prepared query.
	 * @return String - returns a String representing the resolved URL 
	 */
	public String getQueryURL(){
		if(null == query) return (String) warn("getQueryURL() requires that you call prepareQuery(input) first!");
		return engine.toURL(query);
	}
}

/*
	APP NAME: 	 ProClub-Wolfram
	APPID:		 2EW9AH-6QWKL5HYWU
	USAGE TYPE:  Personal/Non-commercial Only
*/