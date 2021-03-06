package it.protectid.repository;

import it.protectid.model.authority.Authorities;
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
@Repository("jpaAuthoritiesRepository")
public class JpaAuthoritiesRepository extends JpaUtil{

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;

	@Transactional
	public List<Authorities> getAuthorityByUsername(String username) {
		TypedQuery<Authorities> query = manager.createNamedQuery(Authorities.QUERY_BY_USERNAME, Authorities.class);
		query.setParameter(Authorities.PARAM_USERNAME, username);
		return query.getResultList();
	}

	@Transactional
	public List<Authorities> getAll() {
		TypedQuery<Authorities> query = manager.createNamedQuery(Authorities.QUERY_ALL, Authorities.class);
		return query.getResultList();
	}

	@Transactional
	public Authorities createAuthority(String username) {
		Authorities authorityRet = null;
		if (!StringUtils.isEmpty(username)) {
			Authorities a = new Authorities(username, Authorities.AUTHORITIES_CONST.ROLE_USER.name());
			authorityRet = saveOrUpdate(null, manager, a);
		}
		return authorityRet;
	}

	@Transactional
	public void delete(Authorities authorities) {
		if (!StringUtils.isEmpty(authorities.getUsername())) {
			delete(manager, authorities);
		}
	}

}
