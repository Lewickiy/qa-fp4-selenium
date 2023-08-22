package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class OrderDetails extends UniversalOperation {
    private final By inputDate = By.xpath(".//input[contains(@placeholder,'* Когда привезти самокат')]");
    private final By dropdownControl = By.xpath(".//div[text()='* Срок аренды']");
    private final By rentalDuration = By.xpath(".//div[@class='Dropdown-menu']");
    private final By checkboxColor = By.xpath(".//*[@id='black']");
    private final By commentInput = By.xpath(".//input[contains(@placeholder,'Комментарий для курьера')]");
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    private void setDate(String date) {
        sendKeysInput(inputDate, date + Keys.ENTER);
    }

    private void selectRentalDuration() {
        clickElement(dropdownControl);
        clickElement(rentalDuration);
    }

    private void selectColor() {
        clickElement(checkboxColor);
    }

    private void enterOrderComment(String comment) {
        sendKeysInput(commentInput, comment);
    }

    private void pressSendOrderButton() {
        clickElement(orderButton);
    }

    public void fillForm(String date, String comment) {
        setDate(date);
        selectRentalDuration();
        selectColor();
        enterOrderComment(comment);
        pressSendOrderButton();
    }
}
