package it.protectid.model.authority;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name="authorities")
@NamedQueries({
	@NamedQuery(name = Authorities.QUERY_ALL, query = "select a from Authorities a"),
	@NamedQuery(name = Authorities.QUERY_BY_USERNAME, query = "select a from Authorities a where a.username = :" + Authorities.PARAM_USERNAME),
})
public class Authorities {
	public static final String PARAM_USERNAME = "username";
	public static final String QUERY_ALL = "Users.queryAll";
	public static final String QUERY_BY_USERNAME = "Users.queryByUsername";

	protected String username;
	protected String authority;

	public enum AUTHORITIES_CONST {
		ROLE_ADMIN, ROLE_USER
	}

	public Authorities() {
	}

	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Basic
	@Column(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "authority")
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
