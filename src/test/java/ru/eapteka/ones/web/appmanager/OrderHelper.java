package ru.eapteka.ones.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.eapteka.ones.web.model.ItemData;
import ru.eapteka.ones.web.model.OrderData;

public class OrderHelper extends HelperBase {


    public OrderHelper(WebDriver wd) {
        super(wd);
    }

    //Оформление самовывоза в корзине
    public void itemBuyAndChekoutRobot(OrderData order) throws InterruptedException {
        inBaskett();
        click(By.linkText("Оформить заказ"));
        Pause(1);
        click(By.linkText(order.getDeliveryType()));
        Pause(5);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='EAPTEKA.RU'])[19]/following::a[1]"));
        Pause(3);
        click(By.name("submit"));
        Pause(1);
    }

    //оформление самомвывоза
    public void itemBuyAndChekout(OrderData order) throws InterruptedException {
        inBaskett();
        click(By.linkText("Оформить заказ"));
        click(By.linkText(order.getDeliveryType()));
        Pause(2);
        click(By.linkText("Выбрать"));
        Pause(2);
        click(By.name("submit"));
        Pause(1);
    }

    //Получение номера созданного заказа. Надо перенести чистку строки в базовый класс
    public String findId() {
        wd.get("https://www.eapteka.ru/personal/order/");
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Принят'])[1]/preceding::span[1]")); //Должно работать
        String str = wd.findElement(By.className("sec-profile__order-info-title")).getText();
        String orderId = str.replaceAll("[^0-9]", "");
        System.out.println(orderId);
        return orderId;
    }

    //Поиск номенклатуры через ItemData.
    public void itemSearch(ItemData itemData1) {
        wd.findElement(By.xpath("//form/input")).clear();
        wd.findElement(By.xpath("//form/input")).sendKeys(itemData1.getItem());
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void itemSearchOrder(OrderData orderData) {
        wd.findElement(By.xpath("//form/input")).clear();
        wd.findElement(By.xpath("//form/input")).sendKeys(orderData.getItem());
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    //Выбор региона. Дубль, необходимо удалить.
    public void regionSelection(final String region) throws InterruptedException {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва и МО'])[1]/following::i[1]")).click();
        Pause(3);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" + region + "])[1]/following::li[1]")).click();
    }

    //Переход в ранее созданный заказ по номеру.
    public String findOrder(String orderId) {
        wd.get("https://www.eapteka.ru/personal/order/detail/" + orderId + "/");
        String orderStatus = getOrderStatus(By.xpath(".//div[@class='order-status']/p/span"));
        System.out.println(orderStatus);
        return orderStatus;
    }

    public String getOrderStatus(By xpath) {
        return wd.findElement(xpath).getText();
    }

    //Отмена заказа.
    public String cancelOrder() throws InterruptedException {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Повторить заказ'])[1]/following::span[1]"));
        click(By.className("form-control"));
        wd.findElement(By.className("form-control")).submit();
        String orderStatus = getOrderStatus(By.xpath(".//div[@class='order-status']/p/span"));
        return orderStatus;
    }

}
