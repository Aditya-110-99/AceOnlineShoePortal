package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(ContactsPageTest.class);
    ContactsPageTest contactsPageTest;
    ContactsPage contactsPage;
    HomePage homePage;
    LoginPage loginPage;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        contactsPageTest = new ContactsPageTest();
    }

    @Step("Verifying if the Contact Page Heading is Visible or not")
    @Test(testName = "ContactPage_TC_001")
    public void TC_ContactPage_001() {
        contactsPage = new ContactsPage();
        homePage.clickContacts();
        boolean flag = contactsPage.isContactHeadingVisible();
        Assert.assertTrue(flag, "Contact Page heading is not visible");

    }


}
