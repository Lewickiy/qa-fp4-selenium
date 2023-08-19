package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderDetails {
    private final WebDriver WEB_DRIVER;
    private UniversalOperation universalOperation;
    private final By INPUT_DATA = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    private final By DROPDOWN_CONTROL = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]");
    private final By RENTAL_DURATION = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By CHECKBOX_COLOR = By.xpath("//*[@id='black']");
    private final By COMMENT_INPUT = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private final By ORDER_BUTTON = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");

    public OrderDetails(WebDriver webDriver) {
        this.WEB_DRIVER = webDriver;
    }

    public void setDate() {
        universalOperation = new UniversalOperation(WEB_DRIVER);
        universalOperation.sendKeysInput(INPUT_DATA, "11.11.2022" + Keys.ENTER);
    }

    public void selectRentalDuration() {
        universalOperation.clickElement(DROPDOWN_CONTROL);
        universalOperation.clickElement(RENTAL_DURATION);
    }

    public void selectColor() {
        universalOperation.clickElement(CHECKBOX_COLOR);
    }

    public void enterOrderComment(String comment) {
        universalOperation.sendKeysInput(COMMENT_INPUT, comment);
    }

    public void pressSendOrderButton() {
        universalOperation.clickElement(ORDER_BUTTON);
    }

}
