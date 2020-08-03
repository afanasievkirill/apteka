package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.web.model.ItemData;

public class CatalogTests extends TestBase {

    String item = "Физиотенз таблетки покрыт.плен.об. 0,4 мг, 28 шт.";

    @Test
    public void testRegionPriceChange() throws InterruptedException {
        app.order().itemSearch(new ItemData(item));
        int oldPrice = app.goTo().getPrice();
        app.goTo().regionSelection("'Санкт-Петербург'");
        int newPrice = app.goTo().getPrice();
        Assert.assertNotEquals(oldPrice, newPrice);
    }

    @Test
    public void testOpenFromBaskett () throws InterruptedException {
        app.order().itemSearch(new ItemData(item));
        app.base().inBaskett();
        app.goTo().fromCartToCard(item);
    }
}
