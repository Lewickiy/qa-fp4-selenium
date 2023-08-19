package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.operations.UniversalOperation;
import org.example.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainTest {
    private WebDriver webDriver;
    String message;
    private UniversalOperation universalOperation;
    private final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    private final By thirdPartOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void isThePanelVisibleAfterClickingOnTheAccordionHeadings() {
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        Accordion objAccordionFAQ = new Accordion(webDriver);
        universalOperation = new UniversalOperation(webDriver);
        List<WebElement> webElementList = objAccordionFAQ.getWebElements();

        for (WebElement webElement : webElementList) {
            boolean actualResult;

            By heading = By.id(webElement.getAttribute("id"));
            By panel = By.id(webElement.getAttribute("aria-controls"));

            universalOperation.scrollToElement(heading);
            universalOperation.clickElement(heading);
            universalOperation.waitForLoadData(panel);
            actualResult = universalOperation.isElementDisplayed(heading);
            message = String.format("После клика по заголовку (%s) панель (%s) открывается и становится видимой: %b", heading, panel, actualResult);

            assertTrue(message, actualResult);
        }
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
