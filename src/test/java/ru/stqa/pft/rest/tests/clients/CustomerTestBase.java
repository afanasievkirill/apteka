package ru.stqa.pft.rest.tests.clients;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.rest.appmanager.RestManager;
import ru.stqa.pft.rest.model.CustomerData;
import ru.stqa.pft.web.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerTestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public final RestManager api = new RestManager("Premetive");

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        api.init();
        RestAssured.baseURI = "http://192.168.85.73/Clients/hs/clients";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("iusr");
        authScheme.setPassword("LvPY5985104");
        RestAssured.authentication = authScheme;
        RestAssured.registerParser("application/xml; charset=utf-8", Parser.XML);
    }


    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }

    protected Iterator<Object[]> getCustomerData(String json) {
        Gson gson = new Gson();
        List<CustomerData> pages = gson.fromJson(json, new TypeToken<List<CustomerData>>(){}.getType());
        return pages.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    protected String getString(String pathname) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        return json;
    }
}
