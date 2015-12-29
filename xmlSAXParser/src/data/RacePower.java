package data;

import java.io.BufferedWriter;
import java.io.IOException;

public class RacePower {
	private String name;
	private String text;
	private String attribute;
	private String attributeValue;

	public RacePower(String name, String attribute, String attrV) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.attribute = attribute;
		this.attributeValue = attrV;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void write(BufferedWriter out) {
		try {
			out.write("\t\t\t\t\t<" + this.name + " " + this.attribute +"='" + this.attributeValue + "'>");
			out.write(this.text + "</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
