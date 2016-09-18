package proclub.spotify;
import java.util.ArrayList;
import java.util.List;

import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.SimpleArtist;
import com.wrapper.spotify.models.SimpleTrack;

public class SpotifyAlbum {

	private String key;
	private Album album;

	public SpotifyAlbum(String key) {

		this.key = key;
		AlbumRequest request = Spotify.api.getAlbum(this.key).build();

		try {
			album = request.get();

		} catch (Exception e) {
			System.out.println("Could not get albums.");
		}
	}

	public SpotifyAlbum() {
		
		this.key = "7e0ij2fpWaxOEHv5fUYZjd"; //Default album
		AlbumRequest request = Spotify.api.getAlbum(this.key).build();
		
		try {
			album = request.get();

		} catch (Exception e) {
			System.out.println("Could not get albums.");
		}
	}
	
	public String getName() {
		return album.getName();
	}
	
	public ArrayList<SpotifyArtist> getArtists() {
		ArrayList<SpotifyArtist> out = new ArrayList<SpotifyArtist>();
		List<SimpleArtist> artists = album.getArtists();
		
		for(SimpleArtist artist: artists) {
			out.add(new SpotifyArtist(artist.getId()));
		}
		
		return out;
	}
	
	public ArrayList<String> getGenres() {
		return (ArrayList<String>) album.getGenres();
	}
	
	public String getId() {
		return album.getId();
	}
	
	public ArrayList<SpotifyTrack> getTracks() {
		ArrayList<SpotifyTrack> out = new ArrayList<SpotifyTrack>();
		List<SimpleTrack> tracks = album.getTracks().getItems();
		
		for(SimpleTrack track: tracks) {
			out.add(new SpotifyTrack(track.getId()));
		}
		
		return out;
	}
	
	public String getLink() {
		return album.getHref();
	}
	
	public String getReleaseDate() {
		return album.getReleaseDate();
	}
	
	
	
	
	
	
	
}
