package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RaceType {
	private String name;
	private ArrayList<RaceKind> raceKinds;
	private int index;

	public RaceType(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.raceKinds = new ArrayList<RaceKind>();
		this.index = -1;
	}
	
	public void addRaceKind(RaceKind raceKind) {
		this.raceKinds.add(raceKind);
		this.index++;
	}

	public void addRacePower(RacePower power) {
		this.raceKinds.get(index).setRacePower(power);
	}
	
	public void addText(String text) {
		this.raceKinds.get(index).addText(text);
	}
	
	public void write(BufferedWriter out) {
		try {
			out.write("\t\t\t<" + this.name + ">\n");
			for(RaceKind temp : raceKinds) {
				temp.write(out);
			}
			out.write("\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
