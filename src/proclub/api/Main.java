package proclub.api;

import proclub.members.ProClub;
import proclub.wolfram.*;

public class Main extends ProClub.Beginner{

	public static void main(String[] args) {
		WolframAlpha wa = new WolframAlpha();
		wa.prepareQuery("((3 * x + 6) mod 10)");
		WolframResponse wr = wa.executeQuery();
		println(wr.getPods());
		println(wr.getPod("Input"));
	}
}