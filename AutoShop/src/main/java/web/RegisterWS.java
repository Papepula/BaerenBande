package web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import business.NewUser;
import business.NewUserBS;



@Path("/register")
@Stateless
public class RegisterWS {

	@EJB
	NewUserBS NewUserBS;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public NewUser createUser(NewUser user){
				
		NewUser newUser = NewUserBS.createUser(user.getNachname(), user.getVorname(), user.getEmail(), 
				user.getStrasse(), user.getHausnummer(), user.getPlz(), user.getWohnort(), user.getPasswort());
		
		return newUser;

	}
	

	
}
