package it.eng.protectid.model.pdw;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ascatox
 */
@Entity
@Table(name = "pdw")
public class Pdw {

	public static final String QUERY_ALL = "Pdw.queryAll";
	public static final String QUERY_BY_ID = "Pdw.queryById";
	public static final String PARAM_ID = "id";
	private Long id;
	private String pid;
	private String addrSid;
	private String pkSid;
	private String skSid;
	private String addrDp;
	private String ppa;
	private Date tsc;
	private Date tse;

	public Pdw(String addrSid, String addrDp) {
		this.addrSid = addrSid;
		this.addrDp = addrDp;
		this.tsc = new Date();
	}

	public Pdw() {
	}

	public Pdw(String pid, String addrSid, String pkSid, String skSid, String addrDp, String ppa) {
		this.pid = pid;
		this.addrSid = addrSid;
		this.pkSid = pkSid;
		this.skSid = skSid;
		this.addrDp = addrDp;
		this.ppa = ppa;
		this.tsc = new Date();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAddrSid() {
		return addrSid;
	}

	public void setAddrSid(String addrSid) {
		this.addrSid = addrSid;
	}

	public String getPkSid() {
		return pkSid;
	}

	public void setPkSid(String pkSid) {
		this.pkSid = pkSid;
	}

	public String getSkSid() {
		return skSid;
	}

	public void setSkSid(String skSid) {
		this.skSid = skSid;
	}

	public String getAddrDp() {
		return addrDp;
	}

	public void setAddrDp(String addrDp) {
		this.addrDp = addrDp;
	}

	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}

	@Basic
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "tsc")
	public Date getTsc() {
		return tsc;
	}

	public void setTsc(Date tsc) {
		this.tsc = tsc;
	}
	@Basic
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "tse")
	public Date getTse() {
		return tse;
	}

	public void setTse(Date tse) {
		this.tse = tse;
	}
}
