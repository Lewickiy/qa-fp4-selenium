package org.example.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfigurator {
    private static WebDriver webDriver;
    private static WebDriverEnum webDriverEnum;

    public WebDriverConfigurator(WebDriverEnum webDriverEnum) {
        this.webDriverEnum = webDriverEnum;
    }
    public WebDriverConfigurator() {
    }

    public void setWebDriver() {
        switch (getBrowser()) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            default:
                webDriver = null;
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverEnum getBrowser() {
        return webDriverEnum;
    }
}
