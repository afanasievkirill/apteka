package ru.stqa.pft.web.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) throws InterruptedException {
        wd.findElement(By.linkText("Вход")).click();
        wd.findElement(By.name("LOGIN")).clear();
        wd.findElement(By.name("LOGIN")).sendKeys(username);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Напомнить пароль'])[1]/following::div[1]"));
        type(By.name("PASSWORD"), password);
        wd.findElement(By.id("login_form_popup")).submit();
        TimeUnit.SECONDS.sleep(3);
    }


}
