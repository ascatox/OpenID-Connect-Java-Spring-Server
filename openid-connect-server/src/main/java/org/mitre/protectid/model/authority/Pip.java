package org.mitre.protectid.model.authority;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name="ppa")
public class Pip {
	String id;
	String pk;
	String sidAuth;
	String sidCert;
	String ppaSubs;
	String ppaEmit;

	public Pip() {
	}

	public Pip(String id, String pk, String sidAuth, String sidCert, String ppaSubs, String ppaEmit) {
		this.id = id;
		this.pk = pk;
		this.sidAuth = sidAuth;
		this.sidCert = sidCert;
		this.ppaSubs = ppaSubs;
		this.ppaEmit = ppaEmit;
	}
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Basic
	@Column(name = "pk")
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
	@Basic
	@Column(name = "sidAuth")
	public String getSidAuth() {
		return sidAuth;
	}

	public void setSidAuth(String sidAuth) {
		this.sidAuth = sidAuth;
	}
	@Basic
	@Column(name = "sidCert")
	public String getSidCert() {
		return sidCert;
	}

	public void setSidCert(String sidCert) {
		this.sidCert = sidCert;
	}

	@Basic
	@Column(name = "ppaSubs")
	public String getPpaSubs() {
		return ppaSubs;
	}

	public void setPpaSubs(String ppaSubs) {
		this.ppaSubs = ppaSubs;
	}
	@Basic
	@Column(name = "ppaEmit")
	public String getPpaEmit() {
		return ppaEmit;
	}

	public void setPpaEmit(String ppaEmit) {
		this.ppaEmit = ppaEmit;
	}
}
