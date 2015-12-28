package data;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public MagicKind[] getMagicKind() {
		return magicKind;
	}

	public void setMagicKind(MagicKind[] magicKind) {
		this.magicKind = magicKind;
	}

}
