package com.qa.pages;

import com.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[@class='user-display'][text()='aditya gupta']")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsSidebarBtn;

    @FindBy(xpath = "//span[text()='Deals']")
    WebElement dealsSidebarBnt;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Getting HomePage title")
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    @Step("Clicking on Contacts Button")
    public ContactsPage clickContacts() {
        contactsSidebarBtn.click();
        return new ContactsPage();
    }

    @Step("Clicking on Deals Button")
    public DealsPage clickDeals() {
        dealsSidebarBnt.click();
        return new DealsPage();
    }

    @Step("Getting UserName")
    public String verifyingUserName()
    {
        return userNameLabel.getText();
    }




}
