package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Race {
	private ArrayList<RaceType> raceTypes;
	private int index;
	private String name;
	
	public Race() {
		this.raceTypes = new ArrayList<RaceType>();
		this.index = -1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addRaceType(RaceType raceType) {
		this.raceTypes.add(raceType);
		this.index++;
	}

	public void addRaceKind(RaceKind temp) {
		this.raceTypes.get(index).addRaceKind(temp);	
	}
	
	public void addRacePower(RacePower power) {
		this.raceTypes.get(index).addRacePower(power);
	}
	
	public void addText(String text) {
		this.raceTypes.get(index).addText(text);
	}
	
	public void write(BufferedWriter out) {
		try {
			out.write("\t\t<" + this.name + ">\n");
			for(RaceType temp : raceTypes) {
				temp.write(out);
			}
			out.write("\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
