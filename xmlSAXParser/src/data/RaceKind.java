package data;

import java.io.BufferedWriter;
import java.io.IOException;

public class RaceKind {
	private String name;
	private RacePower racePower;
	
	public RaceKind(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void setRacePower(RacePower power) {
		this.racePower = power;
	}
	
	public void addText(String text) {
		this.racePower.setText(text);
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
