package ru.stqa.pft.rest.tests;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.PharmacyData;

import java.io.IOException;
import java.util.Iterator;

public class VersionAptekaTest extends ApiTestBase{

    @DataProvider
    public Iterator<Object[]> validPharmacy() throws IOException {
        String json = getString("src/test/resources/rest/pharmacy/validPharmacy.json");
        return getPharmacy(json);
    }

    @Test (dataProvider = "validPharmacy")
    public void getVersionTestData(PharmacyData pharm) {
        String number = "0.5.1.22";
        api.pharm().setUp(pharm);
        Response response = api.pharm().getResponse();
        api.pharm().verifyRespons(number, response);
        System.out.println(response.asString());
    }

    @Test
    public void getNegativeVersionTest() {
        String number = "0.5.1.12";
        api.pharm().setUpWithId("10.0.18.3/apteka18");
        Response response = api.pharm().getResponse();
        api.pharm().verifyInvalidRespons(number, response);
    }

}
