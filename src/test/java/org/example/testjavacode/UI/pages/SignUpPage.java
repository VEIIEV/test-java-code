package org.example.testjavacode.UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    @FindBy(xpath = "//input[@id='sign-username']")
    private SelenideElement usernameInput;

    @FindBy(xpath = "//input[@id='sign-password']")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign up']")
    private SelenideElement signUpButton;

    public void signUp(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        signUpButton.click();
    }
}
