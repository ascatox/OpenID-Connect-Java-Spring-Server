package org.mitre.protectid.repository;

import org.mitre.protectid.model.policy.Ppa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author ascatox
 */
@Repository("jpaSidRepository")
public class JpaSidRepository {

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager manager;


	@Transactional
	public List<Ppa> getAll() throws Exception {
		TypedQuery<Ppa> query = manager.createNamedQuery(Ppa.QUERY_ALL, Ppa.class);
		return query.getResultList();
	}
}
