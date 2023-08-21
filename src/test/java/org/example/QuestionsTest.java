package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.operations.UniversalOperation;
import org.example.pom.Accordion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class QuestionsTest {
    //TODO
    private WebDriver webDriver;
    private UniversalOperation universalOperation;

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
            String message = String.format("После клика по заголовку (%s) панель (%s) открывается и становится видимой: %b", heading, panel, actualResult);

            assertTrue(message, actualResult);
        }
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
