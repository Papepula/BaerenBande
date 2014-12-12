package business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class CartDAO extends AbstractDAO{
	/*
	public List findByName(String userName){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");
		
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"SELECT c.userName FROM Cart AS c " +
				"WHERE c.userName = :userName");
		
		q.setParameter("userName", userName);
		
		return q.getResultList();
	}
	*/
}
