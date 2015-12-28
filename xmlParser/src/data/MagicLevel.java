package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class MagicLevel {
	private String name;
	private int length;
	private MagicType[] magicTypes;
	private String attribute;
	private String attributeValue;

	public MagicLevel(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.magicTypes = new MagicType[this.length];
		for(int i = 0; i < this.length; i++) {
			this.magicTypes[i] = new MagicType((Element) item.getChildNodes().item(i*2 + 1));
		}
		this.attribute = item.getAttributes().item(0).getNodeName();
		this.attributeValue = item.getAttributes().item(0).getTextContent();
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t\t<" + this.name + " " + this.attribute + "='" + this.attributeValue + "'>\n");
			for(int i = 0; i < this.length; i++) {
				this.magicTypes[i].write(out);
			}
			out.write("\t\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
