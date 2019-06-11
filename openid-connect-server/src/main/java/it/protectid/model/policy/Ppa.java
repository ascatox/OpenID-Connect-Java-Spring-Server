package it.protectid.model.policy;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name="ppa")
@NamedQueries({
	@NamedQuery(name = Ppa.QUERY_ALL, query = "select p from Ppa p")
})
public class Ppa {

	public static final String QUERY_ALL = "Ppa.queryAll";
	String id;
	String ppm;
	String pip;
	String opt;

	public Ppa() {
	}

	public Ppa(String id, String ppm, String pip, String opt) {
		this.id = id;
		this.ppm = ppm;
		this.pip = pip;
		this.opt = opt;
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
	@Column(name = "ppm")
	public String getPpm() {
		return ppm;
	}

	public void setPpm(String ppm) {
		this.ppm = ppm;
	}
	@Basic
	@Column(name = "pip")
	public String getPip() {
		return pip;
	}

	public void setPip(String pip) {
		this.pip = pip;
	}
	@Basic
	@Column(name = "opt")
	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}
}
