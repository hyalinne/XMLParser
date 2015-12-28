package data;

import org.w3c.dom.Element;

public class MagicLevel {
	private String name;
	private int length;
	private MagicType[] magicTypes;
	private String attribute;
	private String attributeValue;
	
	public MagicLevel(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.length = item.getChildNodes().getLength()/2;
		this.magicTypes = new MagicType[this.length];
		for(int i = 0; i < this.length; i++) {
			this.magicTypes[i] = new MagicType((Element) item.getChildNodes().item(i*2 + 1));
		}
		this.attribute = item.getAttributes().item(0).getNodeName();
		this.attributeValue = item.getAttributes().item(0).getTextContent();
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

	public MagicType[] getMagicTypes() {
		return magicTypes;
	}

	public void setMagicTypes(MagicType[] magicTypes) {
		this.magicTypes = magicTypes;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
}
