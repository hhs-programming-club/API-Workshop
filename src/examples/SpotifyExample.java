package examples;

import proclub.spotify.*;

public class SpotifyExample {

	public static void main(String[] args) {
	Spotify spotify = new Spotify();
		
		SpotifyAlbum album = spotify.searchAlbum("Thriller"); //Album name goes here
		System.out.println(album.getName());

		SpotifyTrack track = spotify.searchTrack("Thriller"); //Track name goes here
		System.out.println(track.getName());

		SpotifyArtist artist = spotify.searchArtist("Michael Jackson"); //Artist name goes here
		System.out.println(artist.getName());

		SpotifyUser user = spotify.searchUser("hhsprogrammingclub");
		System.out.println(user.getId());
	}
}