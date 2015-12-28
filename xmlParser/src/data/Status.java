package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class Status {
	private String name;
	private String text;

	public Status(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.text = item.getTextContent();
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t<" + this.name + ">");
			out.write(this.text + "</" + this.name + ">\n");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
