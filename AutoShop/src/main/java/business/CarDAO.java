package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class CarDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<Car> findByName(String searchText){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");
		
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"FROM Car AS c " +
				"WHERE c.brand = :searchText");
		
		q.setParameter("searchText", searchText);
		
		return q.getResultList();
	}

}
