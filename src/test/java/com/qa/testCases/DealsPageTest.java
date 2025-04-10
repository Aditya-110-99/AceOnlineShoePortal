package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DealsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;

    public DealsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        dealsPage = new DealsPage();
    }

    @Step("Verifying if the user is able to see the DealsPage Heading")
    @Test(testName = "DealsPage_TC_001")
    public void TC_DealsPage_001() {
        dealsPage = new DealsPage();
        homePage = new HomePage();
        homePage.clickDeals();
        boolean flag = dealsPage.isDealsHeadingVisible();
        Assert.assertTrue(flag, "Deals Page  heading is not visible");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
