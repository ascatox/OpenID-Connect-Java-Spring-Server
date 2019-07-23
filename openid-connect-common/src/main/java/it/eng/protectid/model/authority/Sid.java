package it.eng.protectid.model.authority;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name = "sid")
@NamedQueries({
	@NamedQuery(name = Sid.QUERY_ALL, query = "select s from Sid s"),
	@NamedQuery(name = Sid.QUERY_BY_ID, query = "select s from Sid s where s.id = :" + Sid.PARAM_ID),
})
public class Sid {
	public static final String QUERY_BY_ID = "Sid.queryById";
	public static final String QUERY_ALL = "Sid.queryAll";
	public static final Integer CERT_LEVEL_LOW = 0;
	public static final String PARAM_ID = "id";
	public static final Integer CERT_LEVEL_AVG = 1;
	public static final Integer CERT_LEVEL_HIGH = 2;

	protected Long id;
	protected String pip;
	protected Integer crtLevel;
	protected String sig;
	protected String addr;

	public Sid() {
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
	@Basic
	@Column(name = "sig")
	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
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

	@Basic
	@Column(name = "addr")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
