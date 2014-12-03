package business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CartBA {

	@EJB
	private CartTrackerBA cartTrackerBA;
	
	public void createCart(Cart cart){
		
		if(cartTrackerBA.equalCartExists(cart) == false){
			cartTrackerBA.addCart(cart);
		}
	}
	
	public List <Cart> getCarts(String userName){
		return cartTrackerBA.getCarts(userName);
	}
}
