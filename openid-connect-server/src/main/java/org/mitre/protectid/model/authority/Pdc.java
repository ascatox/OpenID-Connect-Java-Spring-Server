package org.mitre.protectid.model.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ascatox
 */
@Entity
@Table(name="pdc")
public class Pdc {
	String id;
	String ppa;
	String dps;
	String dpr;

	public Pdc() {
	}

	public Pdc(String id, String ppa, String dps, String dpr) {
		this.id = id;
		this.ppa = ppa;
		this.dps = dps;
		this.dpr = dpr;
	}

	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}

	public String getDps() {
		return dps;
	}

	public void setDps(String dps) {
		this.dps = dps;
	}

	public String getDpr() {
		return dpr;
	}

	public void setDpr(String dpr) {
		this.dpr = dpr;
	}
}
