package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.web.model.PageData;

import java.util.List;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    //Переход на главную
    public void home() {
        click(By.linkText("Главная"));
    }

    //Выбор региона.
    public void regionSelection(String region) throws InterruptedException {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва и МО'])[1]/following::i[1]"));
        Pause(3);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" + region + "])[1]/following::li[1]"));
    }

    //Не универсальная проверка переходов на главной странице.
    public void productGroups(String group, String groupsValidName) throws InterruptedException {
        Pause(1);
        click(By.linkText(group));
        String groupsName = wd.findElement(By.className("sec-inner__title mt-4 mt-md-0 mb-sm-1 mb-md-4")).getText();
        Assert.assertEquals(groupsValidName, groupsName);
    }

    //Проверка переходов на главной странице
    public void link(String validValue, By path) {
        click(path);
        headerCheck(validValue);
    }

    public void linkData(PageData pages) {
        click(pages.getPath());
        headerCheck(pages.getValidValue());
    }

    //Ввод почты для подписки на рассылку.
    public void subscribe(String mail) {
        type(By.name("EMAIL"), mail);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выгодные предложения для подписчиков'])[1]/following::button[1]"));
    }

    //Проверка открытия дополнительной страницы.
    public void socialNetwork(String validValue, By locator) throws InterruptedException {
        click(locator);
        Pause(1);
        try {
            String winHandleBefore = wd.getWindowHandle();

            for (String winHandle : wd.getWindowHandles()) {
                wd.switchTo().window(winHandle);
                String act = wd.getCurrentUrl();
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        String url = wd.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(validValue, url);
    }

    //Поиск по полному наименованию.
    public void findFullName(String search, String id) {
        type(By.id("search"), search);
        click(By.className("searchbar__button"));
        wd.findElement(By.xpath("//a[@href='/goods/" + id + "/']")).click();
        headerCheck(search);
    }

    //Поиск по произвольному наименованию.
    public void findBy(String search, String id, String fullName) {
        type(By.id("search"), search);
        click(By.className("searchbar__button"));
        wd.findElement(By.xpath("//a[@href='/goods/" + id + "/']")).click();
        headerCheck(fullName);
    }

    //Поиск через каталог.
    public void findByCatalog(String fullName, String main, String category) throws InterruptedException {
        click(By.linkText(main));
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Стимуляторы кроветворения'])[1]/following::a[1]")).click();
        // click(By.xpath("//a[@href='/goods/drugs/"+category+"/']"));
        click(By.linkText(category));
        click(By.xpath("//div[9]/label/i"));
        Pause(2);
        click(By.linkText(fullName));
        headerCheck(fullName);
    }

    //Проверка работы фильтров.
    public void filter(String search) {
        type(By.id("search"), search);
        click(By.className("searchbar__button"));
        click(By.linkText("По популярности"));
        click(By.linkText("Сначала дешевые"));
        List<WebElement> cheap = wd.findElements(By.className("price--num"));
        click(By.linkText("Сначала дешевые"));
        click(By.linkText("Сначала дорогие"));
        List<WebElement> expensive = wd.findElements(By.className("price--num"));
        Assert.assertNotEquals(cheap, expensive);
    }

    //Поиск продукта дня на главной странице.
    public void productOfTheDay() {
        String product = wd.findElement(By.className("goods--name")).getText();
        click(By.className("goods--img"));
        System.out.println(product);
        headerCheck(product);
    }

    //Не работающее!!! получение информации о доставке.
    public void pickupAndDelivery() {
        String delivery = getText(By.xpath("//a[@href='#catalog-delivery-courier']/a"));
        System.out.println(delivery);
    }

    //Проверка изменения количества в корзине.
    public void garbageChange(int quantity, String validError) throws InterruptedException {
        inBaskett();
        int quantityNow;
        typeInt(By.cssSelector("div.product-row__counter.hidden-xs > input[type=\"text\"]"), quantity);
        Pause(1);
        quantityNow = getQuantityNow();
        equalsInt(quantity, quantityNow);
        click(By.linkText("+"));
        Pause(1);
        quantityNow = getQuantityNow();
        quantity = quantity + 1;
        equalsInt(quantity, quantityNow);
        click(By.linkText("—"));
        Pause(1);
        quantityNow = getQuantityNow();
        quantity = quantity - 1;
        equalsInt(quantity, quantityNow);
        cleanBaskett(validError);

    }

    //Чистка корзины за собой
    public void cleanBaskett(String validError) {
        click(By.linkText("Очистить корзину"));
        click(By.linkText("Да"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вы точно хотите удалить все товары из корзины?'])[2]/following::a[1]"));
        String error = wd.findElement(By.className("error-message")).getText();
        equals(error, validError);
    }

    //Верификация количества в корзине.
    public int getQuantityNow() {
        String text = getText(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ваш заказ'])[1]/following::div[2]"));
        text = text.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(text);
        return i;
    }

    //Поиск и запись текущей цены.
    public int getPrice() {
        int price = 0;
        String text = getText(By.className("price--num"));
        price = Integer.parseInt(text);
        return price;
    }

    //Переход в карточку из корзины
    public void fromCartToCard(String name) throws InterruptedException {
        click(By.className("product-row__title"));
        headerCheck(name);
        inBaskett();
        cleanBaskett("Ваша корзина пуста");
    }
}

