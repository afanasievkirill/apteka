package ru.stqa.pft.rest.tests.wms;


import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.LabelData;
import ru.stqa.pft.rest.tests.ApiTestBase;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PackagesInformationTest extends ApiTestBase {

    //валидатор для схему ответа https://www.jsonschema.net/

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "http://192.168.9.5/Sklad/hs/packages/information";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("iusr");
        authScheme.setPassword("123");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/json", Parser.JSON);
    }

    @DataProvider
    public Iterator<Object[]> validLabel() throws IOException {
        String json = getString("src/test/resources/rest/labels/validLabel.json");
        return getLabelData(json);
    }

    @Test(dataProvider = "validLabel")
    public void wmsPostWithData(LabelData labels) {
        JSONObject requestParams = api.wms().bodyData(labels);
        Response response = api.wms().post(requestParams);
        api.wms().verifyData(response, labels);
    }

    @Test(enabled = false)
    public void wmsPostTest() {
        Response response = given()
                .body("[{\"GUID\": \"e3a8caef-da10-11e9-b7fc-0cc47aabb8ac\",\"id_77\": \"\",\"cod\": \"\", \"codFull\": \"\"}]")
                .when()
                .post();
        System.out.println("POST Response\n" + response.asString());
    }

    @Test(enabled = false)
    public void wmsPostWithCod() {
        JSONObject requestParams = api.wms().bodyData(new LabelData().withCodFull("2608007289213"));
        Response response = api.wms().post(requestParams);
        api.wms().verify(response, "rest/labels/wmsValidcodFull.json");
    }

    @Test(enabled = false)
    public void wmsPostWithGuid() {
        JSONObject requestParams = api.wms().bodyData(new LabelData().withGuid("e3a8caef-da10-11e9-b7fc-0cc47aabb8ac"));
        Response response = api.wms().post(requestParams);
        api.wms().verify(response, "rest/labels/wmsValidGuid.json");
    }


    @Test
    public void wmsPostByFile() throws IOException {
        String jsonBody = api.rest().generateStringFromResource("src/test/resources/rest/labels/validLabel.json");
        given()
                .body(jsonBody)
                .when().post()
                .then().statusCode(200).log().all().extract().response();
    }

    @Test
    public void wmsPostWithGuiKamal() {
        RestAssured.defaultParser = Parser.JSON;
        JSONObject requestParams = api.wms().bodyData(new LabelData().withGuid("e3a8caef-da10-11e9-b7fc-0cc47aabb8ac"));
        Response response = api.wms().post(requestParams);
       // api.wms().verify(response, "rest/labels/wmsValidGuid.json");
       // response.then().body(withArgs("GUID"), response1 ->  equalTo("e3a8caef-da10-11e9-b7fc-0cc47aabb8ac"));
        String label = response.asString();
        assertThat(label, containsString("НомерДокумента\": \"80000058"));
        System.out.println(label);
    }

}
