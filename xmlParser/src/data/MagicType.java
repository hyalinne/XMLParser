package data;

import org.w3c.dom.Element;

public class MagicType {
	private String name;
	private int length;
	private MagicElement[] magicElements;
	
	public MagicType(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.magicElements = new MagicElement[this.length];
		for(int i = 0; i < this.length; i++) {
			this.magicElements[i] = new MagicElement((Element) item.getChildNodes().item(i*2 + 1));
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

	public MagicElement[] getMagicElements() {
		return magicElements;
	}

	public void setMagicElements(MagicElement[] magicElements) {
		this.magicElements = magicElements;
	}
}
