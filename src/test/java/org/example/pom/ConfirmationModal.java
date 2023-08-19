package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationModal {
    private final WebDriver WEB_DRIVER;
    private final By CONFIRMATION_MODAL_HEADER = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public ConfirmationModal(WebDriver webDriver) {
        this.WEB_DRIVER = webDriver;
    }

    public String getConfirmationModal() {
        return WEB_DRIVER.findElement(CONFIRMATION_MODAL_HEADER).getText();
    }
}
