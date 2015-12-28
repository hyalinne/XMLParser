package data;

import java.io.BufferedWriter;
import java.io.IOException;

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
	
	public void write(BufferedWriter out) {
		try {
			out.write("\t\t<" + this.name + ">\n");
			for(int i = 0; i < this.length; i++) {
				this.raceType[i].write(out);
			}
			out.write("\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
