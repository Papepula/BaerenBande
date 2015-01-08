package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class CarDAO extends AbstractDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");
	
	EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Car> findByName(String searchText){
		
		Query q = em.createQuery(
				"FROM Car AS c " +
				"WHERE c.brand = :searchText");
		
		q.setParameter("searchText", searchText);
		List<Car> list = q.getResultList();
		//System.out.println("hoho");
		return q.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public Car findById(String id){
		
		Query q = em.createQuery(
				"From Car AS c " + 
				"WHERE c.id = :id");
		q.setParameter("id", Integer.parseInt(id) );
		Car c = (Car) q.getSingleResult();
		
		return c;
		
	}
}
