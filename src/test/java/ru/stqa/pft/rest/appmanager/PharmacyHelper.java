package ru.stqa.pft.rest.appmanager;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import ru.stqa.pft.rest.model.PharmacyData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class PharmacyHelper {

    public void setUp(PharmacyData pharm) {
        RestAssured.baseURI = "http://"+pharm.getIp()+"/hs/Order/version";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("SRV");
        authScheme.setPassword("4oWvzZHVv2Vx");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("text/plain", Parser.TEXT);
    }

    public void setUpWithId(String id) {
        RestAssured.baseURI = "http://"+id+"/hs/Order/version";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("SRV");
        authScheme.setPassword("4oWvzZHVv2Vx");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("text/plain", Parser.TEXT);
    }

    public Response getResponse() {
        return RestAssured.given().get().then().assertThat().statusCode(200).extract().response();
    }

    public void verifyRespons(String number, Response response) {
        String body = response.getBody().asString();
        assertThat(body, containsString(number));
    }

    public void verifyInvalidRespons(String number, Response response) {
        String body = response.getBody().asString();
        assertThat(body, not(containsString(number)));
    }




}
