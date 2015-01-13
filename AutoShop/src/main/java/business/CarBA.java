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
		
		return results;
		//return carTrackerBA.getCars(searchText);
		
	}
	
	public void updateRatingCar(Car car){
		carTrackerBA.updateRatingCar(car);
		carDAO.persist(car);
	}
}
