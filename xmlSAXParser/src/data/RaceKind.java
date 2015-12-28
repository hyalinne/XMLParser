package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class RaceKind {
	private String name;
	private RacePower racePower;
	
	public RaceKind(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.racePower = new RacePower((Element) item.getChildNodes().item(1));
	}

	public void write(BufferedWriter out) {
		try {
			out.write("\t\t\t\t<" + this.name + ">\n");
			this.racePower.write(out);
			out.write("\t\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
