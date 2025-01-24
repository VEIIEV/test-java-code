package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {

    @FindBy(xpath = "//button[text()='Place Order']")
    SelenideElement placeOrderButton;

    @FindBy(xpath = "//input[@id='name']")
    SelenideElement nameInput;

    @FindBy(xpath = "//input[@id='country']")
    SelenideElement countryInput;

    @FindBy(xpath = "//input[@id='city']")
    SelenideElement cityInput;

    @FindBy(xpath = "//input[@id='card']")
    SelenideElement creditCardInput;

    @FindBy(xpath = "//input[@id='month']")
    SelenideElement monthInput;

    @FindBy(xpath = "//input[@id='year']")
    SelenideElement yearInput;

    @FindBy(xpath = "//button[text()='Purchase']")
    SelenideElement purchaseButton;

    public void placeOrder(String name, String country, String city, String creditCard,  String month, String year) {
        Selenide.sleep(2000);
        nameInput.shouldBe(Condition.visible).setValue(name);
        countryInput.setValue(country);
        cityInput.setValue(city);
        creditCardInput.setValue(creditCard);
        monthInput.setValue(month);
        yearInput.setValue(year);
        purchaseButton.shouldBe(Condition.enabled).click();
    }

}
