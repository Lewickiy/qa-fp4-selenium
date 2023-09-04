package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;

public class ConfirmationModal extends UniversalOperation {
    private final By confirmationModalHeader = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public String getConfirmationModal() {
        return getWebDriver().findElement(confirmationModalHeader).getText();
    }
}
