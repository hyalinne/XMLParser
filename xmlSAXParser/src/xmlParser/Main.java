package xmlParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					// start 
				}
			};
			parser.parse(new File(filePath), handler);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}