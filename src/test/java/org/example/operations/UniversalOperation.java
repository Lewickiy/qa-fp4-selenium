package org.example.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversalOperation {
    private final WebDriver WEB_DRIVER;

    public UniversalOperation(WebDriver driver) {
        this.WEB_DRIVER = driver;
    }

    public void scrollToElement(By by) {
        WebElement element = WEB_DRIVER.findElement(by);
        ((JavascriptExecutor) WEB_DRIVER).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElement(By by) {
        WEB_DRIVER.findElement(by).click();
    }

    public Boolean isElementDisplayed(By by) {
        return WEB_DRIVER.findElement(by).isDisplayed();
    }

    public void waitForLoadData(By by) {
        new WebDriverWait(WEB_DRIVER, 10).until(driver -> (driver.findElement(by).isDisplayed()));
    }

    public void sendKeysInput(By by, String string) {
            WEB_DRIVER.findElement(by).sendKeys(string);
    }
}
