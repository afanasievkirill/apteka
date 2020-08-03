package ru.stqa.pft.rest.tests.stage;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CancelOrderTest extends StageTestBase {

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "http://192.168.85.73/apteka_autotest/hs/orders/cancelOrder";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("test_api");
        authScheme.setPassword("123456");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/json", Parser.JSON);
    }

    @Test
    public void cancelOrderTest() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("order_id", "ПД000000007");
        jsonBody.put("problem_id", "1");
        jsonBody.put("custom_problem","Отказ клиента");
        Response response = api.rest().post(jsonBody);
        response.then().log().all();
        String body = response.getBody().asString();
        System.out.println(body);

    }

}
