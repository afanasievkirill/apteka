package ru.stqa.pft.web.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.web.model.ItemData;

public class NomenclatureCardTest extends TestBase {

    public String medication = "Нурофен Экспресс, капсулы обезболивающие 200 мг, 16 шт.";
    public String medicationId = "id250763";

    @Test
    public void testProductOfTheDay() {
        app.goTo().productOfTheDay();
    }

    @Test
    public void testPickupAndDelivery() {
        app.goTo().findFullName(medication, medicationId);
        app.goTo().pickupAndDelivery();
    }

    @Test
    public void testBascettChange() throws InterruptedException {
        app.order().itemSearch(new ItemData("Физиотенз таблетки покрыт.плен.об. 0,4 мг, 28 шт."));
        app.goTo().garbageChange(3, "Ваша корзина пуста");
    }

    @Test
    public void testBascettButton() throws InterruptedException {
        app.order().itemSearch(new ItemData("Физиотенз таблетки покрыт.плен.об. 0,4 мг, 28 шт."));
        app.base().inBaskett();
        app.goTo().link("Моя корзина", By.xpath("//section[2]/a/span"));
    }
}
