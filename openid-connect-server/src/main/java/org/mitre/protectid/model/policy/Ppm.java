package org.mitre.protectid.model.policy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ascatox
 */
@Entity
@Table(name="ppm")
public class Ppm {
	String id;
	String dp;
	String mod;

	public Ppm() {
	}

	public Ppm(String id, String dp, String mod) {
		this.id = id;
		this.dp = dp;
		this.mod = mod;
	}
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}
}
