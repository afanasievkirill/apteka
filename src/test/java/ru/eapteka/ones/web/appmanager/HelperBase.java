package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    //Клик по локатору на странице
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    //Ввод текстовой строки в поле страницы
    protected void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    //Ввод числа в поле страницы
    protected void typeInt(By locator, int i) {
        String text = Integer.toString(i);
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    //Получение значения элемента страницы. Необходим рефакторинг всего кода.
    public String getText(By link) {
        String text = wd.findElement(link).getText();
        return text;
    }

    //Сравнение заголовка страницы. Значение "sec-inner__title" общее для всего сайта
    public void headerCheck(String validValue) {
        String currentValue = getText(By.className("sec-inner__title"));
        Assert.assertEquals(validValue, currentValue);
    }

    //Сравнение строк
    public void equals(String first, String second) {
        Assert.assertEquals(first, second);
    }

    //Сравнение чисел
    public void equalsInt(int first, int second) {
        Assert.assertEquals(first, second);
    }

    //Пауза
    public void Pause(int timeout) throws InterruptedException {
        TimeUnit.SECONDS.sleep(timeout);
    }

    //Добавление товара в корзину
    public void inBaskett() throws InterruptedException {
        click(By.linkText("Купить"));
        Pause(1);
        click(By.linkText("1"));
        Pause(1);
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
