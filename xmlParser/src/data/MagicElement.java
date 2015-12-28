package data;

import org.w3c.dom.Element;

public class MagicElement {
	private String name;
	private String text;
	private String attribute;
	private String attributeValue;

	public MagicElement(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.text = item.getTextContent();
		this.attribute = item.getAttributes().item(0).getNodeName();
		this.attributeValue = item.getAttributes().item(0).getTextContent();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
