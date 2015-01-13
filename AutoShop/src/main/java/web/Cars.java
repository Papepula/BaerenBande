package web;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import business.Car;

@XmlRootElement
public class Cars {

	@XmlElement
	public List<Car> cars;
}
