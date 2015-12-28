package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class MagicElement {
	private String name;
	private String text;
	private String attribute;
	private String attributeValue;

	public MagicElement(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.text = item.getTextContent();
		this.attribute = item.getAttributes().item(0).getNodeName();
		this.attributeValue = item.getAttributes().item(0).getTextContent();
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t\t\t\t<" + this.name + " " + this.attribute + "='" + this.attributeValue + "'>");
			out.write(this.text + "</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
