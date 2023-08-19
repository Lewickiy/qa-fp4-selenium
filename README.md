# qa-fp4-selenium
Autotests for the <a href="https://qa-scooter.praktikum-services.ru/"> Yandex.Samokat </a> training service</br>
Technologies in the project:</br>
Java 11 / Junit 4.13.2 / Selenium-java 3.141.59 / Apache Maven 3.9.2
<ui>
  <li>
    Testing the Accordion element (Clicking on the panel title opens the corresponding panel)</br>
    In Mozilla Firefox and Chrome browsers the test passes successfully
  </li>
  <li>
    Testing the ordering process (it is necessary to go through the ordering procedure in order</br>
    for the message "Order completed" to appear).</br>
    There are two buttons on the page: one in the header, one in the "third part" of the page.</br>
    In the Chrome browser, checkout does not occur. At the stage of order confirmation, the "YES" button does not respond.</br>
    Mozilla Firefox browser passes tests successfully.
  </li>
</ui>
```shell
mvn clean test
```


