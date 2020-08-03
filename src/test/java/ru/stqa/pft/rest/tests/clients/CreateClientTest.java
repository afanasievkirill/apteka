package ru.stqa.pft.rest.tests.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.CustomerData;

import java.io.IOException;
import java.util.Iterator;

import static io.restassured.RestAssured.given;

public class CreateClientTest extends CustomerTestBase {


    @DataProvider
    public Iterator<Object[]> invalidCustomerData() throws IOException {
        String json = getString("src/test/resources/rest/clients/invalidCustomer.json");
        return getCustomerData(json);
    }

    @Test
    public void customersGet() {
        RestAssured.given().get("/search?phone=+79153913432")
                .then().assertThat().statusCode(200).log().all();
    }

    //ONE-5884
    @Test
    public void validCustomerTest() throws IOException {
        String xmlBody = api.rest().generateStringFromResource("src/test/resources/rest/clients/validClient.xml");
        Response response = null;
        response = given()
                .body(xmlBody)
                .when()
                .post("/CreateClient");
        response.then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void validIndividualCustomerTest() {
        String requestBody = api.customer().create();
        Response response = null;
        response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/CreateClient");
        response.then()
                .log().all();
    }

    @Test
    public void validEntytyCustomerTest() {
        String requestBody = api.customer().create();
        Response response = null;
        response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/CreateClient");
        response.then()
                .log().all();
    }

    @Test(dataProvider = "invalidCustomerData", enabled = false)
    public void invalidCustomerTestWithData(CustomerData customers) {
        String requestBody = api.customer().contactsWithData(customers);
        Response response = null;
        response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/CreateClient");
        response.then()
                .statusCode(500)
                .log().all();
    }

}
