package org.example.pom;

import org.example.operations.UniversalOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.regex.Pattern;

public class ForWhomScooter extends UniversalOperation {
    private final By firstnameInput = By.xpath(".//input[contains(@placeholder,'* Имя')]");
    private final By lastnameInput = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");
    private final By addressInput = By.xpath(".//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
    private final By selectSubwayStation = By.xpath(".//input[contains(@placeholder,'* Станция метро')]");
    private final By phoneInput = By.xpath(".//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    private final By nextButtonOne = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Далее')]");
    private final By cookieButton = By.xpath(".//*[@id='rcc-confirm-button']");

    private void fillFirstname(String firstname) {
        //отсутствие латиницы в строке
        if (findAlpha(firstname) && firstname.length() > 1) {
            sendKeysInput(firstnameInput, firstname);
        } else {
            System.out.println("Имя должно быть не короче двух символов, не содержать специальных символов и введено кириллицей");
        }

    }

    private void fillLastname(String lastname) {
        if (findAlpha(lastname) && lastname.length() > 1) {
            sendKeysInput(lastnameInput, lastname);
        } else {
            System.out.println("Фамилия должна быть не короче двух символов, не содержать специальных символов и введена кириллицей");
        }

    }

    private void fillAddress(String address) {
        sendKeysInput(addressInput, address);
    }

    private void fillSubwayStation(String b) {
        sendKeysInput(selectSubwayStation, b + Keys.ARROW_DOWN);
        sendKeysInput(selectSubwayStation, String.valueOf(Keys.ENTER));
    }

    private void fillPhoneNo(String phoneNo) {
        if (findPhoneNo(phoneNo)) {
            sendKeysInput(phoneInput, phoneNo);
        } else {
            System.out.println("Номер телефона должен состоять из 11-13 числовых символов");
        }
    }

    private void clickNext() {
        clickElement(cookieButton);
        clickElement(nextButtonOne);
    }

    private boolean findAlpha(String s) {
        if (s.length() < 2) {
            return false;
        } else {
            Pattern p = Pattern.compile("^[А-Яа-я]");
            return p.matcher(s).find();
        }
    }

    private boolean findPhoneNo(String s) {
        if (s.length() < 11 || s.length() > 13) {
            return false;
        } else {
            Pattern p = Pattern.compile("^[0-9]");
            return p.matcher(s).find();
        }
    }

    public void fillForm(String firstname, String lastname, String address, String subwayStationName, String phoneNo) {
        fillFirstname(firstname);
        fillLastname(lastname);
        fillAddress(address);
        fillSubwayStation(subwayStationName);
        fillPhoneNo(phoneNo);
        clickNext();
    }
}
