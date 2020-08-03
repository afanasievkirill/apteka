package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Order{

	@SerializedName("status_date_time")
	private String statusDateTime;

	@SerializedName("code")
	private String code;

	@SerializedName("status_id")
	private String statusId;

	@SerializedName("date_time")
	private String dateTime;

	@SerializedName("city")
	private String city;

	@SerializedName("price")
	private String price;

	@SerializedName("payments")
	private Payments payments;

	@SerializedName("comment")
	private String comment;

	@SerializedName("customer")
	private Customer customer;

	@SerializedName("deliveries")
	private Deliveries deliveries;

	@SerializedName("products")
	private Products products;

	public void setStatusDateTime(String statusDateTime){
		this.statusDateTime = statusDateTime;
	}

	public String getStatusDateTime(){
		return statusDateTime;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setStatusId(String statusId){
		this.statusId = statusId;
	}

	public String getStatusId(){
		return statusId;
	}

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setPayments(Payments payments){
		this.payments = payments;
	}

	public Payments getPayments(){
		return payments;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public Customer getCustomer(){
		return customer;
	}

	public void setDeliveries(Deliveries deliveries){
		this.deliveries = deliveries;
	}

	public Deliveries getDeliveries(){
		return deliveries;
	}

	public void setProducts(Products products){
		this.products = products;
	}

	public Products getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"Order{" + 
			"status_date_time = '" + statusDateTime + '\'' + 
			",code = '" + code + '\'' + 
			",status_id = '" + statusId + '\'' + 
			",date_time = '" + dateTime + '\'' + 
			",city = '" + city + '\'' + 
			",price = '" + price + '\'' + 
			",payments = '" + payments + '\'' + 
			",comment = '" + comment + '\'' + 
			",customer = '" + customer + '\'' + 
			",deliveries = '" + deliveries + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}