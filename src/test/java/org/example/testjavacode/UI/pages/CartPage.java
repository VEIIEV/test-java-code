package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$x;

public class CartPage {
    @FindBy(xpath = "//button[text()='Place Order']")
    private SelenideElement placeOrderButton;

    @FindBy(xpath = "//h3[@id='totalp']")
    private SelenideElement totalPrice;

    public int getTotalPrice() {
        return Integer.parseInt(totalPrice.getText());
    }

    public void placeOrder() {
        placeOrderButton.shouldBe(Condition.visible).click();
    }
}