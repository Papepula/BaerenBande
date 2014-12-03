package web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import business.CartBS;
import business.CartItem;

@Path("/cart")
@Stateless
public class CartsWS {

	@EJB
	CartBS cartBS;
		
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void createCart(Carts carts){
		
		for(CartItem item : carts.cart){
			cartBS.createCart(item.getCart().getUserName(), item.getCart().getBrand(), item.getCart().getModel(), item.getAmount(), item.getCart().getPrice(), item.getCart().getDate());
		}

	}
}
