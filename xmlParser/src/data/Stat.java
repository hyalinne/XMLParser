package data;

import org.w3c.dom.Element;

public class Stat {
	private String name;
	private int length;
	private Status[] stats;
	
	public Stat(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.stats = new Status[length];
		for(int i = 0; i < this.length; i++) {
			this.stats[i] = new Status((Element) item.getChildNodes().item(i*2 + 1));
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

	public Status[] getStats() {
		return stats;
	}

	public void setStats(Status[] stats) {
		this.stats = stats;
	}

}
