package org.example.testjavacode.UI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.example.testjavacode.UI.pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    private final Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.demoblaze.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;

        WebDriverRunner.addListener(new WebDriverListener() {
            @Override
            public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {
                try {
                    alert.accept(); // Закрываем алерт
                    System.out.println("Alert accepted automatically!");
                } catch (Exception e) {
                    System.out.println("No alert to accept!");
                }
            }
        });
    }

    @Test
    void testUserJourney() {
        String username = faker.name().username();
        String password = faker.internet().password(8, 12);

        MainPage mainPage = open("/", MainPage.class);

        mainPage.openSignUp();
        SignUpPage signUpPage = page(SignUpPage.class);
        signUpPage.signUp(username, password);


        mainPage.openLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(username, password);

        int totalPrice = 0;

        mainPage.selectCategory("Phones");
        mainPage.selectProduct("Samsung galaxy s6");
        ProductPage productPage = page(ProductPage.class);
        String phonePrice = productPage.getPrice();
        totalPrice += Integer.parseInt(phonePrice);
        productPage.addToCart();

        mainPage.openHome();
        mainPage.selectCategory("Laptops");
        mainPage.selectProduct("Sony vaio i5");
        String laptopPrice = productPage.getPrice();
        totalPrice += Integer.parseInt(laptopPrice);
        productPage.addToCart();

        mainPage.openHome();
        mainPage.selectCategory("Monitors");
        mainPage.selectProduct("Apple monitor 24");
        String monitorPrice = productPage.getPrice();
        totalPrice += Integer.parseInt(monitorPrice);
        productPage.addToCart();

        mainPage.openCart();
        CartPage cartPage = page(CartPage.class);
        sleep(2000);
        assertEquals(totalPrice, cartPage.getTotalPrice());
        cartPage.placeOrder();
    }
}