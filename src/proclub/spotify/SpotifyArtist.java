package proclub.spotify;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.models.Artist;

public class SpotifyArtist {
	private String key;
	private Artist artist;
	
	public SpotifyArtist(String key) {
		Spotify spotify = new Spotify();
		
		this.key = key;
		ArtistRequest request = spotify.getApi().getArtist(this.key).build();

		try {
			artist = request.get();

		} catch (Exception e) {
			System.out.println("Could not get artists.");
		}
	}
	
	public SpotifyArtist() {
		Spotify spotify = new Spotify();
		
		this.key = "08td7MxkoHQkXnWAYD8d6Q";
		ArtistRequest request = spotify.getApi().getArtist(this.key).build();

		try {
			artist = request.get();
			
		} catch (Exception e) {
			System.out.println("Could not get artists.");
		}
	}
	
	public String getName() {
		return artist.getName();
	}
	
	public String getId() {
		return artist.getId();
	}
	
	public String getLink() {
		return artist.getHref();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
