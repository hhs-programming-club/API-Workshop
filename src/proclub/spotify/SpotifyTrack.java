package proclub.spotify;
import java.util.ArrayList;
import java.util.List;

import com.wrapper.spotify.methods.TrackRequest;
import com.wrapper.spotify.models.SimpleArtist;
import com.wrapper.spotify.models.Track;

public class SpotifyTrack {

	private String key;
	private Track track;

	public SpotifyTrack(String key) {
		Spotify spotify = new Spotify();
		
		this.key = key;
		TrackRequest request = spotify.getApi().getTrack(this.key).build();

		try {
			track = request.get();

		} catch (Exception e) {
			System.out.println("Could not get tracks.");
		}
	}

	public SpotifyTrack() {
		Spotify spotify = new Spotify();
		
		this.key = "7oK9VyNzrYvRFo7nQEYkWN";
		TrackRequest request = spotify.getApi().getTrack(this.key).build();

		try {
			track = request.get();

		} catch (Exception e) {
			System.out.println("Could not get tracks.");
		}
	}
	
	public String getName() {
		return track.getName();
	}
	
	public ArrayList<SpotifyArtist> getArtists(){
		List<SimpleArtist> artists = track.getArtists();
		ArrayList<SpotifyArtist> out = new ArrayList<SpotifyArtist>();
		
		for(SimpleArtist artist: artists) {
			out.add(new SpotifyArtist(artist.getId()));
		}
		return out;
	}
	
	public String getId() {
		return track.getId();
	}
	
	public int getTrackNumber() {
		return track.getTrackNumber();
	}
	
	public int getDuration() {
		return track.getDuration();
	}
	
	public SpotifyAlbum getAlbum() {
		return new SpotifyAlbum(track.getAlbum().getId());
	}
	
	public String getLink() {
		return track.getHref();
	}
	
	public boolean isExplicit() {
		return track.isExplicit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
