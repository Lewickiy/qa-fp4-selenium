package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class ForWhomScooter {
    private final WebDriver webDriver;
    private final UniversalOperation universalOperation;
    private final By firstnameInput = By.xpath(".//input[contains(@placeholder,'* Имя')]");
    private final By lastnameInput = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");
    private final By addressInput = By.xpath(".//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
    private final By selectSubwayStation = By.xpath(".//input[contains(@placeholder,'* Станция метро')]");
    private final By phoneInput = By.xpath(".//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    private final By nextButtonOne = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Далее')]");
    private final By cookieButton = By.xpath(".//*[@id='rcc-confirm-button']");

    public ForWhomScooter(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.universalOperation = new UniversalOperation(webDriver);
    }



    public void fillFirstname(String firstname) {
        //отсутствие латиницы в строке
        if (findAlpha(firstname) && firstname.length() > 1) {
            universalOperation.sendKeysInput(firstnameInput, firstname);
        } else {
            System.out.println("Имя должно быть не короче двух символов, не содержать специальных символов и введено кириллицей");
        }

    }

    public void fillLastname(String lastname) {
        if (findAlpha(lastname) && lastname.length() > 1) {
            universalOperation.sendKeysInput(lastnameInput, lastname);
        } else {
            System.out.println("Фамилия должна быть не короче двух символов, не содержать специальных символов и введена кириллицей");
        }

    }

    public void fillAddress(String address) {
        universalOperation.sendKeysInput(addressInput, address);
    }

    public void fillSubwayStation(String b) {
        universalOperation.sendKeysInput(selectSubwayStation, b + Keys.ARROW_DOWN);
        universalOperation.sendKeysInput(selectSubwayStation, String.valueOf(Keys.ENTER));
    }

    public void fillPhoneNo(String phoneNo) {
        if (findPhoneNo(phoneNo)) {
            universalOperation.sendKeysInput(phoneInput, phoneNo);
        } else {
            System.out.println("Номер телефона должен состоять из 11-13 числовых символов");
        }
    }

    public void clickNext() {
        universalOperation.clickElement(cookieButton);
        universalOperation.clickElement(nextButtonOne);
    }

    public boolean findAlpha(String s) {
        boolean result = false;
        if (s.length() < 2) {
            return result;
        } else {
            Pattern p = Pattern.compile("^[А-Яа-я]");
            return p.matcher(s).find();
        }
    }

    public boolean findPhoneNo(String s) {
        boolean result = false;
        if (s.length() < 11 && s.length() > 13) {
            return result;
        } else {
            Pattern p = Pattern.compile("^[0-9]");
            return p.matcher(s).find();
        }
    }
}
