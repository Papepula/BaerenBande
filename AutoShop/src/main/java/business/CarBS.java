package business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarBS {
	@EJB
	private CarBA carBA;
	
	public List<Car> getCars(String searchText){
		return carBA.getCars(searchText);
	}
	
	public Car getCarById(String id){
		return carBA.getCarById(id);
	}
	
	public void updateRatingCar(Car car){
		carBA.updateRatingCar(car);
	}
}
