package ru.stqa.pft.rest.appmanager;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RestBase {

    public String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public Response post(JSONObject requestParams) {
        return given()
                .body("["+requestParams+"]")
                .when()
                .post();
    }
}
