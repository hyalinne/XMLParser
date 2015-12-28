package data;

import org.w3c.dom.Element;

public class RaceKind {
	private String name;
	private RacePower racePower;
	
	public RaceKind(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.racePower = new RacePower((Element) item.getChildNodes().item(1));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RacePower getRacePower() {
		return racePower;
	}

	public void setRacePower(RacePower racePower) {
		this.racePower = racePower;
	}

}
