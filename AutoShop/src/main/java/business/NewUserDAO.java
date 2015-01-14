package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class NewUserDAO extends AbstractDAO {
	
	public NewUser registerUser(NewUser user){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");
		EntityManager em = emf.createEntityManager();
		
		String userEmail = user.getEmail();		
		
		Query q = em.createQuery("SELECT u FROM NewUser u WHERE u.email = :userEmail");
		
		q.setParameter("userEmail", userEmail);				

		try{
			NewUser userNew = (NewUser) q.getSingleResult();
			if (userEmail.equalsIgnoreCase(userNew.email)) {
				return new NewUser();
			}
		}catch(Exception e){  
			em.persist(user);
			return user;
		}
		
		return new NewUser();
	}
	

}
