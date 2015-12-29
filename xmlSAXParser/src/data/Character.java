package data;

import java.io.BufferedWriter;
import java.io.IOException;


public class Character {
	private String name;
	private Race race;
	private Stat stat;
	private Magic magic;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRace(Race race) { this.race = race; }
	public void setStat(Stat stat) { this.stat = stat; }
	public void setMagic(Magic magic) { this.magic = magic; }

	public void write(BufferedWriter out) {
		try {
			// start tag
			out.write("\t<" + this.name + ">\n");
			// race
			if(race != null) {
				race.write(out);
			}
			// stat
			stat.write(out);
			// magic
			if(magic != null) {
				magic.write(out);
			}
			// end tag
			out.write("\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
