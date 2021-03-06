package web;

import java.util.Date;

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


@Path("/cart")
@Stateless
public class CartsWS {

	@EJB
	CartBS cartBS;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCart(@Context HttpServletRequest request){
		
		String jsonString = getRequestBody(request);
		JSONArray json = new JSONArray(jsonString);
		Date date = new Date();
		String userName = getUserName(json.toString());

		// get json content and create cartBS
		for(int i = 0; i < json.length()-1; ++i){

			String str = json.get(i).toString();
			int amount = Integer.parseInt(getAmount(str));
			String brand = getBrand(str);
			String model = getModel(str);
			double price = Double.parseDouble(getPrice(str));
			
			cartBS.createCart(userName, brand, model, amount, price, date);
		}
		
		jsonString = null;
		json = null;
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
	
	private String getAmount(String str){

		String amount = null;
		String[] parts = str.split(":");
		amount = parts[1].substring(0,parts[1].length()-6);		
		return amount;
	}
	
	private String getBrand(String str){
		
		String brand = null;
		String[] parts = str.split(":");
		brand = parts[15].substring(1,parts[15].length()-3);
		return brand;
	}
	
	private String getModel(String str){
		
		String model = null;
		String[] parts = str.split(":");
		model = parts[12].substring(1,parts[12].length()-6);		
		return model;
	}
	
	private String getPrice(String str){
		
		String price = null;
		String[] parts = str.split(":");
		price = parts[11].substring(0,parts[11].length()-8);		
		return price;
	}
	
	private String getUserName(String str){
		
		String userName = null;
		String[] parts = str.split(":");
		int partUserName = parts.length - 1;
		userName = parts[partUserName].substring(1,parts[partUserName].length()-3);		
		return userName;
	}
}
