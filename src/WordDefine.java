import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class WordDefine {	
	

	
public static String printWordDefine(String word)  {		
	String	key = "a86b75c5-47c4-4200-a95d-a7ba425cf3d3";
	
	String answer = "";
	
	try
	{
	DocumentBuilderFactory DBfactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder DB = DBfactory.newDocumentBuilder();
	

		Document doc = DB.parse("http://www.dictionaryapi.com/api/v1/references/collegiate/xml/"+ word +"?key="+ key);
		doc.getDocumentElement().normalize();
		//System.out.println(doc.getDocumentElement().getNodeName());
		answer = doc.getElementsByTagName("ew").item(0).getTextContent() + ":\n";
		
		NodeList dtList = doc.getElementsByTagName("dt");
		for(int i=0;i<dtList.getLength();i++)
		{
			answer  += dtList.item(i).getTextContent();
		}	
	}
	catch (Exception e)
	{
		answer = "Problem with word: " + e.getMessage();
		e.printStackTrace();
		
	}
	return answer;
}

}	