package proclub.wolfram;

import com.wolfram.alpha.*;
import proclub.api.API;

public class WolframResponse extends API{
	protected WAQueryResult result;
		
	public WolframResponse(WAQueryResult res){
		super("Wolfram Response");
		result = res;
	}

	public String[] getPods(){
		WAPod[] arr =  result.getPods();
		String[] sArr = new String[arr.length];
		for(int i = 0; i < arr.length; i++)
			sArr[i] = arr[i].getTitle();

		return sArr;
	}
	public String getPod(String title){
		WAPod[] pods = result.getPods();
		StringBuilder sb = new StringBuilder();
		for (WAPod pod : pods)
			if (pod.getTitle().equals(title)) {
				for (WASubpod subpod : pod.getSubpods())
					for (Object element : subpod.getContents())
						if (element instanceof WAPlainText)
							sb.append((((WAPlainText) element).getText()) + ", ");
				return sb.substring(0, sb.length() - 2);
			}


		warn("Uh-oh! There is no pod with the name: " + title);
		return null;
	}
		

	public String toXML(){
		return result.getXML();
	}	
	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		for (WAPod pod : result.getPods()) {
			if (!pod.isError()) {
				sb.append(pod.getTitle() + "{\n");
				for (WASubpod subpod : pod.getSubpods())
					for (Object element : subpod.getContents())
						if (element instanceof WAPlainText)
							sb.append("\t" + (((WAPlainText) element).getText()) + "\n");
				sb.append("}\n");
			}
		}
		return sb.toString();
	}
}