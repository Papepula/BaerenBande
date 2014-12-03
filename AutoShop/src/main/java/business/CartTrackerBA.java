package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class CartTrackerBA {

	private List <Cart> carts;
	
	public CartTrackerBA(){
		carts = new ArrayList <Cart> ();
	}
	
	public void addCart(Cart cart){
		if(equalCartExists(cart)){
			throw new IllegalStateException("Cart already exists in session");
		}
		carts.add(cart);
	}
	
	public int getNumberOfItemsInCart(){
		int numberOfItems = 0;
		
		for(Cart c : carts){
			numberOfItems += c.getAmount();
		}
		
		return numberOfItems;
	}
	
	public boolean equalCartExists(Cart cart){
		return carts.contains(cart);
	}
	
	public List<Cart> getAllCarts(){
		return new ArrayList<Cart>(carts);
	}
	
	public List<Cart> getCarts(String userName){
		
		List <Cart> result = new ArrayList <Cart> ();
		
		for(Cart c : carts){
			if(c.getUserName().equals(userName)){
				result.add(c);
			}
		}
		
		return result;
	}
}
