package it.protectid.repository;

import it.protectid.model.authority.Sid;
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
@Repository("jpaSidRepository")
public class JpaSidRepository extends JpaUtil {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;

	@Transactional
	public List<Sid> getAll() throws Exception {
		TypedQuery<Sid> query = manager.createNamedQuery(Sid.QUERY_ALL, Sid.class);
		return query.getResultList();
	}

	@Transactional
	public Sid getById(String id) throws Exception {
		return super.getById(id, Sid.class, manager);
	}

	@Transactional
	public Sid create(Sid sid) throws Exception {
		Sid ret = null;
		if (!StringUtils.isEmpty(sid.getId())) {
			ret = saveOrUpdate(null, manager, sid);
		}
		return ret;
	}

	@Transactional
	public void delete(Sid sid) throws Exception {
		if (!StringUtils.isEmpty(sid.getId())) {
			delete(manager, sid);
		}
	}
}
