package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MagicType {
	private String name;
	private ArrayList<MagicElement> magicElements;
	private int index;
	
	public MagicType(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.index = -1;
		this.magicElements = new ArrayList<MagicElement>();
	}
	
	public void addMagicElement(MagicElement m) {
		this.magicElements.add(m);
		index++;
	}
	
	public void addText(String text) {
		this.magicElements.get(index).setText(text);
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t\t\t<" + this.name + ">\n");
			for(MagicElement temp : this.magicElements) {
				temp.write(out);
			}
			out.write("\t\t\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
