package ru.stqa.pft.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindOrderTests extends TestBase {


    @Test
    public void testFindNewOrder() throws Exception {
        String expectedStatus = "Принят";
        String orderId = app.generator().readerId("Тверь");
        String orderStatus = app.order().findOrder(orderId);
        Assert.assertEquals(expectedStatus, orderStatus);
        expectedStatus = "Отменён";
        orderStatus = app.order().cancelOrder();
        Assert.assertEquals(expectedStatus, orderStatus);
    }

    @Test
    public void testFindOldOrder() throws Exception {
        String expectedStatus = "Принят";
        String orderId = app.generator().readerId("МоскваСамовывоз");
        String orderStatus = app.order().findOrder(orderId);
        Assert.assertEquals(expectedStatus, orderStatus);
        expectedStatus = "Отменён";
        orderStatus = app.order().cancelOrder();
        Assert.assertEquals(expectedStatus, orderStatus);
    }

    @Test
    public void testFindOldOrderStock() throws Exception {
        String expectedStatus = "Принят";
        String orderId = app.generator().readerId("СборкаНаСкладе");
        String orderStatus = app.order().findOrder(orderId);
        Assert.assertEquals(expectedStatus, orderStatus);
        expectedStatus = "Отменён";
        orderStatus = app.order().cancelOrder();
        Assert.assertEquals(expectedStatus, orderStatus);
    }

}
