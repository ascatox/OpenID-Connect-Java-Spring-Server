package it.protectid.model.policy;

import org.mitre.openid.connect.model.ApprovedSite;

import javax.persistence.*;

/**
 * @author ascatox
 * @author clod16
 */
@Entity
@Table(name="ppm")
@NamedQueries({
	@NamedQuery(name = Ppm.QUERY_ALL, query = "select p from Ppm p"),
	@NamedQuery(name = Ppm.QUERY_BY_ID, query = "select p from Ppm p where p.id = :" + Ppm.PARAM_ID),
	@NamedQuery(name = Ppm.QUERY_BY_DP, query = "select p from Ppm p where p.dp = :" + Ppm.PARAM_DP),

})
public class Ppm {

	public static final String QUERY_ALL = "Ppm.queryAll";
	public static final String PARAM_DP = "dp";
	public static final String QUERY_BY_DP = "Ppm.queryByDp";
	public static final String QUERY_BY_ID = "Ppm.queryById";
	public static final String PARAM_ID = "id";

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
