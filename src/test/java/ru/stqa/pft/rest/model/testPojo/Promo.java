package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Promo{

	@SerializedName("amount")
	private String amount;

	@SerializedName("name")
	private String name;

	@SerializedName("promocode")
	private String promocode;

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPromocode(String promocode){
		this.promocode = promocode;
	}

	public String getPromocode(){
		return promocode;
	}

	@Override
 	public String toString(){
		return 
			"Promo{" + 
			"amount = '" + amount + '\'' + 
			",name = '" + name + '\'' + 
			",promocode = '" + promocode + '\'' + 
			"}";
		}
}