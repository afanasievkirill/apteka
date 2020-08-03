package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Payments{

	@SerializedName("#text")
	private String text;

	@SerializedName("payment")
	private Payment payment;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setPayment(Payment payment){
		this.payment = payment;
	}

	public Payment getPayment(){
		return payment;
	}

	@Override
 	public String toString(){
		return 
			"Payments{" + 
			"#text = '" + text + '\'' + 
			",payment = '" + payment + '\'' + 
			"}";
		}
}