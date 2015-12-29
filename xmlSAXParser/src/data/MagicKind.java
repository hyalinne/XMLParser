package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MagicKind {
	private String name;
	private int index;
	private ArrayList<MagicLevel> magicLevels;

	public MagicKind(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.magicLevels = new ArrayList<MagicLevel>();
		this.index = -1;		
	}
	
	public void addMagicLevel(MagicLevel magicLevel) {
		this.magicLevels.add(magicLevel);
		this.index++;
	}
	
	public void addMagicType(MagicType magicType) {
		this.magicLevels.get(index).addMagicType(magicType);
	}
	
	public void addMagicElement(MagicElement magicElement) {
		this.magicLevels.get(index).addMagicElement(magicElement);
	}
	
	public void addText(String text) {
		this.magicLevels.get(index).addText(text);
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t<" + this.name + ">\n");
			for(MagicLevel temp : this.magicLevels) {
				temp.write(out);
			}
			out.write("\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
