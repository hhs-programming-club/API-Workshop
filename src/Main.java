

import proclub.members.ProClub;
import proclub.spotify.Spotify;
import proclub.spotify.SpotifyAlbum;
import proclub.spotify.SpotifyArtist;
import proclub.spotify.SpotifyTrack;
import proclub.spotify.SpotifyUser;
import proclub.wolfram.*;

public class Main extends ProClub.Beginner{

	public static void main(String[] args) {
		//Wolfram Alpha
		WolframAlpha wa = new WolframAlpha();
		wa.auth();
		wa.prepareQuery("how many people are in my country");
		WolframResponse wr = wa.executeQuery();
		println(wr);
		println(wr.getPods());
		println(wr.getPod("Input"));

		//Spotify
		SpotifyAlbum album = Spotify.searchAlbum("Thriller"); //Album name goes here
		System.out.println(album.getName());

		SpotifyTrack track = Spotify.searchTrack("Thriller"); //Track name goes here
		System.out.println(track.getName());

		SpotifyArtist artist = Spotify.searchArtist("Michael Jackson"); //Artist name goes here
		System.out.println(artist.getName());

		SpotifyUser user = Spotify.searchUser("hhsprogrammingclub");
		System.out.println(user.getId());
	}
}