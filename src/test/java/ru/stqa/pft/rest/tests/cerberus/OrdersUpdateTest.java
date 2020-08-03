package ru.stqa.pft.rest.tests.cerberus;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.tests.ApiTestBase;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class OrdersUpdateTest extends ApiTestBase {

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "http://s9/cerberus/hs/wms/orders/update";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("wms");
        authScheme.setPassword("rfrghfdfhrfr");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/json", Parser.JSON);
    }

    @Test
    public void getOrderTest() throws IOException {
        String jsonBody = api.rest().generateStringFromResource("src/test/resources/rest/orders/validOrder.json");
        given()
                .body(jsonBody)
                .when().post()
                .then().statusCode(200).log().all().extract().response();
    }

    @Test
    public void getOrderWithOneItemTest() throws IOException {
        String jsonBody = api.rest().generateStringFromResource("src/test/resources/rest/orders/order.json");
        given()
                .body(jsonBody)
                .when().post()
                .then().log().all().extract().response();
    }

    @Test
    public void getOrderGenerateJson() throws IOException {
        JSONObject jsonBody = new JSONObject();
        JSONObject put = new JSONObject();
        jsonBody.put("GUID", "aabc0f61-1138-11ea-ba83-20040febf06b");
        jsonBody.put("Статус", "Распределен");
        put.put("ID_77Номенклатура", "   X8A   ");
        put.put("GUIDНоменклатура", "8e96ac4e-19f3-4d3d-b018-6a2c260b261e");
        put.put("ID_77Партия", " 21LIHNG ");
        put.put("GUIDПартия", "7fe83a5f-0326-03c8-9f78-80c38c52b311");
        put.put("Количество", "1");
        put.put("КоличествоРаспределено", "1");
        put.put("Сообщение", "Ок");
        put.put("Статус", "Распределено");
        jsonBody.put("Товары", put);
        System.out.println(jsonBody);
        given().config(RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("UTF-8")))
                .body("["+jsonBody+"]")
                .when().post()
                .then().statusCode(200).log().all().extract().response();
    }
}
