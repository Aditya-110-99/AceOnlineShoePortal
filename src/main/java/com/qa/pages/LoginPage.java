package com.qa.pages;

import com.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory ... or Object Repository(OR)

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginBtn;


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public HomePage login(String uEmail, String uPassword) {
        email.sendKeys(uEmail);
        password.sendKeys(uPassword);
        loginBtn.click();
        return new HomePage();
    }

    @Step("Verifying if the Email Input field is visible")
    public boolean isEmailInputFieldVisible() {
        return email.isDisplayed();
    }

    @Step("Verifying if the Password Input field is visible")
    public boolean isPasswordInputFieldVisible() {
        return password.isDisplayed();
    }

    @Step("Verifying if the Login button is Visible")
    public boolean isLoginButtonVisible() {
        return loginBtn.isDisplayed();
    }

}

