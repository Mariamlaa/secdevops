package test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LireFichierXML{
	 
	
	public static void main(String argv[])   
	{  
	try   
	{  

	File file = new File("C:\\\\Users\\\\mlaachouc\\\\eclipse-workspace\\\\test\\\\src\\\\main\\\\webapp\\\\test.xml");  

	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
	//dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
	dbf.setFeature("http://xml.org/sax/features/external-general-entities",false);  
	dbf.setFeature("http://xml.org/sax/features/external-parameter-entities",false);
   
	//an instance of builder to parse the specified xml file  
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	doc.getDocumentElement().normalize();  
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	NodeList nodeList = doc.getElementsByTagName("Employee");  
	// nodeList is not iterable, so we are using for loop  
	for (int itr = 0; itr < nodeList.getLength(); itr++)   
	{  
	Node node = nodeList.item(itr);  
	System.out.println("\nNode Name :" + node.getNodeName());  
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node;   
	System.out.println("First Name: "+ eElement.getElementsByTagName("name").item(0).getTextContent());    
	}  
	}  
	}   
	catch (Exception e)   
	{  
	e.printStackTrace();  
	}  
	}  
}