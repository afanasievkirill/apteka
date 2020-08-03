package ru.stqa.pft.rest;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JiraTest {


    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://testbase.atlassian.net/rest/api/3";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("mail.for.testbase@yandex.ru");
        authScheme.setPassword("udIWBzwjeiKzT2JaCf4LEAB7");
        RestAssured.authentication = authScheme;
       // RestAssured.registerParser("application/xml", Parser.XML);
    }

    @Test
    public void getAttachmentTest(){
        RestAssured.given().get("/attachment/19898")
                .then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void getIssueTest(){
        RestAssured.given().get("/issue/TEST-3429")
                .then().assertThat().statusCode(200).log().all();
    }

}
