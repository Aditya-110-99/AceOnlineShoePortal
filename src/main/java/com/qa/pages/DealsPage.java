package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends TestBase {

    @FindBy(xpath = "//span[@class='selectable '][text()='Deals']")
    WebElement dealsLabel;

}
