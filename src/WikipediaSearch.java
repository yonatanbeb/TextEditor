import java.io.BufferedReader;	
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;	
import java.io.InputStreamReader;	
import java.net.MalformedURLException;	
import java.net.URL;	
public class WikipediaSearch {	
	
	
	
public static void main(String[] args) throws Exception {	
	
	// TODO Auto-generated method stub

	Scanner userinput = new Scanner(System.in);	
	System.out.println("WORD: ");	



	String word = userinput.nextLine();	
	URL request = new URL("https://en.wikipedia.org/wiki/" + word);	
	InputStreamReader response = new InputStreamReader(request.openStream());	
	BufferedReader br = new BufferedReader(response);	

	String brLine = br.readLine();
	
	while(brLine != null){	
		System.out.println(brLine);
		brLine = br.readLine();
	
		
		DocumentBuilderFactory DBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder DB = DBfactory.newDocumentBuilder();
		
		try
		{
			Document doc = DB.parse("https://en.wikipedia.org/wiki/" + word);
			doc.getDocumentElement().normalize();
			//System.out.println(doc.getDocumentElement().getNodeName());
			System.out.println(doc.getElementsByTagName("li").item(0).getTextContent() + ":\n");
			
			NodeList dtList = doc.getElementsByTagName("li");
			for(int i=0;i<dtList.getLength();i++)
			{
				System.out.println(dtList.item(i).getTextContent());
			}
		}		
			catch (Exception e)
			{
				System.out.println("Problem with word: " + e.getMessage());
			}
				}
		
		}	
	



}
