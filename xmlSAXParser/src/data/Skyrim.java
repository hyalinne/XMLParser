package data;

import java.io.BufferedWriter;
import java.io.IOException;

public class Skyrim {
	private String name;
	private Character character;
	
	public void setName(String name) {
		this.name = name;
	}

	public void addCharacter(Character character) {
		this.character = character;
	}
	
	public void write(BufferedWriter out) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		String root = "<" + this.name + " xmlns=\"http://uxmlab.mju.ac.kr/Skyrim\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://uxmlab.mju.ac.kr/Skyrim ./skyrim.xsd\">\n";
		try {
			// start
			out.write(xml);
			out.write(root);
			character.write(out);
			// end
			out.write("</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCharacter(Character character) { this.character = character; }
}
