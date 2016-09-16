package proclub.api;

import java.util.HashMap;

public class API {
	private HashMap<String, String> map = new HashMap<String, String>();
	private String API_NAME = "Abstract API";

	public API(String name){ API_NAME = name; }

	
	//General API uses
	/**
	 * This method should be used as a storage space to map all
	 * the API-necessary values such as APP_ID, SECRET_KEY, etc...
	 * Each API has different values required to use it, but each
	 * of our APIs should store this initial info here.
	 * 
	 * @return returns true if the inputted key-value pair replaces
	 * a pair with the same key that was already in the map. 
	 */
	protected boolean map(String key, String val){
		if(map.containsKey(key)){
			map.put(key, val);
			return true;
		}
		map.put(key, val);
		return false;
	}
	/**
	 * This method should be used in combination with its namesake
	 * map(key, value). If a value has been mapped to the key given,
	 * it returns it the vaue
	 * 
	 * @return returns the value at the key if one exists. 
	 * Returns null if no such key has been mapped
	 */
	protected String map(String key){
		if(map.containsKey(key)) return map.get(key);
		warn("Map does not contain key: " + key);
		return null;
	}
	/**
	 * Used to warn users if an error occurs. 
	 */
	protected Object warn(String warning){
		System.err.println(API_NAME + ": " + warning);
		return null;
	}
}