package business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAO {

	@PersistenceContext(unitName="autoshop")
	private EntityManager em;
	
	public void persist(Object entity){
		em.persist(entity);
	}
}