package it.protectid.repository;

import it.protectid.model.policy.Ppm;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author clod16
 */
@Repository("jpaPpmRepository")
public class JpaPpmRepository extends JpaUtil {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;

	@Transactional
	public List<Ppm> getAll() throws Exception {
		TypedQuery<Ppm> query = manager.createNamedQuery(Ppm.QUERY_ALL, Ppm.class); //FIXME
		return query.getResultList();
	}

	@Transactional
	public List<Ppm> getByDp(String dp) throws Exception {
		TypedQuery<Ppm> query = manager.createNamedQuery(dp, Ppm.class);
		query.setParameter(Ppm.PARAM_DP, dp);
		return query.getResultList();
	}

	@Transactional
	public Ppm getById(String id) throws Exception {
		return super.getById(id, Ppm.class, manager);
	}

	@Transactional
	public Ppm create(Ppm ppm) throws Exception {
		Ppm ret = null;
		if (!StringUtils.isEmpty(ppm.getId())) {
			ret = saveOrUpdate(null, manager, ppm);
		}
		return ret;
	}

	@Transactional
	public void delete(Ppm ppm) throws Exception {
		if (!StringUtils.isEmpty(ppm.getId())) {
			delete(manager, ppm);
		}
	}

}
