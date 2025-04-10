package com.qa.pages;

import com.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {

    @FindBy(xpath = "//span[@class='selectable '][text()='Deals']")
    WebElement dealsLabel;

    public DealsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Step("Getting Deals Page Heading")
    public boolean isDealsHeadingVisible() {
        return dealsLabel.isDisplayed();
    }


}
