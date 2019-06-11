package it.protectid.pdw.repository;

import it.protectid.pdw.model.Pdw;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;

/**
 * @author ascatox
 */
@Repository("jpaPdwRepository")
@NamedQueries({
	@NamedQuery(name = Pdw.QUERY_ALL, query = "select p from Pdw p"),
	@NamedQuery(name = Pdw.QUERY_BY_ID, query = "select p from Pdw p where p.id = :" + Pdw.PARAM_ID),
})
public class JpaPdwRepository extends JpaUtil {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;


	@Transactional
	public List<Pdw> getAll() {
		TypedQuery<Pdw> query = manager.createNamedQuery(Pdw.QUERY_ALL, Pdw.class);
		return query.getResultList();
	}

	@Transactional
	public Pdw getPdwById() {
		TypedQuery<Pdw> query = manager.createNamedQuery(Pdw.QUERY_BY_ID, Pdw.class);
		return query.getResultList().get(0);
	}


	@Transactional
	public Pdw create(Pdw pdw) {
		Pdw ret = null;
		if (!StringUtils.isEmpty(pdw.getId())) {
			ret = saveOrUpdate(null, manager, pdw);
		}
		return ret;
	}


	@Transactional
	public void delete(Pdw pdw) {
		if (!StringUtils.isEmpty(pdw.getId())) {
			delete(manager, pdw);
		}
	}
}
