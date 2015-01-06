package business;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car extends AbstractEntity{

	//private int id;
	private String brand;
	private String model;
	private String state;
	private int horsePower;
	private String color;
	private double price;
	private String description;
	private double rating;
	private int numberRatings;
	

	public Car(){}
	
	public Car(/*int id,*/ String brand, String model, String state, int horsePower, String color, double price, String description, double rating, int numberRatings){
		//this.id = id;
		this.brand = brand;
		this.model = model;
		this.state = state;
		this.horsePower = horsePower;
		this.color = color;
		this.price = price;
		this.description = description;
		this.rating = rating;
		this.numberRatings = numberRatings;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNumberRatings() {
		return numberRatings;
	}

	public void setNumberRatings(int numberRatings) {
		this.numberRatings = numberRatings;
	}

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + horsePower;
	/*	result = prime * result + id;*/
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + numberRatings;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (horsePower != other.horsePower)
			return false;
	/*	if (id != other.id)
			return false;*/
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numberRatings != other.numberRatings)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(rating) != Double
				.doubleToLongBits(other.rating))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	


	
	
}
