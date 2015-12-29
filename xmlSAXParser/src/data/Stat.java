package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Stat {
	private String name;
	private ArrayList<Status> stats;
	private int index;
	
	public Stat() {
		this.stats = new ArrayList<Status>();
		this.index = -1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addStatus(Status status) {
		this.stats.add(status);
		this.index++;
	}
	
	public void addText(String text) {
		this.stats.get(index).setText(text);
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t<" + this.name + ">\n");
			for(Status temp : this.stats) {
				temp.write(out);
			}
			out.write("\t\t</" + this.name + ">\n");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
