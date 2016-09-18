package proclub.spotify;
import java.util.List;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.methods.UserRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.Track;
import com.wrapper.spotify.models.User;

public class Spotify {
	public static final String clientId = "282219ae7dc44096a618aeded72dcf8d";
	public static final String clientSecret = "7c8ada1ae58e431bb2a19160e9a646b8";
	public static final String redirectURI = "https://api.spotify.com/";
	public static final Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectURI).build();

	public static SpotifyAlbum searchAlbum(String keyword) {
		final AlbumSearchRequest request = Spotify.api.searchAlbums(keyword).offset(0).limit(3).build();
		String id = "";

		try {
			final Page<SimpleAlbum> albumSearchResult = request.get();

			id = albumSearchResult.getItems().get(0).getId();

		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}

		return new SpotifyAlbum(id);
	}

	public static SpotifyTrack searchTrack(String keyword) {
		final TrackSearchRequest request = Spotify.api.searchTracks(keyword).market("US").build();
		String id = "";

		try {
			final Page<Track> trackSearchResult = request.get();
			id = trackSearchResult.getItems().get(0).getId();
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}

		return new SpotifyTrack(id);
	}

	public static SpotifyArtist searchArtist(String keyword) {
		final ArtistSearchRequest request = Spotify.api.searchArtists(keyword).market("US").limit(10).build();
		String id = "";

		try {
			final Page<Artist> artistSearchResult = request.get();
			final List<Artist> artists = artistSearchResult.getItems();
			id = artists.get(0).getId();
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}

		return new SpotifyArtist(id);
	}

	public static SpotifyUser searchUser(String keyword) {
		final UserRequest request = Spotify.api.getUser(keyword).build();
		String id = "";

		try {
			final User user = request.get();
			id = user.getId(); 
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}

		return new SpotifyUser(id);
	}
}
