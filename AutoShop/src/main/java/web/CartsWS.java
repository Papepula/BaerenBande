package web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCart(@Context HttpServletRequest request){
		String jsonString = getRequestBody(request);
		
		JSONArray json = new JSONArray(jsonString);
		
		for(int i = 0; i < json.length(); ++i){
			System.out.println(json.get(i));
		}
	}
	
	private String getRequestBody(HttpServletRequest request){
		try{
		ServletInputStream in = request.getInputStream();
		byte[] buffer = new byte[100 * 1024];
		
		int bytesRead = in.read(buffer);
		return new String(buffer, 0, bytesRead, "utf-8");
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
