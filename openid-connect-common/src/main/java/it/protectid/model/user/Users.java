package it.protectid.model.user;

import javax.persistence.*;

/**
 * @author ascatox
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name = Users.QUERY_ALL, query = "select u from Users u"),
	//@NamedQuery(name = Users.QUERY_BY_USERNAME, query = "select u from Users u where u.username = :" + Authorities.PARAM_USERNAME),
})
public class Users {

	public static final String QUERY_ALL = "";
	public static final String QUERY_BY_USERNAME = "";
	protected String username;
	protected String password;
	protected boolean enabled;

	public Users() {
	}

	public Users(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
