package xmlParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import data.*;

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
			out.write("\t<" + character.getName() + ">\n");
			// race
			Race race = this.character.getRace();
			out.write("\t\t<" + race.getName() + ">\n");
			for(int i = 0; i < race.getLength(); i++) {
				out.write("\t\t\t<" + race.getRaceType()[i].getName() + ">\n");
				for(int j = 0; j < race.getRaceType()[i].getLength(); j++) {
					out.write("\t\t\t\t<" + race.getRaceType()[i].getRaceKind()[j].getName() + ">\n");
					RacePower power = race.getRaceType()[i].getRaceKind()[j].getRacePower();
					out.write("\t\t\t\t\t<" + power.getName() + " " + power.getAttribute() +"='" + power.getAttributeValue() + "'>");
					out.write(power.getText() + "</" + power.getName() + ">\n");
					out.write("\t\t\t\t</" + race.getRaceType()[i].getRaceKind()[j].getName() + ">\n");
				}
				out.write("\t\t\t</" + race.getRaceType()[i].getName() + ">\n");
			}
			out.write("\t\t</" + race.getName() + ">\n");
			// stat
			Stat stat = this.character.getStat();
			out.write("\t\t<" + stat.getName() + ">\n");
			for(int i = 0; i < stat.getLength(); i++) {
				out.write("\t\t\t<" + stat.getStats()[i].getName() + ">");
				out.write(stat.getStats()[i].getText() + "</" + stat.getStats()[i].getName() + ">\n");
			}
			out.write("\t\t</" + stat.getName() + ">\n");
			// magic
			Magic magic = this.character.getMagic();
			out.write("\t\t<" + magic.getName() + ">\n");
			for(int i = 0; i < magic.getLength(); i++) {
				out.write("\t\t\t<" + magic.getMagicKind()[i].getName() + ">\n");
				for(int j = 0; j < magic.getMagicKind()[i].getLength(); j++) {
					MagicLevel mLevel = magic.getMagicKind()[i].getMagicLevel()[j];
					out.write("\t\t\t\t<" + mLevel.getName() + " " + mLevel.getAttribute() + "='" + mLevel.getAttributeValue() + "'>\n");
					for(int k = 0; k < mLevel.getLength(); k++) {
						out.write("\t\t\t\t\t<" + mLevel.getMagicTypes()[k].getName() + ">\n");
						for(int t = 0; t < mLevel.getMagicTypes()[k].getLength(); t++) {
							MagicElement mElement = mLevel.getMagicTypes()[k].getMagicElements()[t];
							out.write("\t\t\t\t\t\t<" + mElement.getName() + " " + mElement.getAttribute() + "='" + mElement.getAttributeValue() + "'>");
							out.write(mElement.getText() + "</" + mElement.getName() + ">\n");
						}
						out.write("\t\t\t\t\t</" + mLevel.getMagicTypes()[k].getName() + ">\n");
					}
					out.write("\t\t\t\t</" + mLevel.getName() + ">\n");
				}
				out.write("\t\t\t</" + magic.getMagicKind()[i].getName() + ">\n");
			}
			out.write("\t\t</" + magic.getName() + ">\n");
			// end tag
			out.write("\t</" + character.getName() + ">\n");
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
			
			Element cElement = (Element)doc.getElementsByTagName("character").item(0);
			this.character = new data.Character(cElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}