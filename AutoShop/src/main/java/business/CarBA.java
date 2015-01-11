package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless
public class CarBA {

	@EJB
	private CarTrackerBA carTrackerBA;
	
	@EJB
	private CarDAO carDAO;
	
	public List <Car> getCars(String searchText){
		List<Car> results = new ArrayList<Car>();
		results = carDAO.findByName(searchText);
		for(Car car : results){
			System.out.println(car.getId());
		}
		return results;
		//return carTrackerBA.getCars(searchText);
		
	}
	
	public Car getCarById(String id){
		
		Car c = carDAO.findById(id);
		return c;
	}
	
	public String updateRatingCar(String id, String rating){
		return carDAO.updateRating(id, rating);
	}
}
