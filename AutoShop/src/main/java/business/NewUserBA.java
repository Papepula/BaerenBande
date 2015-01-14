package business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NewUserBA {
	
	@EJB
	private NewUserDAO newUserDao;
	
	public NewUser createUser(NewUser user){
		
		return newUserDao.registerUser(user);
	}
	
}
