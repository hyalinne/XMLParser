package xmlParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class Main {
	private Document doc;
	private data.Character character;

	public static void main(String argv[]) {
		Main main = new Main();
		String fromPath = "./workspace/Skyrim.xml";
		String toPath = "./workspace/Skyrim2.xml";
		main.read(fromPath);
		main.write(toPath);
	} 

	public void write(String filePath) {
		
	}

	public void read(String filePath) {
		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			
			Element cElement = (Element)doc.getElementsByTagName("character").item(0);
			this.character = new data.Character(cElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}