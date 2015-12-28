package data;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Magic getMagic() {
		return magic;
	}

	public void setMagic(Magic magic) {
		this.magic = magic;
	}
	
}
