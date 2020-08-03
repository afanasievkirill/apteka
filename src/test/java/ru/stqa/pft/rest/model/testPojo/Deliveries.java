package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Deliveries{

	@SerializedName("delivery")
	private Delivery delivery;

	@SerializedName("#text")
	private String text;

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
	}

	public Delivery getDelivery(){
		return delivery;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Deliveries{" + 
			"delivery = '" + delivery + '\'' + 
			",#text = '" + text + '\'' + 
			"}";
		}
}