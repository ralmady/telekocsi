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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import telekocsi.model.Ut;

public class Hirdetés {
	
	public static void Beszúr(Ut ut1) {
		if (ut1 != null) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = null;
			
			File f = new File("utak.xml");
			
			Element rootElement = null;
			
			if (!f.exists()) {
				doc  = db.newDocument();
				rootElement = doc.createElement("utak");
				doc.appendChild(rootElement);
			}
			
			if (f.exists()) {
				doc = db.parse(f);
				rootElement = doc.getDocumentElement();
			}
			
			
			
			Element utElem = doc.createElement("ut");
			rootElement.appendChild(utElem);
			
			Element idElem = doc.createElement("id");
			idElem.appendChild(doc.createTextNode(ut1.getId()));
			utElem.appendChild(idElem);
			
			Element honnanElem = doc.createElement("Start");
			honnanElem.appendChild(doc.createTextNode(ut1.getHonnan()));
			utElem.appendChild(honnanElem);
			
			Element hovaElem = doc.createElement("Cél");
			hovaElem.appendChild(doc.createTextNode(ut1.getHova()));
			utElem.appendChild(hovaElem);
			
			Element helyElem = doc.createElement("Helyek");
			String h = new String(ut1.getHelyek() + "");
			helyElem.appendChild(doc.createTextNode(h));
			utElem.appendChild(helyElem);
			
			Element árElem = doc.createElement("Ár");
			h = new String(ut1.getÁr() + "");
			árElem.appendChild(doc.createTextNode(h));
			utElem.appendChild(árElem);
			
			Element indElem = doc.createElement("Indulás");
			indElem.appendChild(doc.createTextNode(ut1.getIndulás().toString()));
			utElem.appendChild(indElem);
			
			Element érkElem = doc.createElement("Érkezés");
			érkElem.appendChild(doc.createTextNode(ut1.getÉrkezés().toString()));
			utElem.appendChild(érkElem);
			
			Element sofElem = doc.createElement("Sofőr");
			sofElem.appendChild(doc.createTextNode(ut1.getSof()));
			utElem.appendChild(sofElem);
			
			Element utasElem = doc.createElement("Utas");
			utasElem.appendChild(doc.createTextNode(""));
			utElem.appendChild(utasElem);
			
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
	public static void Frissit(Ut ut1) {
		if (ut1 != null) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = null;
			
			File f = new File("utak.xml");
			
			Element rootElement = null;
			
				doc = db.parse(f);
				rootElement = doc.getDocumentElement();
			
			NodeList list = doc.getElementsByTagName("ut");
			for (int i =0; i<list.getLength(); i++) {
				Node node = list.item(i);
				Element element = (Element) node;
				if (element.getElementsByTagName("id").item(0).getTextContent()
						.equals(ut1.getId())) {
					element.getElementsByTagName("Helyek").item(0).setTextContent(ut1.getHelyek() + "");
					StringBuilder sb = new StringBuilder();
					for (int j =0; j<ut1.getUtasok().size();i++) {
						sb.append(ut1.getUtasok().get(i).getNév());
						if (j!= ut1.getUtasok().size()-1) {
							sb.append(",");
						}
					}
					element.getElementsByTagName("Utas").item(0).setTextContent(sb.toString());
				}
			}
			
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
	

}
