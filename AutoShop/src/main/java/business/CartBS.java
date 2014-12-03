package business;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CartBS {

	@EJB
	private CartBA cartBA;
	
	public Cart createCart(String userName, String brand, String model, int amount, double price, Date date){
		
		Cart cart = new Cart(userName, brand, model, amount, price, date);		
		cartBA.createCart(cart);
		
		return cart;
	}
	
	public List <Cart> getCarts(String userName){
		return cartBA.getCarts(userName);
	}
}
