package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CarDAO extends AbstractDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");

	@PersistenceContext
	EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Car> findByName(String searchText){
		
		Query q = em.createQuery(
				"FROM Car AS c " +
				"WHERE UPPER(c.brand) LIKE :searchText");
		
		q.setParameter("searchText", "%" + searchText.toUpperCase() + "%");
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
	
	@SuppressWarnings("unchecked")
	public String updateRating(String id, String rating){
		Query numberRatings = em.createQuery(
				"From Car AS c WHERE c.id = :id"
				);
		numberRatings.setParameter("id", Integer.parseInt(id));
		
		Car c = (Car) numberRatings.getSingleResult();
		
		Double oldRating = c.getRating();
		Double newRating = ((oldRating * c.getNumberRatings()) + Double.parseDouble(rating)) / (c.getNumberRatings() + 1); 

		Query q = em.createQuery(
				"UPDATE Car SET numberRatings = :numberRatings, rating = :rating WHERE id = :id"
				);
				
		
		q.setParameter("id", Integer.parseInt(id));
		q.setParameter("numberRatings", c.getNumberRatings() + 1);
		q.setParameter("rating", newRating);
		
		q.executeUpdate();
		

		
	/*	
		EntityManager em2 = emf.createEntityManager();
		
		Query numberRatings = em.createQuery(
				"From Car AS c WHERE c.id = :id"
				);
		numberRatings.setParameter("id", Integer.parseInt(id));
		
		Car car = (Car) numberRatings.getSingleResult(); 
		
		Car car = em.find(Car.class, Integer.parseInt(id));
		Double oldRating = car.getRating();
		System.out.println(car.getNumberRatings());
		Double newRating = ((oldRating * car.getNumberRatings()) + Double.parseDouble(rating)) / (car.getNumberRatings() + 1); 
		
		
		//em.persist(car);
		car.setNumberRatings(car.getNumberRatings() + 1);
		car.setRating(newRating);
		em.merge(car);*/
		
		
		return newRating.toString();
		
	}
}
