package data;

import java.io.BufferedWriter;
import java.io.IOException;

import org.w3c.dom.Element;

public class Magic {
	private String name;
	private int length;
	private MagicKind[] magicKind;

	public Magic(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.magicKind = new MagicKind[this.length];
		for(int i = 0; i < this.length; i++) {
			this.magicKind[i] = new MagicKind((Element) item.getChildNodes().item(i*2 + 1));
		}
	}

	public void write(BufferedWriter out) {
		// TODO Auto-generated method stub
		try {
			out.write("\t\t<" + this.name + ">\n");
			for(int i = 0; i < this.length; i++) {
				this.magicKind[i].write(out);
			}
			out.write("\t\t</" + this.name + ">\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
