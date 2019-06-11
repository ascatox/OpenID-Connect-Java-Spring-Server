package org.mitre.pdw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ascatox
 */
@Entity
@Table(name = "pdw")
public class Pdw {

	public static final String QUERY_ALL = "Pdw.queryAll";
	public static final String QUERY_BY_ID = "Pdw.queryById";
	public static final String PARAM_ID = "id";
	private String id;
	private String pid;
	private String sid;
	private String ppa;

	public Pdw(String id, String pid, String sid, String ppa) {
		this.id = id;
		this.pid = pid;
		this.sid = sid;
		this.ppa = ppa;
	}

	public Pdw() {
	}

	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}
}
