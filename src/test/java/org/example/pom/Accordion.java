package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Accordion {
    private final WebDriver driver;
    private final List<WebElement> webElements;

    public Accordion(WebDriver driver) {
        this.driver = driver;
        this.webElements = driver.findElements(By.xpath(".//div[@class = 'accordion__button']"));
    }

    public List<WebElement> getWebElements() {
        return webElements;
    }

}
