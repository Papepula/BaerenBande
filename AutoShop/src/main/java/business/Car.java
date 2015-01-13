package business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Car")
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
	private String image;
	private String image2;
	private String image3;
	

	public Car(){}
	
	public Car(/*int id,*/ String brand, String model, String state, int horsePower, String color, double price, String description, double rating, int numberRatings, String image, String image2, String image3){
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
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + horsePower;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((image2 == null) ? 0 : image2.hashCode());
		result = prime * result + ((image3 == null) ? 0 : image3.hashCode());
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (image2 == null) {
			if (other.image2 != null)
				return false;
		} else if (!image2.equals(other.image2))
			return false;
		if (image3 == null) {
			if (other.image3 != null)
				return false;
		} else if (!image3.equals(other.image3))
			return false;
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

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/


	


	
	
}
