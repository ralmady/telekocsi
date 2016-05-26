package telekocsi.XMLFeldolgozó;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import telekocsi.model.Ut;

public class Utak {
	
	public static List<Ut> listázó() {
		ArrayList<Ut> lista = new ArrayList<Ut>();
		
		File xml = new File("utak.xml");
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		
		NodeList list = doc.getElementsByTagName("ut");
		
		String id = "";
		String honnan = "";
		String hova = "";
		int helyek = 0;
		int ár = 0;
		LocalDateTime indulás;
		LocalDateTime érkezés;
		String sof;
		String utasok;
		
		
		
		for (int i =0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				id = element.getElementsByTagName("id").item(0).getTextContent();
				honnan = element.getElementsByTagName("Start").item(0).getTextContent();
				hova = element.getElementsByTagName("Cél").item(0).getTextContent();
				helyek = Integer.parseInt(element.getElementsByTagName("Helyek").item(0).getTextContent());
				ár = Integer.parseInt(element.getElementsByTagName("Ár").item(0).getTextContent());
				indulás = LocalDateTime.parse(element.getElementsByTagName("Indulás").item(0).getTextContent());
				érkezés = LocalDateTime.parse(element.getElementsByTagName("Érkezés").item(0).getTextContent());
				sof = element.getElementsByTagName("Sofőr").item(0).getTextContent();
				utasok =element.getElementsByTagName("Utas").item(0).getTextContent();
				
				
				lista.add(new Ut(id, honnan, hova, helyek, ár, indulás, érkezés, sof, utasok));
			
			}
		}
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
		
				
	}

}
