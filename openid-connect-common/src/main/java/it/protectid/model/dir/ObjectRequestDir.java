package it.protectid.model.dir;

public class ObjectRequestDir {

	private String fcn;
	private String payload;

	public ObjectRequestDir() {
	}

	public ObjectRequestDir(String fcn, String payload) {
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
		return "ObjectRequestDir{" +
			"fcn='" + fcn + '\'' +
			", payload='" + payload + '\'' +
			'}';
	}
}
