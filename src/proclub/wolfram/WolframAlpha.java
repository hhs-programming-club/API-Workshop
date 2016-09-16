package proclub.wolfram;

import com.wolfram.alpha.*;
import proclub.api.API;

public class WolframAlpha extends API {
	private static WAEngine engine = new WAEngine()	;
	private static WAQuery query;

	public WolframAlpha(){
		super("Wolfram Alpha");
		map("APP_ID", "2EW9AH-6QWKL5HYWU");
		engine.setAppID(map("APP_ID"));	
	}
	public boolean prepareQuery(String input){
		if("".equals(input) || null == input)
			return null != warn("prepareQuery(input) had no input!");

		query = engine.createQuery();
		query.setInput(input);
		return true;
	}
	public WolframResponse executeQuery(){
		return executeQuery("plain");
	}
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