package ru.stqa.pft.rest.tests.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.rest.appmanager.RestManager;
import ru.stqa.pft.web.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class StageTestBase {

    public String xmlPath = "full_data.stocks.stock";
    public String xmlId = "[1]";
    public String url = "192.168.85.73";
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
