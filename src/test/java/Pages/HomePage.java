package Pages;


import Tests.SeleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

import static Tests.SeleniumTests.driver;

public class HomePage {

    public static String hamburgerMenu = "//input[@type='checkbox']";
    public static String menuOnlineProducts = "//div[@id='menuToggle']//li[text()='Online Products']";

    public static void clickHamburger() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath(hamburgerMenu)).click();

    }

    public static void clickOnlineProducts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath(menuOnlineProducts)).click();
    }
}
