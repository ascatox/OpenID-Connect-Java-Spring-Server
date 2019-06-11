package it.protectid.model.authority;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name="sid")
@NamedQueries({
	@NamedQuery(name = Sid.QUERY_ALL, query = "select s from Sid s"),
	@NamedQuery(name = Sid.QUERY_BY_ID, query = "select s from Sid s where s.id = :" + Sid.PARAM_ID),
	@NamedQuery(name = Sid.QUERY_BY_DP, query = "select s from Sid s where s.dp = :" + Sid.PARAM_DP),


})
public class Sid {
	public static final String QUERY_BY_DP = "Sid.queryByDp";
	public static final String QUERY_BY_ID = "Sid.queryById";
	public static final String QUERY_ALL = "Sid.queryAll";
	public static final Integer CERT_LEVEL_LOW = 0;
	public static final String PARAM_ID = "id";
	public static final String PARAM_DP = "dp";

	public static final Integer CERT_LEVEL_AVG = 1;
	public static final Integer CERT_LEVEL_HIGH = 2;


	protected String id;
	protected String pip;
	protected Integer crtLevel;

	public Sid() {
	}

	public Sid(String id, String pip) {
		this.id = id;
		this.pip = pip;
		this.crtLevel = CERT_LEVEL_LOW;
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
	@Column(name = "pip")
	public String getPip() {
		return pip;
	}

	public void setPip(String pip) {
		this.pip = pip;
	}
	@Basic
	@Column(name = "crtLevel")
	public Integer getCrtLevel() {
		return crtLevel;
	}

	public void setCrtLevel(Integer crtLevel) {
		this.crtLevel = crtLevel;
	}

	@Override
	public String toString() {
		return "Sid{" +
			"id='" + id + '\'' +
			", pip='" + pip + '\'' +
			", crtLevel=" + crtLevel +
			'}';
	}
}
