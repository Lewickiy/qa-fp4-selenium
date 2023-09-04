package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;

public class HomePage extends UniversalOperation {
    private final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    private final By thirdPartOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public void createOrderButton(By orderButton) {
        scrollToElement(orderButton);
        clickElement(orderButton);
    }

    public By getHeaderOrderButton() {
        return headerOrderButton;
    }

    public By getThirdPartOrderButton() {
        return thirdPartOrderButton;
    }
}
