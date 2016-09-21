package examples;


import proclub.twitter.TwitterAPI;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterExample {
	
	public static void main(String[] args) throws TwitterException {
		// Connect to the Twitter API Library
		Twitter twitter = TwitterAPI.getApi();
	
		// Search for tweets
		String searchQuery = "programming";
		Query query = new Query(searchQuery);
	    QueryResult result = twitter.search(query);
	    
	    // Loop through results and print them out
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	}

}
