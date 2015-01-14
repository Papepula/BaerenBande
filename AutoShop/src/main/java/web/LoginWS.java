package web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import business.LoginBS;
import business.NewUser;
import business.NewUserBS;

@Path("/login")
@Stateless
public class LoginWS {

	@EJB
	NewUserBS NewUserBS;
	
	@EJB
	LoginBS loginBS;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public NewUser loginUser(NewUser user){
				
		NewUser loggedInUser = loginBS.login(user);
		return loggedInUser;
	}
	

	
}
