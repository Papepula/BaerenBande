package web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class AutoshopApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		classes.add(CartsWS.class);
		classes.add(CarsWS.class);
		classes.add(LoginWS.class);
		classes.add(RegisterWS.class);
		return classes;
	}

}
