package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class LoginBA {
	
	@EJB
	private LoginDAO loginDAO;
	
	public NewUser login(NewUser user){
		return loginDAO.login(user);
	}
	
}