package web;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import business.Car;
import business.CarBS;

@Path("/car")
@Stateless
public class CarsWS {

	@EJB
	CarBS carBS;

	@GET
	@Path("search/{searchText}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cars getCars(@PathParam("searchText") String searchText){
		
		List<Car> foundCars = carBS.getCars(searchText);
		Cars cars = new Cars();
		cars.cars = foundCars;
		/*List<Car> cars = new ArrayList<Car>();
		cars = carBS.getCars("Peugeot");
		*/
		//return cars.get(0).getId();
		return cars;
	}
	
	@GET
	@Path("getCar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCar(@PathParam("id") String id){
		
		Car c = carBS.getCarById(id);
		return c;
	}
	
	@POST
	@Path("updateRating/{id}/{rating}")
	public String updateRating(@PathParam("id") String id, @PathParam("rating") String rating){

		String newRating = carBS.updateRatingCar(id, rating);
		return newRating;
	}

	
}