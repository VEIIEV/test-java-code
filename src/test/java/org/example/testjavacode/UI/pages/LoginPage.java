package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@id='loginusername']")
    private SelenideElement usernameInput;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private SelenideElement loginButton;

    public void login(String username, String password) {
        Selenide.sleep(2000);
        usernameInput.shouldBe(Condition.visible).setValue(username);
        passwordInput.shouldBe(Condition.visible).setValue(password);
        loginButton.click();
    }
}
