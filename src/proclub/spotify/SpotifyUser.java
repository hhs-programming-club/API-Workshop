package proclub.spotify;
import com.wrapper.spotify.methods.UserRequest;
import com.wrapper.spotify.models.User;

public class SpotifyUser {
	
	private String key;
	private User user;
	
	public SpotifyUser(String key) {
		Spotify spotify = new Spotify();
		
		this.key = key;
		UserRequest request = spotify.getApi().getUser(this.key).build();

		try {
			user = request.get();

		} catch (Exception e) {
			System.out.println("Could not get users.");
		}
	}
	
	public SpotifyUser() {
		Spotify spotify = new Spotify();
		
		this.key = "hhsprogrammingclub";
		UserRequest request = spotify.getApi().getUser(this.key).build();

		try {
			user = request.get();
			
		} catch (Exception e) {
			System.out.println("Could not get users.");
		}
	}
	
	public String getName() {
		return user.getDisplayName();
	}
	
	public String getId() {
		return user.getId();
	}
	
	public String getCountry() {
		return user.getCountry();
	}
	
	public String getEmail() {
		return user.getEmail();
	}
	
	public String getLink() {
		return user.getHref();
	}
	
	
	
	
	
	
	
	
	
	
	
}
