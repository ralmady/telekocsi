package telekocsi.XMLFeldolgozó;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import telekocsi.model.Utas;

public class Reg {
	
	public static void Regisztráció (Utas u1) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = null;
			
			File f = new File("utasok.xml");
			
			Element rootElement = null;
			
			if (!f.exists()) {
				doc  = db.newDocument();
				rootElement = doc.createElement("utasok");
				doc.appendChild(rootElement);
			}
			
			if (f.exists()) {
				doc = db.parse(f);
				rootElement = doc.getDocumentElement();
			}
			
			
			
			Element utasElem = doc.createElement("utas");
			rootElement.appendChild(utasElem);
			
			Element névElem = doc.createElement("név");
			névElem.appendChild(doc.createTextNode(u1.getNév()));
			utasElem.appendChild(névElem);
			
			Element telElem = doc.createElement("telefon");
			telElem.appendChild(doc.createTextNode(u1.getTelefon()));
			utasElem.appendChild(telElem);
			
			Element passElem = doc.createElement("jelszó");
			passElem.appendChild(doc.createTextNode(u1.getJelszó()));
			utasElem.appendChild(passElem);
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			
			t.transform(source, result);


		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
