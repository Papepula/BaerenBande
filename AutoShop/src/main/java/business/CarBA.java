package business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class CarBA {

	@EJB
	private CarTrackerBA carTrackerBA;
	
	public List <Car> getCars(String searchText){
		return carTrackerBA.getCars(searchText);
	}
}
