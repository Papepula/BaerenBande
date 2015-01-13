package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class CarTrackerBA {
	private List<Car> cars;

	public CarTrackerBA() {
		cars = new ArrayList<Car>();
	}

	public List<Car> getAllCars() {
		return new ArrayList<Car>(cars);
	}

	public List<Car> getCars(String searchText) {

		List<Car> result = new ArrayList<Car>();

		for (Car c : cars) {
			if (c.getBrand().toLowerCase().equals(searchText.toLowerCase()) 
			 || c.getModel().toLowerCase().equals(searchText.toLowerCase())) {
				result.add(c);
			}
		}

		return result;
	}
	
	public Car getCar(int id){
		
		for(Car c : cars) {
			if(c.getId() == id){
				return c;
			}	
		}
		
		return null;
	}
	
	public void updateRatingCar (Car car){
		
		double updatedRating;
		
		for (Car c : cars) {
			if(c.getId() == car.getId()){
				updatedRating = ((c.getRating() * c.getNumberRatings()) + car.getRating()) / (c.getNumberRatings() + 1); 
				c.setRating(updatedRating);
				c.setNumberRatings(c.getNumberRatings() + 1);
			}
		}
	}
}