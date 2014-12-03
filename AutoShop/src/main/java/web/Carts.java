package web;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import business.CartItem;

@XmlRootElement
public class Carts {

	@XmlElement
	public List<CartItem> cart;
}
