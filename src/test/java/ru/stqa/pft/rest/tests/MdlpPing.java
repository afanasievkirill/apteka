package ru.stqa.pft.rest.tests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Scanner;

public class MdlpPing {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://192.168.85.73/mdlp_dev1/hs";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("iusr");
        authScheme.setPassword("123");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/xml", Parser.XML);
    }

    @Test
    public void getStatusCodeQrCodePing() {
        RestAssured.given().get("/qr_code/ping")
                .then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void getStatusCodeResponse() {
        RestAssured.given().get("/test/ping")
                .then().assertThat().statusCode(200).log().all();
        Scanner scanner = new Scanner(System.in);

    }
}
