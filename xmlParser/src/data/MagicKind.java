package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class MagicKind {
	private String name;
	private int length;
	private MagicLevel[] magicLevel;

	public MagicKind(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.magicLevel = new MagicLevel[this.length];
		for(int i = 0; i < this.length; i++) {
			this.magicLevel[i] = new MagicLevel((Element) item.getChildNodes().item(i*2 + 1));
		}
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t\t<" + this.name + ">\n");
			for(int i = 0; i < this.length; i++) {
				this.magicLevel[i].write(out);
			}
			out.write("\t\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
