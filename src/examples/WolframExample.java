package examples;


import proclub.members.ProClub;
import proclub.wolfram.*;

public class WolframExample extends ProClub.Beginner{

	public static void main(String[] args) {
		//Wolfram Alpha
		WolframAlpha wa = new WolframAlpha();
		wa.auth();
		wa.prepareQuery("how many people are in my country");
		WolframResponse wr = wa.executeQuery();
		println(wr);
		println(wr.getPods());
		println(wr.getPod("Input"));
	}
}