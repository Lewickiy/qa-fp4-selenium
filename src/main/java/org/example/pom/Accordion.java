package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Accordion extends UniversalOperation {
    private final List<WebElement> webElements = getWebDriver().findElements(By.xpath(
            ".//div[@class = 'accordion__button']"
            )
    );

    public List<WebElement> getWebElements() {
        return webElements;
    }

}
