package ru.eapteka.ones.web.tests;

import org.testng.annotations.Test;

public class ItemSearchTests extends TestBase {

    public String medication = "Нурофен Экспресс, капсулы обезболивающие 200 мг, 16 шт.";
    public String medicationId = "id250763";

    @Test
    public void testSearchByFullName() {
        app.goTo().findFullName(medication, medicationId);
    }

    @Test
    public void testSearchActiveSubstance() {
        app.goTo().findBy("ибупрофен", medicationId, medication);
    }

    @Test
    public void testSearchPartOfName() {
        app.goTo().findBy("Нуроф", medicationId, medication);
    }

    @Test
    public void testSearchBarcode() {
        app.goTo().findBy("106123", medicationId, medication);
    }

    @Test
    public void testSearcByCatalog() throws InterruptedException {
        app.goTo().findByCatalog("Нурофен Экспресс капсулы 200 мг, 24 шт.", "Лекарства и БАД", "Боль и спазмы");
    }

    @Test
    public void testFilterPrice() {
        app.goTo().filter("Нуроф");
    }
}
