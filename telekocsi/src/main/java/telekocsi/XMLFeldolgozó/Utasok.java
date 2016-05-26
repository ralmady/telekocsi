package telekocsi.XMLFeldolgozó;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import telekocsi.model.Utas;

public class Utasok {
	
	public static ArrayList<Utas> xmlből() {
		ArrayList<Utas> utasok = new ArrayList<Utas>();
		
		File xml = new File("utasok.xml");
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		String név = "";
		String tel = "";
		String jelsz = "";
		
		NodeList list = doc.getElementsByTagName("utas");
		
		for (int i =0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				név = element.getElementsByTagName("név").item(0).getTextContent();
				tel = element.getElementsByTagName("telefon").item(0).getTextContent();
				jelsz = element.getElementsByTagName("jelszó").item(0).getTextContent();
								
				utasok.add(new Utas (név, tel, jelsz));
			}
		}
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return utasok;
	}
		
}
