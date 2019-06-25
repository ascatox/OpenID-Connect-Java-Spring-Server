package it.protectid.repository;

import it.protectid.model.authority.Pip;
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
@Repository("jpaPipRepository")
public class JpaPipRepository extends JpaUtil {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;

	@Transactional
	public List<Pip> getAll() {
		TypedQuery<Pip> query = manager.createNamedQuery(Pip.QUERY_ALL, Pip.class);
		return query.getResultList();
	}

	@Transactional
	public Pip getById(String id) {
		return super.getById(id, Pip.class, manager);
	}

	@Transactional
	public Pip create(Pip pip) {
		Pip ret = null;
		if (!StringUtils.isEmpty(pip.getId())) {
			ret = saveOrUpdate(null, manager, pip);
		}
		return ret;
	}


	@Transactional
	public void delete(Pip pip)  {
		if (!StringUtils.isEmpty(pip.getId())) {
			delete(manager, pip);
		}
	}
}
