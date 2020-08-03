package ru.eapteka.ones.web.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    private String browser;

    private OrderHelper orderHelper;
    private SessionHelper sessionHelper;
    private OrderDataGenerator generator;
    private NavigationHelper navigationHelper;
    private HelperBase base;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://www.eapteka.ru/#auth");
        orderHelper = new OrderHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        generator = new OrderDataGenerator();
        base = new HelperBase(wd);
        sessionHelper.login("k.afanaciev@eapteka.ru", "5985104");
    }

    public void stop() {
        //wd.findElement(By.linkText("Выход")).click();
        wd.quit();
    }

    public OrderHelper order() {
        return orderHelper;
    }

    public OrderDataGenerator generator() {return generator;}
    
    public NavigationHelper goTo() {return navigationHelper;}

    public HelperBase base(){return base;}
}
