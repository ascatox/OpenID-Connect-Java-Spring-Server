package org.mitre.protectid.repository;

import org.mitre.protectid.model.authority.Authorities;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ascatox
 */
@Repository("jpaAuthoritiesRepository")
public class JpaAuthoritiesRepository {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;


	@Transactional
	public Authorities createAuthority(String username) throws Exception {
		Authorities authorityRet = null;
		if (!StringUtils.isEmpty(username)) {
			Authorities a = new Authorities(username, Authorities.AUTHORITIES_CONST.ROLE_USER.name());
			authorityRet = JpaUtil.saveOrUpdate(null, manager, a);
		}
		return authorityRet;
	}

}
