package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;

public class OrderModal extends UniversalOperation {
    private final By acceptButton = By.xpath(".//button[text()='Да']");

    public void clickAcceptButton() {
        waitForLoadData(acceptButton);
        clickElement(acceptButton);
    }
}
