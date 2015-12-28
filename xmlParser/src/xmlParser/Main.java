package xmlParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
			String root = "<" + doc.getDocumentElement().getNodeName() + " xmlns=\"http://uxmlab.mju.ac.kr/Skyrim\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://uxmlab.mju.ac.kr/Skyrim ./skyrim.xsd\">\n" ;
			// start
			out.write(xml);
			out.write(root);
			character.write(out);
			// end
			out.write("</" + doc.getDocumentElement().getNodeName() + ">\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read(String filePath) {
		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			this.character = new data.Character((Element)doc.getElementsByTagName("character").item(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}