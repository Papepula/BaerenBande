package business;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

	
	private int id;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
}