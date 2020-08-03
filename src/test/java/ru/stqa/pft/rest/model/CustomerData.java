package ru.stqa.pft.rest.model;

import java.util.Objects;

public class CustomerData {


    //Данные клиента
    public String name;
    public String phone;
    public String lon;
    public String lat;
    public String adress;
    public String city;
    public String street;
    public String house;
    public String appartment;
    public String floor;
    public String building;
    public String entrance;
    public String keycode;

    public String getIsCompany() {
        return isCompany;
    }

    public String getIsStateCompany() {
        return isStateCompany;
    }

    public CustomerData withIsCompany(String isCompany) {
        this.isCompany = isCompany;
        return this;
    }



    public CustomerData withIsStateCompany(String isStateCompany) {
        this.isStateCompany = isStateCompany;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public String getOKPO() {
        return OKPO;
    }

    public void setOKPO(String OKPO) {
        this.OKPO = OKPO;
    }

    //Данные Юрлица
    public String isCompany;
    public String isStateCompany;
    public String fullName;
    public String registrationAddress;
    public String postalAddress;
    public String phoneNumbers;
    public String OGRN;
    public String OKPO;




    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getAppartment() {
        return appartment;
    }

    public String getFloor() {
        return floor;
    }

    public String getBuilding() {
        return building;
    }

    public String getEntrance() {
        return entrance;
    }

    public String getKeycode() {
        return keycode;
    }

    public CustomerData withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerData withLon(String lon) {
        this.lon = lon;
        return this;
    }

    public CustomerData setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public CustomerData withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public CustomerData withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerData withStreet(String street) {
        this.street = street;
        return this;
    }

    public CustomerData withHouse(String house) {
        this.house = house;
        return this;
    }

    public CustomerData withAppartment(String appartment) {
        this.appartment = appartment;
        return this;
    }

    public CustomerData withFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public CustomerData withBuilding(String building) {
        this.building = building;
        return this;
    }

    public CustomerData withEntrance(String entrance) {
        this.entrance = entrance;
        return this;
    }

    public CustomerData withKeycode(String keycode) {
        this.keycode = keycode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerData)) return false;
        CustomerData that = (CustomerData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(lon, that.lon) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(house, that.house) &&
                Objects.equals(appartment, that.appartment) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(building, that.building) &&
                Objects.equals(entrance, that.entrance) &&
                Objects.equals(keycode, that.keycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, lon, lat, adress, city, street, house, appartment, floor, building, entrance, keycode);
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", appartment='" + appartment + '\'' +
                ", floor='" + floor + '\'' +
                ", building='" + building + '\'' +
                ", entrance='" + entrance + '\'' +
                ", keycode='" + keycode + '\'' +
                '}';
    }
}
