package data;

import java.io.BufferedWriter;
import java.io.IOException;

public class Status {
	private String name;
	private String text;

	public Status(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void setText(String text) {
		this.text = text;
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
