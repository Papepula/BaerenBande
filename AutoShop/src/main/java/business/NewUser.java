package business;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="NewUser")
@XmlRootElement
public class NewUser extends AbstractEntity {
	
	public String nachname;
	public String vorname;
	public String email;
	public String strasse;
	public String hausnummer;
	public String plz;
	public String wohnort;
	public String passwort;
	
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	
	
	
	public NewUser(){
		
	}
	
	public NewUser(String nachname, String vorname, String email, String strasse, 
			String hausnummer, String plz, String wohnort, String passwort) {
		
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.wohnort = wohnort;
		this.passwort = passwort;
	}
}