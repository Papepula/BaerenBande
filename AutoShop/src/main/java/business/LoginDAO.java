package business;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Stateless
public class LoginDAO extends AbstractDAO {
	
	public NewUser login(NewUser user){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoshop");
		EntityManager em = emf.createEntityManager();
		
		String userEmail = user.getEmail();
		String userPassword = user.getPasswort();		
		
		Query q = em.createQuery("SELECT u FROM NewUser u WHERE u.email = :userEmail AND u.passwort = :userPasswort");
		
		q.setParameter("userEmail", userEmail);
		q.setParameter("userPasswort", userPassword);
				

		try{
			NewUser userNew = (NewUser) q.getSingleResult();
			if (userEmail.equalsIgnoreCase(userNew.email)&&userPassword.equals(userNew.passwort)) {
				return userNew;
			}
		}catch(Exception e){      
			return new NewUser();
		}
		
		return new NewUser();

	}
	
}