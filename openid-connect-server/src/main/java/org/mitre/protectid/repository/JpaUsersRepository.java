package org.mitre.protectid.repository;

import org.mitre.openid.connect.model.UserInfo;
import org.mitre.protectid.model.user.Users;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ascatox
 */
@Repository("jpaUsersRepository")
public class JpaUsersRepository {



	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;


	@Transactional
	public Users createUser(String username, String password) throws Exception {
		Users usersRet = null;
		UserInfo userInfoRet = null;
		if (!StringUtils.isEmpty(username)) {
			Users users = new Users(username, password, true);
			usersRet = JpaUtil.saveOrUpdate(null, manager, users);
		}
		return usersRet;
	}


}
