package ru.eapteka.ones.web.tests;

import org.testng.annotations.Test;
import ru.eapteka.ones.web.model.ItemData;
import ru.eapteka.ones.web.model.OrderData;

public class CreateOrdersTests extends TestBase {

    @Test
    public void testNewOrderCreated() throws Exception {
        app.goTo().regionSelection("'Санкт-Петербург'");
        app.order().itemSearch(new ItemData("Адвокат капли на холку для кошек массой до 4 кг 0.4 мл пипетки 3 шт. Байер"));
        app.order().itemBuyAndChekout(new OrderData().withDeliveryType("Забрать из аптеки"));
        String testOrder = app.order().findId();
        app.generator().writter("Тверь", testOrder);
    }

    @Test
    public void testOldOrderCreated() throws Exception {
        OrderData orderData = new OrderData().withDeliveryType("Забрать из аптеки")
                .withItem("Афобазол, таблетки 10 мг, 60 шт.").withNameFile("МоскваСамовывоз");
        app.order().itemSearchOrder(orderData);
        app.order().itemBuyAndChekoutRobot(orderData);
        app.goTo().home();
        orderData.withOrderId(app.order().findId());
        app.generator().writterOrder(orderData);
    }

    @Test
    public void testOldOrderCreatedStock() throws Exception {
        app.order().itemSearch(new ItemData("Адвокат капли на холку для кошек массой до 4 кг 0.4 мл пипетки 3 шт. Байер"));
        app.order().itemBuyAndChekoutRobot(new OrderData().withDeliveryType("Забрать из аптеки"));
        app.goTo().home();
        String testOrder = app.order().findId();
        app.generator().writter("СборкаНаСкладе", testOrder);
    }

}

//5 дней Крем для ног от пота и запаха 35г
//Афобазол, таблетки 10 мг, 60 шт.
//Адвокат капли на холку для кошек массой до 4 кг 0.4 мл пипетки 3 шт. Байер   Всегда под заказ
//Физиотенз таблетки покрыт.плен.об. 0,4 мг, 28 шт.   Всегда есть на остатках
