package proclub.twitter;

import proclub.api.API;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPI extends API {
	
	public TwitterAPI() {
		super("Twitter");
	}
	
	public static Twitter getApi() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("HvceKDr60zc7YvFMBIZTcuJy7")
		  .setOAuthConsumerSecret("7Y4BFwDMjurg1oWakFfHyy65m6xbcEtJ3PqbSr3YmonCXPjJBV")
		  .setOAuthAccessToken("776668206257745921-5JPypDTrfdeDcGZ8UOzERHWBIyz3JMU")
		  .setOAuthAccessTokenSecret("vp25u81HfkoqfrEwIPB7yGnQ2qtldSV503DchthwQ6Uun");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
}