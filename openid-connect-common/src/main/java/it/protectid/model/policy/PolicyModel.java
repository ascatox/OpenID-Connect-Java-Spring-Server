package it.protectid.model.policy;

import java.io.Serializable;
import java.util.*;

public class PolicyModel implements Serializable{
	private List<Attribute> personalData;

	public PolicyModel() {
		this.personalData = new ArrayList<>();
	}

	public PolicyModel(List<Attribute> personalData) {
		this.personalData = personalData;
	}

	public List<Attribute> getPersonalData() {
		return personalData;
	}

	public void setPersonalData(List<Attribute> personalData) {
		this.personalData = personalData;
	}

	public static class Attribute implements Serializable {
		private String name;
		private String uri;
		private String id;
		private String description;
		private Integer personality;
		private Boolean transfer;
		private String finality;
		private Boolean mandatory;

		public Attribute() {
		}

		public Attribute(String name, String uri, String id, String description, Integer personality, Boolean transfer, String finality, Boolean mandatory) {
			this.name = name;
			this.uri = uri;
			this.id = id;
			this.description = description;
			this.personality = personality;
			this.transfer = transfer;
			this.finality = finality;
			this.mandatory = mandatory;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getPersonality() {
			return personality;
		}

		public void setPersonality(Integer personality) {
			this.personality = personality;
		}

		public Boolean getTransfer() {
			return transfer;
		}

		public void setTransfer(Boolean transfer) {
			this.transfer = transfer;
		}

		public String getFinality() {
			return finality;
		}

		public void setFinality(String finality) {
			this.finality = finality;
		}

		public Boolean getMandatory() {
			return mandatory;
		}

		public void setMandatory(Boolean mandatory) {
			this.mandatory = mandatory;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Attribute)) return false;
			Attribute attribute = (Attribute) o;
			return Objects.equals(getId(), attribute.getId());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getId());
		}
	}
}
