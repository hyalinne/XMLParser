package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class Character {
	private String name;
	private Race race;
	private Stat stat;
	private Magic magic;
		
	public Character(Element character) {
		this.name = character.getNodeName(); 
		this.race = new Race((Element) character.getElementsByTagName("race").item(0));
		this.stat = new Stat((Element) character.getElementsByTagName("stat").item(0));
		this.magic = new Magic((Element) character.getElementsByTagName("magic").item(0));
	}

	public void write(BufferedWriter out) {
		try {
			// start tag
			out.write("\t<" + this.name + ">\n");
			// race
			race.write(out);
			// stat
			stat.write(out);
			// magic
			magic.write(out);
			// end tag
			out.write("\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
