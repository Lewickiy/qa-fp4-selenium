package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.operations.UniversalOperation;
import org.example.pom.ConfirmationModal;
import org.example.pom.ForWhomScooter;
import org.example.pom.OrderDetails;
import org.example.pom.OrderModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class OrdersTest {
    private WebDriver webDriver;
    private UniversalOperation universalOperation;
    public final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    public final By thirdPartOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void orderingTestHeader() {
        orderTest(headerOrderButton);
    }

    @Test
    public void orderingTestThirdPart() {
        orderTest(thirdPartOrderButton);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    private void orderTest(By orderButton) {
        String message = "По результату оформления заказа не появилось уведомление об успешном оформлении заказа";
        webDriver = new ChromeDriver();
        ForWhomScooter forWhomScooter = new ForWhomScooter(webDriver);
        OrderDetails orderDetails = new OrderDetails(webDriver);
        OrderModal orderModal = new OrderModal(webDriver);
        ConfirmationModal confirmationModal = new ConfirmationModal(webDriver);
        universalOperation = new UniversalOperation(webDriver);

        String subwayStationName = "Бутырская";

        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        universalOperation.scrollToElement(orderButton);
        universalOperation.clickElement(orderButton);

        forWhomScooter.fillFirstname("Анатолий");
        forWhomScooter.fillLastname("Левицкий");
        forWhomScooter.fillAddress("г.Санкт-Петербург, ул.Камышовая, д.14");
        forWhomScooter.fillSubwayStation(subwayStationName);
        forWhomScooter.fillPhoneNo("89161260968");
        forWhomScooter.clickNext();

        orderDetails.setDate();
        orderDetails.selectRentalDuration();
        orderDetails.selectColor();
        orderDetails.enterOrderComment("Test order");
        orderDetails.pressSendOrderButton();

        orderModal.clickAcceptButton();

        assertTrue(message, confirmationModal.getConfirmationModal().contains("Заказ оформлен"));
    }
}
