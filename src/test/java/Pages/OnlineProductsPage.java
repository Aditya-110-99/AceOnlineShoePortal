package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Tests.SeleniumTests.driver;

public class OnlineProductsPage {

    public static String ShoesHeading = "//h2";


    public static String formalShoesDropDown = "//i[@class='fa fa-angle-double-down formalshoedropdown']";
    public static String sportsShoesDropDown = "//i[@class='fa fa-angle-double-down sportsshoedropdown']";
    public static String sneakersDropDow = "//i[@class='fa fa-angle-double-down sneakershoedropdown']";

    public static String formalShoeTableTitle = "//div[2]//tbody[1]/tr/td[1]";
    public static String SportsShoeTableTitle = "//div[3]//tbody[1]/tr/td[1]";

    public static boolean getShoesHeading(String heading) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> elements = driver.findElements(By.xpath(ShoesHeading));
        for (WebElement element : elements) {
            if (element.getText().equals(heading)) {
                return true;
            }
        }
        return false;


    }


    public static void clickFormalShoesDropdown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loc = driver.findElement(By.xpath(formalShoesDropDown));
        loc.click();

    }
    public static void clickSportsShoesDropdown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loc = driver.findElement(By.xpath(sportsShoesDropDown));
        loc.click();

    }
    public static void clickSneakersDropdown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loc = driver.findElement(By.xpath(sneakersDropDow));
        loc.click();

    }

    public static boolean getFormalShoesTitle(String title) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> elements = driver.findElements(By.xpath(formalShoeTableTitle));
        for (WebElement element : elements) {
            if (element.getText().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getSportsShoesTitle(String text) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> elements = driver.findElements(By.xpath(SportsShoeTableTitle));
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }
}
