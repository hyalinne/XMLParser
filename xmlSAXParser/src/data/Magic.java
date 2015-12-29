package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Magic {
	private String name;
	private ArrayList<MagicKind> magicKinds;
	private int index;

	public Magic() {
		// TODO Auto-generated constructor stub
		this.magicKinds = new ArrayList<MagicKind>();
		this.index = -1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addMagicKind(MagicKind magicKind) {
		this.magicKinds.add(magicKind);
		this.index++;
	}
	
	public void addMagicLevel(MagicLevel magicLevel) {
		this.magicKinds.get(index).addMagicLevel(magicLevel);
	}
	
	public void addMagicType(MagicType magicType) {
		this.magicKinds.get(index).addMagicType(magicType);
	}
	
	public void addMagicElement(MagicElement magicElement) {
		this.magicKinds.get(index).addMagicElement(magicElement);
	}
	
	public void addText(String text) {
		this.magicKinds.get(index).addText(text);
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t<" + this.name + ">\n");
			for(MagicKind temp : this.magicKinds) {
				temp.write(out);
			}
			out.write("\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
