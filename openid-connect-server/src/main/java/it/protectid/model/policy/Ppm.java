package it.protectid.model.policy;

import javax.persistence.*;

/**
 * @author ascatox
 * @author clod16
 */
@Entity
@Table(name="ppm")
@NamedQueries({
	@NamedQuery(name = Ppm.QUERY_ALL, query = "select p from Ppm p")
})
public class Ppm {

	public static final String QUERY_ALL = "Ppm.queryAll";

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
	@Basic
	@Column(name = "dp")
	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}
	@Basic
	@Column(name = "mod")
	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}
}
