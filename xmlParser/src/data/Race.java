package data;

import org.w3c.dom.Element;

public class Race {
	private RaceType[] raceType;
	private int length;
	private String name;
	
	public Race(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.raceType = new RaceType[this.length];
		for(int i = 0; i < this.length; i++) {
			this.raceType[i] = new RaceType((Element) item.getChildNodes().item(i*2 + 1));
		}
	}

	public RaceType[] getRaceType() {
		return raceType;
	}

	public void setRaceType(RaceType[] raceType) {
		this.raceType = raceType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}
