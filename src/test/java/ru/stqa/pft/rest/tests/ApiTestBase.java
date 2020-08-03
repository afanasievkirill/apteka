package ru.stqa.pft.rest.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.rest.appmanager.RestManager;
import ru.stqa.pft.rest.model.LabelData;
import ru.stqa.pft.rest.model.PharmacyData;
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

public class ApiTestBase  {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public final RestManager api = new RestManager("Premetive");

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        api.init();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }

    protected Iterator<Object[]> getLabelData(String json) {
        Gson gson = new Gson();
        List<LabelData> pages = gson.fromJson(json, new TypeToken<List<LabelData>>(){}.getType());
        return pages.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    protected Iterator<Object[]> getPharmacy(String json) {
        Gson gson = new Gson();
        List<PharmacyData> pages = gson.fromJson(json, new TypeToken<List<PharmacyData>>(){}.getType());
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
