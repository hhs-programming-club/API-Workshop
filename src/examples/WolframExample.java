package examples;


import proclub.members.ProClub;
import proclub.wolfram.*;

public class WolframExample extends ProClub.Beginner{

	public static void main(String[] args) {
		//Wolfram Alpha
		WolframAlpha wa = new WolframAlpha();
		wa.auth();
		wa.prepareQuery("what is the value of pi?");
		WolframResponse wr = wa.executeQuery();
		String output = wr.getPod("Decimal approximation");
		System.out.println(output);
	}
}