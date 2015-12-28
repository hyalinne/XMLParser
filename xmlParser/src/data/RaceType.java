package data;

import java.io.BufferedWriter;
import java.io.IOException;

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

	public void write(BufferedWriter out) {
		try {
			out.write("\t\t\t<" + this.name + ">\n");
			for(int i = 0; i < this.length; i++) {
				this.raceKind[i].write(out);
			}
			out.write("\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
