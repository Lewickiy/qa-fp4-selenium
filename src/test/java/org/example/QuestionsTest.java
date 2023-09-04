package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.operations.WebDriverConfigurator;
import org.example.pom.Accordion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.operations.WebDriverEnum.CHROME;
import static org.junit.Assert.assertTrue;

public class QuestionsTest {
    WebDriverConfigurator webDriver = new WebDriverConfigurator(CHROME);

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
    public void isThePanelVisibleAfterClickingOnTheAccordionHeadings() {
        webDriver.setWebDriver();
        webDriver.getWebDriver().get("https://qa-scooter.praktikum-services.ru/");
        Accordion objAccordionFAQ = new Accordion();
        List<WebElement> webElementList = objAccordionFAQ.getWebElements();

        for (WebElement webElement : webElementList) {
            boolean actualResult;

            By heading = By.id(webElement.getAttribute("id"));
            By panel = By.id(webElement.getAttribute("aria-controls"));

            objAccordionFAQ.scrollToElement(heading);
            objAccordionFAQ.clickElement(heading);
            objAccordionFAQ.waitForLoadData(panel);
            actualResult = objAccordionFAQ.isElementDisplayed(heading);
            String message = String.format("После клика по заголовку (%s) панель (%s) открывается и становится видимой: %b", heading, panel, actualResult);

            assertTrue(message, actualResult);
        }
    }

    @After
    public void teardown() {
        webDriver.getWebDriver().quit();
    }
}
