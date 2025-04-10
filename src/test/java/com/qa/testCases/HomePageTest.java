package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        contactsPage = new ContactsPage();
    }


    @Test(testName = "HomePage_TC_001")
    @Step("Verifying HomePage Title")
    public void TC_HomePage_001() {
        String title = homepage.verifyHomePageTitle();
        Assert.assertEquals(title, "Cogmento CRM", "HomePage Title is not matched");
    }

    @Test(testName = "HomePage_TC_002")
    @Step("Verifying userName Title")
    public void TC_HomePage_002() {
        String userName = homepage.verifyingUserName();
        Assert.assertEquals(userName, "aditya gupta", "userName is not matched");
    }

    @Test(testName = "HomePage_TC_003")
    @Step("Verifying ContactsPage")
    public void TC_HomePage_003() {
        contactsPage = homepage.clickContacts();

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
