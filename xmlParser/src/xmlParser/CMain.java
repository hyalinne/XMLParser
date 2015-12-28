package xmlParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class CMain {

  public static void main(String argv[]) {

    try {
		File fXmlFile = new File("./workspace/Skyrim.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		doc.getDocumentElement().normalize();
		System.out.println("<" + doc.getDocumentElement().getNodeName() + ">");
		
		Element character = (Element) doc.getElementsByTagName("character").item(0);
		Element race = (Element) character.getElementsByTagName("race").item(0);
		Element stat = (Element) character.getElementsByTagName("stat").item(0);
		Element magic = (Element) character.getElementsByTagName("magic").item(0);
		
		System.out.println("<" + character.getNodeName() + ">");
		// race
		System.out.println("<" + race.getNodeName() + ">");
		NodeList raceList = race.getChildNodes();
		for(int i = 1; i < raceList.getLength(); i += 2) {
			System.out.println("<" + raceList.item(i).getNodeName() + ">");
			NodeList list = raceList.item(i).getChildNodes();
			for(int j = 1; j < list.getLength(); j += 2) {
				System.out.println("<" + list.item(j).getNodeName() + ">");
				Element pElement = (Element) ((Element) list.item(j)).getElementsByTagName("race_power").item(0);
				System.out.println("<" + pElement.getNodeName() + " type='" + pElement.getAttribute("type") + "'>" + pElement.getTextContent() + "</race_power>");
				System.out.println("</" + list.item(j).getNodeName() + ">");
			}
			System.out.println("</" + raceList.item(i).getNodeName() + ">");
		}
		System.out.println("</" + race.getNodeName() + ">");
		
		// stat
		System.out.println("<" + stat.getNodeName() + ">");
		for(int i = 1; i < stat.getChildNodes().getLength(); i += 2) {
			System.out.printf("<" + stat.getChildNodes().item(i).getNodeName() + ">");
			System.out.printf(stat.getChildNodes().item(i).getTextContent());
			System.out.println("</" + stat.getChildNodes().item(i).getNodeName() + ">");
		}
		System.out.println("</" + stat.getNodeName() + ">");
		
		// magic
		System.out.println("<" + magic.getNodeName() + ">");
		for(int i = 1; i < magic.getChildNodes().getLength(); i += 2) {
			System.out.println("<" + magic.getChildNodes().item(i).getNodeName() + ">");
			// level
			NodeList levelList = magic.getChildNodes().item(i).getChildNodes();
			for(int j = 1; j < levelList.getLength(); j += 2) {
				System.out.println("<" + levelList.item(j).getNodeName() + " type='" + levelList.item(j).getAttributes().item(0).getTextContent() + "'>");
				// magic
				NodeList magicList = levelList.item(j).getChildNodes();
				for(int k = 1; k < magicList.getLength(); k += 2) {
					System.out.println("<" + magicList.item(k).getNodeName() + ">");
					// magic type
					NodeList mTypeList = magicList.item(k).getChildNodes();
					for(int t = 1; t < mTypeList.getLength(); t += 2) {
						System.out.printf("<" + mTypeList.item(t).getNodeName() + " type='" + mTypeList.item(t).getAttributes().item(0).getTextContent() +"'>");
						System.out.printf(mTypeList.item(t).getTextContent());
						System.out.println("</" + mTypeList.item(t).getNodeName() + ">");
					}
					System.out.println("</" + magicList.item(k).getNodeName() + ">");
				}
				System.out.println("</" + levelList.item(j).getNodeName() + ">");
			}
			System.out.println("</" + magic.getChildNodes().item(i).getNodeName() + ">");
		}
		System.out.println("</" + magic.getNodeName() + ">");
		
		System.out.println("</" + character.getNodeName() + ">");
		
		System.out.println("</" + doc.getDocumentElement().getNodeName() + ">");
		
    } catch (Exception e) {
    	e.printStackTrace();
    }
  } 
  
  public void write() {
	  
  }
  
  public void read() {
	  
  }

}