package data;

import org.w3c.dom.Element;

public class RaceType {
	private String name;
	private int length;
	private RaceKind[] raceKind;
	
	public RaceType(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.raceKind = new RaceKind[this.length];
		for(int i = 0; i < this.length; i++) {
			this.raceKind[i] = new RaceKind((Element) item.getChildNodes().item(i*2 + 1));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public RaceKind[] getRaceKind() {
		return raceKind;
	}

	public void setRaceKind(RaceKind[] raceKind) {
		this.raceKind = raceKind;
	}

}
