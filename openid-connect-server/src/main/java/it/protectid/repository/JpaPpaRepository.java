package it.protectid.repository;

import it.protectid.model.policy.Ppa;
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
@Repository("jpaPpaRepository")
public class JpaPpaRepository extends JpaUtil {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;


	@Transactional
	public List<Ppa> getAll() throws Exception {
		TypedQuery<Ppa> query = manager.createNamedQuery(Ppa.QUERY_ALL, Ppa.class);
		return query.getResultList();
	}

	@Transactional
	public Ppa create(Ppa ppa) throws Exception {
		Ppa ret = null;
		if (!StringUtils.isEmpty(ppa.getId())) {
			ret = saveOrUpdate(null, manager, ppa);
		}
		return ret;
	}


	@Transactional
	public void delete(Ppa ppa) throws Exception {
		if (!StringUtils.isEmpty(ppa.getId())) {
			delete(manager, ppa);
		}
	}
}
