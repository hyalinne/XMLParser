package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MagicLevel {
	private String name;
	private ArrayList<MagicType> magicTypes;
	private String attribute;
	private String attributeValue;
	private int index;

	public MagicLevel(String name, String attr, String attrV) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.attribute = attr;
		this.attributeValue = attrV;
		this.index = -1;
		this.magicTypes = new ArrayList<MagicType>();
	}
	
	public void addMagicType(MagicType magicType) {
		this.magicTypes.add(magicType);
		this.index++;
	}
	
	public void addMagicElement(MagicElement magicElement) {
		this.magicTypes.get(index).addMagicElement(magicElement);
	}
	
	public void addText(String text) {
		this.magicTypes.get(index).addText(text);
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t\t<" + this.name + " " + this.attribute + "='" + this.attributeValue + "'>\n");
			for(MagicType temp : this.magicTypes) {
				temp.write(out);
			}
			out.write("\t\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
