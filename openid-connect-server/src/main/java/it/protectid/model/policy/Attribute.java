package it.protectid.model.policy;

public class Attribute {


	private String name;
	private boolean check;
	private String value;


	public Attribute() {
	}


	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public Attribute(String name, boolean check, String value) {
		this.name = name;
		this.check = check;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
