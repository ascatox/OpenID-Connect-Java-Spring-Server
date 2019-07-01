package it.protectid.model.authority;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name = "pdc")
public class Pdc {

	private String id;
	private String ppa;
	private String dps;
	private String dpr;

	public Pdc() {
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
	@Column(name = "ppa")
	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}

	@Basic
	@Column(name = "dps")
	public String getDps() {
		return dps;
	}

	public void setDps(String dps) {
		this.dps = dps;
	}

	@Basic
	@Column(name = "dpr")
	public String getDpr() {
		return dpr;
	}

	public void setDpr(String dpr) {
		this.dpr = dpr;
	}
}
