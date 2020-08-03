package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("orders")
	private Orders orders;

	public void setOrders(Orders orders){
		this.orders = orders;
	}

	public Orders getOrders(){
		return orders;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"orders = '" + orders + '\'' + 
			"}";
		}
}