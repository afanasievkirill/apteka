package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Product{

	@SerializedName("promo")
	private Promo promo;

	@SerializedName("code")
	private String code;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("expiration_date")
	private String expirationDate;

	public void setPromo(Promo promo){
		this.promo = promo;
	}

	public Promo getPromo(){
		return promo;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setExpirationDate(String expirationDate){
		this.expirationDate = expirationDate;
	}

	public String getExpirationDate(){
		return expirationDate;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"promo = '" + promo + '\'' + 
			",code = '" + code + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",expiration_date = '" + expirationDate + '\'' + 
			"}";
		}
}