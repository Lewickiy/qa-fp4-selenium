package org.example.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversalOperation extends WebDriverConfigurator{

    public void scrollToElement(By by) {
        WebElement element = getWebDriver().findElement(by);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElement(By by) {
        getWebDriver().findElement(by).click();
    }

    public Boolean isElementDisplayed(By by) {
        return getWebDriver().findElement(by).isDisplayed();
    }

    public void waitForLoadData(By by) {
        new WebDriverWait(getWebDriver(), 10).until(driver -> (driver.findElement(by).isDisplayed()));
    }

    public void sendKeysInput(By by, String string) {
            getWebDriver().findElement(by).sendKeys(string);
    }
}
