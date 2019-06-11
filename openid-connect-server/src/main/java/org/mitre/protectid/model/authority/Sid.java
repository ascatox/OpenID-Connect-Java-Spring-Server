package org.mitre.protectid.model.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ascatox
 */
@Entity
@Table(name="sid")
public class Sid {

	public static final Integer CERT_LEVEL_LOW = 0;
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

	public String getPip() {
		return pip;
	}

	public void setPip(String pip) {
		this.pip = pip;
	}

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
