package examples;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import jwiki.core.Wiki;

public class WikipediaExample {

	public static void main(String[] args) throws LoginException {
		Scanner s = new Scanner(System.in);
		System.out.println("Username:");
		String username = s.nextLine();
		System.out.println("Password:");
		String password = s.nextLine();
		Wiki wiki = new Wiki(username, password, "en.wikipedia.org");
		

	}

}
