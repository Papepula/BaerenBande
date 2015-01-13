package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class LoginBS {
	
	@EJB
	private LoginBA loginBA;
	
	public NewUser login(NewUser user){
		return loginBA.login(user);
	}
}