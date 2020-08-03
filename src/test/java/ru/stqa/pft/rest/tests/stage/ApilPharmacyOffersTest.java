package ru.stqa.pft.rest.tests.stage;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;

public class ApilPharmacyOffersTest extends StageTestBase {

    //Данные хранятся в РС ОстаткиПоАптекамДляОбменаССайтом. Заполнется регламентным заданием.
    //Для прохождения обмена в 1с должен быть заведен пользователь для обмена с правами: Запуск внешнего соединения, Полные права, Удаленный доступ.
    //Должно быть сопоставление в РС Настройки обмена с сайтом.
    //test_api 123456


    @BeforeClass (enabled = false)
    public void init() {
        RestAssured.baseURI = "http://" + url + "/apteka_autotest/hs/api1_0/pharmacyOffers";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("test_api");
        authScheme.setPassword("123456");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/xml", Parser.XML);
    }

    @Test
    public void getStatusCodeResponse() {
        RestAssured.given().get()
                .then().assertThat().statusCode(200).log().all();
    }

    @Test(enabled = false)
    public void getTestResponsenIvalidParol() {
        RestAssured.given().get("http://:123457@192.168.85.73/apteka_autotest/hs/api1_0/pharmacyOffers")
                .then().statusCode(401).log().all();
    }

    @Test
    public void getXmlWithElements() {
        RestAssured.given().get()
                .then().body(containsString("1000"))
                .body("full_data.stocks.stock.code", hasItems("3", "1"))
                .body(xmlPath + ".store_uuid", hasItem("1f173c2d-e676-11e8-9860-9822efbdbe9e"))
                .body("full_data.stocks.stock.price", hasItem("1000"))
                .body("full_data.stocks.stock.prime_cost", hasItem("500"))
                .body("full_data.stocks.stock.quantity", hasItem("5"))
                .body("full_data.stocks.stock.is_expire", hasItem("0"))
                .statusCode(200)
                .log().all();
    }

    @Test(enabled = false)
    public void getXmlById() {
        RestAssured.given().get()
                .then()
                .body(xmlPath + ".code" + xmlId, containsString("3"))
                .body(xmlPath + ".store_uuid" + xmlId, containsString("1f173c2d-e676-11e8-9860-9822efbdbe9e"))
                .body(xmlPath + ".price" + xmlId, containsString("1000"))
                .body(xmlPath + ".prime_cost" + xmlId, containsString("500"))
                .body(xmlPath + ".quantity" + xmlId, containsString("5"))
                .body(xmlPath + ".is_expire" + xmlId, containsString("0"))
                .statusCode(200)
                .log().all();
    }


}
