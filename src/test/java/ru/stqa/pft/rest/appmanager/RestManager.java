package ru.stqa.pft.rest.appmanager;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

public class RestManager {

    private WmsHelper wmsHelper;
    private CustomerHelper customerHelper;
    private SoapHelper soapHelper;
    private RestBase restBase;
    public String aut;
    public PharmacyHelper pharmacyHelper;

    public  RestManager(String aut){this.aut = aut;}

    public void init(){
        wmsHelper = new WmsHelper();
        customerHelper = new CustomerHelper();
        soapHelper = new SoapHelper();
        restBase = new RestBase();
        pharmacyHelper = new PharmacyHelper();
    }

    public WmsHelper wms() {
        return wmsHelper;
    }

    public CustomerHelper customer(){return customerHelper;}

    public SoapHelper soap(){return soapHelper;}

    public RestBase rest(){return  restBase;}

    public PharmacyHelper pharm(){return pharmacyHelper;}

}
