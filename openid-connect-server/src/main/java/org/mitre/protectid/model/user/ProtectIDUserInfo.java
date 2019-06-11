package org.mitre.protectid.model.user;

import org.mitre.openid.connect.model.DefaultUserInfo;

/**
 * @author ascatox
 */
public class ProtectIDUserInfo extends org.mitre.openid.connect.model.DefaultUserInfo {
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
