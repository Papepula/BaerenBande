package business;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NewUserBS {

	@EJB
	private NewUserBA userBA;
	
	public NewUser createUser(String nachname, String vorname, String email, String strasse, String hausnummer, String plz, String ort, String passwort){
		
		NewUser user = new NewUser(nachname, vorname, email, strasse, hausnummer, plz, ort, passwort);		
		return userBA.createUser(user);
		
	}
	
}
