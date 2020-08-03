package ru.stqa.pft.rest.appmanager;

import io.restassured.response.Response;
import org.json.JSONObject;
import ru.stqa.pft.rest.model.LabelData;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class WmsHelper extends RestBase {

    public JSONObject body(String GUID, String ID_77, String COD, String CODFULL) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("GUID", GUID);
        requestParams.put("id_77", ID_77);
        requestParams.put("cod", COD);
        requestParams.put("codFull", CODFULL);
        return requestParams;
    }

    public JSONObject bodyData(LabelData labelData) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("GUID", labelData.getGuid());
        requestParams.put("id_77", labelData.getId_77());
        requestParams.put("cod", labelData.getCod());
        requestParams.put("codFull", labelData.getCodFull());
        return requestParams;
    }

    public void verify(Response response, String path) {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(path));
        String body = response.getBody().asString();
        System.out.println(body);
    }

    public void verifyData(Response response, LabelData labelData) {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(labelData.getVerifyPath())).assertThat().statusCode(200);
        String body = response.getBody().asString();
        System.out.println(body);
    }



}
