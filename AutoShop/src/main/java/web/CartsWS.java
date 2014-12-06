package web;

import java.util.ArrayList;
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

import business.Cart;
import business.CartBS;
import business.CartItem;

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
		System.out.println("USERNAME: " + userName);
		
		System.out.println("Request String: " + json.toString());
		
		int counter = 0;
		String[] parts =  json.toString().split(":");
		for(String s : parts){
		System.out.println(counter + "Part: " +s.toString());
		counter++;
		}
		
		
		for(int i = 0; i < json.length()-1; ++i){

			String str = json.get(i).toString();
			
			int amount = Integer.parseInt(getAmount(str));
			String brand = getBrand(str);
			String model = getModel(str);
			double price = Double.parseDouble(getPrice(str));
					
			System.out.println("Anzahl: " + amount);
			System.out.println("Automarke: " + brand);
			System.out.println("Modell: " + model);
			System.out.println("Preis: " + price);
			
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
		brand = parts[8].substring(1,parts[8].length()-3);	
		return brand;
	}
	
	private String getModel(String str){
		
		String model = null;
		String[] parts = str.split(":");
		model = parts[5].substring(1,parts[5].length()-6);		
		return model;
	}
	
	private String getPrice(String str){
		
		String price = null;
		String[] parts = str.split(":");
		price = parts[4].substring(1,parts[4].length()-9);		
		return price;
	}
	

	private String getUserName(String str){
		
		String userName = null;
		String[] parts = str.split(":");
		int partUserName = parts.length - 1;
		
		int counter = 0;
		System.out.println("GETUSERNAME");

		for(String s : parts){
			System.out.println(counter + "Part: " +s.toString());
			counter++;
		}
		
		userName = parts[partUserName].substring(1,parts[partUserName].length()-3);		
		return userName;
	}
}
