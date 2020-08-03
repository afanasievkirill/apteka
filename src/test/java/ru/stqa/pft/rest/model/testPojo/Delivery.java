package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Delivery{

	@SerializedName("keycode")
	private String keycode;

	@SerializedName("address")
	private String address;

	@SerializedName("city")
	private String city;

	@SerializedName("coordinates")
	private Coordinates coordinates;

	@SerializedName("type")
	private String type;

	@SerializedName("house")
	private String house;

	@SerializedName("building")
	private String building;

	@SerializedName("courier_phone")
	private String courierPhone;

	@SerializedName("date_time")
	private String dateTime;

	@SerializedName("street")
	private String street;

	@SerializedName("fias")
	private String fias;

	@SerializedName("floor")
	private String floor;

	@SerializedName("entrance")
	private String entrance;

	@SerializedName("apartment")
	private String apartment;

	public void setKeycode(String keycode){
		this.keycode = keycode;
	}

	public String getKeycode(){
		return keycode;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCoordinates(Coordinates coordinates){
		this.coordinates = coordinates;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setHouse(String house){
		this.house = house;
	}

	public String getHouse(){
		return house;
	}

	public void setBuilding(String building){
		this.building = building;
	}

	public String getBuilding(){
		return building;
	}

	public void setCourierPhone(String courierPhone){
		this.courierPhone = courierPhone;
	}

	public String getCourierPhone(){
		return courierPhone;
	}

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setFias(String fias){
		this.fias = fias;
	}

	public String getFias(){
		return fias;
	}

	public void setFloor(String floor){
		this.floor = floor;
	}

	public String getFloor(){
		return floor;
	}

	public void setEntrance(String entrance){
		this.entrance = entrance;
	}

	public String getEntrance(){
		return entrance;
	}

	public void setApartment(String apartment){
		this.apartment = apartment;
	}

	public String getApartment(){
		return apartment;
	}

	@Override
 	public String toString(){
		return 
			"Delivery{" + 
			"keycode = '" + keycode + '\'' + 
			",address = '" + address + '\'' + 
			",city = '" + city + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",type = '" + type + '\'' + 
			",house = '" + house + '\'' + 
			",building = '" + building + '\'' + 
			",courier_phone = '" + courierPhone + '\'' + 
			",date_time = '" + dateTime + '\'' + 
			",street = '" + street + '\'' + 
			",fias = '" + fias + '\'' + 
			",floor = '" + floor + '\'' + 
			",entrance = '" + entrance + '\'' + 
			",apartment = '" + apartment + '\'' + 
			"}";
		}
}