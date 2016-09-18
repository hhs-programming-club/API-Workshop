package proclub.wolfram;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.wolfram.alpha.*;
import proclub.api.API;

public class WolframResponse extends API{
	protected WAQueryResult result;
		
	protected WolframResponse(WAQueryResult res){
		super("Wolfram Response");
		result = res;
	}
	/**
	 * Used to get the names of all the Pods in this response.
	 * @return String array - contains the names/titles of all the Pods returned in this response
	 */
	public String[] getPods(){
		WAPod[] arr =  result.getPods();
		String[] sArr = new String[arr.length];
		for(int i = 0; i < arr.length; i++)
			sArr[i] = arr[i].getTitle();

		return sArr;
	}
	/**
	 * Used to get the data of a specific Pods in this response.
	 * @param title - the title of the Pod of which to get more data
	 * @return String - containing the data of all the named Pod requested
	 */
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
		
	/**
	 * Used to get the data represented by this WolframResponse in an XML data format.
	 * @return String - this response represented in the XML data format
	 */
	public String toXML(){
		return result.getXML();
	}
	
	/**
	 * Used to get the data represented by this WolframResponse in an Document controlled XML data format.
	 * @return org.w3c.dom.Document - a document capable of easily manipulating XML
	 */
	public Document toDocument(){
	    try {
	    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(toXML())));
			
			return document;
		} catch (SAXException | IOException | ParserConfigurationException e) {
			warn("Whoops! Looks like there was an error handling that operation...");
			warn("There was a " + e.getClass().getName());
		}	
		return null;
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