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
}
