package data;

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

	public MagicLevel[] getMagicLevel() {
		return magicLevel;
	}

	public void setMagicLevel(MagicLevel[] magicLevel) {
		this.magicLevel = magicLevel;
	}

}
