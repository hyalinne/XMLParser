package xmlParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import data.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private Skyrim skyrim;
	private data.Character character;
	private Race race;
	private Stat stat;
	private Magic magic;

	public static void main(String argv[]) {
		Main main = new Main();
		String fromPath = "./workspace/Skyrim.xml";
		String toPath = "./workspace/Skyrim2.xml";
		main.read(fromPath);
		main.write(toPath);
	} 

	public Main() {
		this.skyrim = new Skyrim();
		this.character = new data.Character();
		this.race = new Race();
		this.stat = new Stat();
		this.magic = new Magic();
		this.character.setRace(race);
		this.character.setStat(stat);
		this.character.setMagic(magic);
	}

	public void write(String filePath) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			skyrim.write(out);
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
				private boolean bPower = false;
				private boolean bStat = false;
				private boolean bMagic = false;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					if(qName.equals("Skyrim")) {
						skyrim.setName(qName);;
					} else if(qName.equals("character")) {
						character.setName(qName);
						skyrim.setCharacter(character);
					} else if(qName.equals("race")) {
						race.setName(qName);
						character.setRace(race);
					} else if(qName.equals("human") || qName.equals("elven") || qName.equals("beast")) {
						RaceType temp = new RaceType(qName);
						race.addRaceType(temp);
					} else if(qName.equals("nord") || qName.equals("breton") || qName.equals("imperial") || qName.equals("redgard") || qName.equals("dunmer") ||
							qName.equals("bosmer") || qName.equals("altmer") || qName.equals("orc") || qName.equals("khajiit") || qName.equals("argonian")) {
						RaceKind temp = new RaceKind(qName);
						race.addRaceKind(temp);
					} else if(qName.equals("race_power")) {
						RacePower temp = new RacePower(qName, attributes.getQName(0), attributes.getValue(0));
						race.addRacePower(temp);
						bPower = true;
					} else if(qName.equals("stat")) {
						stat.setName(qName);
					} else if(qName.equals("health") || qName.equals("magicka") || qName.equals("stamina")) {
						Status temp = new Status(qName);
						stat.addStatus(temp);
						bStat = true;
					} else if(qName.equals("magic")) {
						magic.setName(qName);
					} else if(qName.equals("desturction")) {
						MagicKind temp = new MagicKind(qName);
						magic.addMagicKind(temp);
					} else if(qName.equals("novice") || qName.equals("apprentice") || qName.equals("adept") || qName.equals("expert") || qName.equals("master")) {
						MagicLevel temp = new MagicLevel(qName, attributes.getQName(0), attributes.getValue(0));
						magic.addMagicLevel(temp);
					} else if(qName.equals("spray") || qName.equals("missile") || qName.equals("rune") || qName.equals("area_missile") || qName.equals("cloak") || qName.equals("heavy_missile") || qName.equals("wall") || qName.equals("storm")) {
						MagicType temp = new MagicType(qName);
						magic.addMagicType(temp);
					} else if(qName.equals("fire") || qName.equals("ice") || qName.equals("shock")) {
						MagicElement temp = new MagicElement(qName, attributes.getQName(0), attributes.getValue(0));
						magic.addMagicElement(temp);
						bMagic = true;
					}
				}

				@Override
				public void characters(char ch[], int start, int length) throws SAXException {
					if (bPower) {
						race.addText(new String(ch, start, length));
						bPower = false;
					} else if (bStat) {
						stat.addText(new String(ch, start, length));
						bStat = false;
					} else if (bMagic) {
						magic.addText(new String(ch, start, length));
						bMagic = false;
					} 
				}
			};
			parser.parse(new File(filePath), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}