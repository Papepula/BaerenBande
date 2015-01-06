package web;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import business.Car;
import business.CarBS;

@Path("/car")
@Stateless
public class CarsWS {

	@EJB
	CarBS carBS;

	@GET
	@Produces("application/json")
	public int getCars(){
		
		List<Car> cars = new ArrayList<Car>();
		cars = carBS.getCars("Peugeot");
		
		return cars.get(0).getId();
	}
}