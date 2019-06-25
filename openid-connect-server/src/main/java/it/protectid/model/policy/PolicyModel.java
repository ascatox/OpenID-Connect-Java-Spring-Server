package it.protectid.model.policy;

import java.util.ArrayList;
import java.util.List;

public class PolicyModel {

	private List<Attribute> attributes;


	public PolicyModel() {
		this.attributes = new ArrayList<>();
	}

	public PolicyModel(List<Attribute> attributeList) {
		this.attributes = attributeList;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public static class Attribute {
		private String name;
		private String value;
		private boolean check;

		public Attribute(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public boolean isCheck() {
			return check;
		}

		public void setCheck(boolean check) {
			this.check = check;
		}
	}
}
