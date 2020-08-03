package ru.stqa.pft.web.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.web.model.PageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validPage() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/pages.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<PageData> pages = gson.fromJson(json, new TypeToken<List<PageData>>(){}.getType());
        return pages.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test
    public void testProductGroups () throws Exception{
        app.goTo().productGroups("Глаза", "Средства для лечения глаз");
        app.goTo().home();
    }

    @Test (dataProvider = "validPage")
    public void testStockDataProvider (PageData pages) throws Exception {
        app.goTo().linkData(pages);
        app.goTo().home();
    }

    @Test
    public void testStock () throws Exception {
        app.goTo().link("Скидки и акции в аптеке", By.className("promo--all"));
        app.goTo().home();
    }

    @Test
    public void testArticle () throws Exception {
        app.goTo().link("Статьи", By.className("articles--all"));
        app.goTo().home();
    }

    @Test
    public void testReviews() throws Exception {
        app.goTo().link("Отзывы о работе интернет-аптеки", By.className("reviews--all visible-xs4"));
        app.goTo().home();
    }

    @Test
    public void testJob() throws Exception {
        app.goTo().link("Вакансии интернет-аптеки eApteka", By.linkText("Вакансии"));
        app.goTo().home();
    }

    @Test
    public void testPartner() throws Exception {
        app.goTo().link("Наши партнеры", By.className("our-partners--all"));
        app.goTo().home();
    }

    @Test
    public void testPickup()throws Exception {
        app.goTo().link("Бесплатный самовывоз из аптек", By.xpath("(//a[contains(text(),'Самовывоз из аптек')])[2]"));
    }

    @Test
    public void testDelivery()throws Exception {
        app.goTo().link("Доставка лекарств", By.xpath("(//a[contains(text(),'Доставка')])[2]"));
    }

    @Test
    public void testSubscription() throws Exception{
        app.goTo().subscribe("k.afanasev@eapteka.ru");
        app.goTo().home();
    }

    @Test
    public void testFacebook () throws Exception{
        app.goTo().socialNetwork("https://www.facebook.com/eApteka.ru/", By.cssSelector("i.fa.fa-facebook"));
    }

    @Test
    public void testVk () throws Exception{
        app.goTo().socialNetwork("https://vk.com/doctoreapetkin", By.cssSelector("i.fa.fa-vk"));
    }

    @Test
    public void testFranchise () throws Exception {
        app.goTo().socialNetwork("https://franchise.eapteka.ru/" , By.xpath("(//a[contains(text(),'Франшиза')])[2]"));
    }

    @Test void testBanner () throws Exception {
        app.goTo().socialNetwork("https://app.eapteka.ru/", By.xpath("//section/div/a/img"));
    }
}
