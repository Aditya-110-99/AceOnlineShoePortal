package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(testName = "LoginPage_TC_001")
    @Step("Validating if the Email Input Field is Visible")
    public void TC_LoginPage_001() {

        boolean flag = loginPage.isEmailInputFieldVisible();
        Assert.assertTrue(flag, "Email Input Field is not visible");
    }

    @Test(testName = "LoginPage_TC_002")
    @Step("Validating if the Password Input is Visible")
    public void TC_LoginPage_002() {
        boolean flag = loginPage.isPasswordInputFieldVisible();
        Assert.assertTrue(flag, "Password Input Filed is not visible");

    }

    @Test(testName = "LoginPage_TC_003")
    @Step("Validating if the Login Button is Visible")
    public void TC_LoginPage_003() {
        boolean flag = loginPage.isLoginButtonVisible();
        Assert.assertTrue(flag, "Login Button is not visible");
    }


    @Test(testName = "LoginPage_TC_004")
    @Step("Validating if the User is able to Login")
    public void login() {
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }






}
