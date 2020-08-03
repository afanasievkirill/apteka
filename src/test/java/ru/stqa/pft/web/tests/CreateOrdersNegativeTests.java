package ru.stqa.pft.web.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.web.model.ItemData;
import ru.stqa.pft.web.model.OrderData;

public class CreateOrdersNegativeTests extends TestBase {

    @Test
    public void testOldOrderCreatedRobot() throws Exception {
        int i = 0;
        while (i < 11) {
            app.order().itemSearch(new ItemData("Новиган, таблетки покрыт.плен.об. 20 шт."));
            app.order().itemBuyAndChekoutRobot(new OrderData().withDeliveryType("Забрать из аптеки"));
            app.goTo().home();
            i = i + 1;
        }
    }
}
