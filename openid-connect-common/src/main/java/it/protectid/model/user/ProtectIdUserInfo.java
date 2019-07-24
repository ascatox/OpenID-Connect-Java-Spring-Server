package it.protectid.model.user;

/**
 * @author ascatox
 */
public class ProtectIdUserInfo extends org.mitre.openid.connect.model.DefaultUserInfo {
	protected String postalCode;
	protected String street;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
