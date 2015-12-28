package data;

import org.w3c.dom.Element;

public class Status {
	private String name;
	private String text;

	public Status(Element item) {
		// TODO Auto-generated constructor stub
		this.name = item.getNodeName();
		this.text = item.getTextContent();
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

}
