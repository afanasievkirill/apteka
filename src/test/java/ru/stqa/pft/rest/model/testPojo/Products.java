package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Products{

	@SerializedName("product")
	private Product product;

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	@Override
 	public String toString(){
		return 
			"Products{" + 
			"product = '" + product + '\'' + 
			"}";
		}
}