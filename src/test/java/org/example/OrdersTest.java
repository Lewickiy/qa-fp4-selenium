package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.operations.WebDriverConfigurator;
import org.example.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.example.operations.WebDriverEnum.CHROME;
import static org.junit.Assert.assertTrue;

public class OrdersTest {
    WebDriverConfigurator webDriver = new WebDriverConfigurator(CHROME);
    HomePage homePage = new HomePage();
    ForWhomScooter forWhomScooter = new ForWhomScooter();
    OrderDetails orderDetails = new OrderDetails();
    OrderModal orderModal = new OrderModal();
    ConfirmationModal confirmationModal = new ConfirmationModal();

    @Before
    public void startUp() {
        switch (webDriver.getBrowser()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
        }
    }

    @Test
    public void orderingTestHeader() {
        orderTest(homePage.getHeaderOrderButton());
    }

    @Test
    public void orderingTestThirdPart() {
        orderTest(homePage.getThirdPartOrderButton());
    }

    @After
    public void teardown() {
        webDriver.getWebDriver().quit();
    }

    private void orderTest(By orderButton) {
        String message = "По результату оформления заказа не появилось уведомление об успешном оформлении заказа";
        webDriver.setWebDriver();
        webDriver.getWebDriver().get("https://qa-scooter.praktikum-services.ru/");
        homePage.createOrderButton(orderButton);
        forWhomScooter.fillForm("Анатолий"
                , "Левицкий"
                , "г.Санкт-Петербург, ул.Камышовая, д.14"
                , "Бутырская"
                , "89161260968"
        );
        orderDetails.fillForm("08.04.2024", "test order");
        orderModal.clickAcceptButton();

        assertTrue(message, confirmationModal.getConfirmationModal().contains("Заказ оформлен"));
    }
}
