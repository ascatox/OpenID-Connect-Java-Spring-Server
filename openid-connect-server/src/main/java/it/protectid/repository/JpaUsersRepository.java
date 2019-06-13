package it.protectid.repository;

import it.protectid.model.authority.Authorities;
import it.protectid.model.user.Users;
import org.mitre.openid.connect.model.UserInfo;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author ascatox
 */
@Repository("jpaUsersRepository")
public class JpaUsersRepository extends JpaUtil{

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;
	@Transactional
	public List<Users> getUserByUsername(String username) throws Exception {
		TypedQuery<Users> query = manager.createNamedQuery(Users.QUERY_BY_USERNAME, Users.class);
		query.setParameter(Authorities.PARAM_USERNAME, username);
		return query.getResultList();
	}

	@Transactional
	public List<Users> getAll() throws Exception {
		TypedQuery<Users> query = manager.createNamedQuery(Users.QUERY_ALL, Users.class);
		return query.getResultList();
	}

	@Transactional
	public Users createUser(String username, String password) throws Exception {
		Users usersRet = null;
		UserInfo userInfoRet = null;
		if (!StringUtils.isEmpty(username)) {
			Users users = new Users(username, password, true);
			usersRet = saveOrUpdate(null, manager, users);
		}
		return usersRet;
	}

	@Transactional
	public void delete(Users user) throws Exception {
		if (!StringUtils.isEmpty(user.getUsername())) {
			delete(manager, user);
		}
	}


}
