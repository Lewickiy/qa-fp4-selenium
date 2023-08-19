package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderModal {
    private final WebDriver WEB_DRIVER;
    UniversalOperation universalOperation;
    private final By ACCEPT_BUTTON = By.xpath(".//button[text()='Да']");

    public OrderModal(WebDriver webDriver) {
        this.WEB_DRIVER = webDriver;
    }

    public void clickAcceptButton() {
        universalOperation = new UniversalOperation(WEB_DRIVER);
        universalOperation.waitForLoadData(ACCEPT_BUTTON);
        universalOperation.clickElement(ACCEPT_BUTTON);
    }
}
