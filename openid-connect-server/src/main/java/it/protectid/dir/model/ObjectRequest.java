package it.protectid.dir.model;

public class ObjectRequest {

	private String fcn;
	private String payload;

	public ObjectRequest() {
	}

	public ObjectRequest(String fcn, String payload) {
		this.fcn = fcn;
		this.payload = payload;
	}

	public String getFcn() {
		return fcn;
	}

	public void setFcn(String fcn) {
		this.fcn = fcn;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "ObjectRequest{" +
			"fcn='" + fcn + '\'' +
			", payload='" + payload + '\'' +
			'}';
	}
}
