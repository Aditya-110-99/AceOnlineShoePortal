package com.qa.pages;

import com.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {


    @FindBy(xpath = "//span[@class='selectable '][text()='Contacts']")
    WebElement contactsPageHeading;



    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }


    @Step("Getting Contacts Page Heading")
    public boolean isContactHeadingVisible() {
        return contactsPageHeading.isDisplayed();
    }




}
