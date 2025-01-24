package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {

    @FindBy(xpath = "//a[text()='Sign up']")
    private SelenideElement signUpButton;

    @FindBy(xpath = "//a[text()='Log in']")
    private SelenideElement loginButton;

    @FindBy(xpath = "//a[text()='Cart']")
    private SelenideElement cartButton;


    @FindBy(xpath = "//a[text()='Home ']")
    private SelenideElement homeButton;

    @FindBy(xpath = "//a[text()='Phones']")
    private SelenideElement phonesCategory;

    @FindBy(xpath = "//a[text()='Laptops']")
    private SelenideElement laptopsCategory;

    @FindBy(xpath = "//a[text()='Monitors']")
    private SelenideElement monitorsCategory;

    public void openSignUp() {
        signUpButton.shouldBe(Condition.visible).click();
    }

    public void openLogin() {
        loginButton.hover().shouldBe(Condition.visible, Condition.enabled);
        sleep(1000);
        loginButton.shouldBe(Condition.not(Condition.hidden)).click();
    }

    public void openCart() {
        cartButton.shouldBe(Condition.visible).click();
    }

    public void openHome() {
        sleep(2000);
        homeButton.shouldBe(Condition.visible).click();
    }

    public void selectCategory(String category) {
        $x("//a[text()='" + category + "']").click();
    }

    public void selectProduct(String productName) {
        $x("//a[text()='" + productName + "']").click();
    }
}
