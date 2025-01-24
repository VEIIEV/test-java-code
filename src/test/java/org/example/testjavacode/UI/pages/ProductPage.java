package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy(xpath = "//h3[@class='price-container']")
    private SelenideElement productPrice;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private SelenideElement addToCartButton;

    public String getPrice() {
        return productPrice.getText().replaceAll("[^\\d]", "");
    }

    public void addToCart() {
        addToCartButton.click();
    }
}