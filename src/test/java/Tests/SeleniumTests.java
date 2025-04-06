package Tests;

import Pages.HomePage;
import Pages.OnlineProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {
    public static WebDriver driver;

    static ExtentReports report;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();


    @BeforeTest
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        HomePage.clickHamburger();
        HomePage.clickOnlineProducts();
    }


    @Test
    void validateTitles_OnlineProducts() {
        test = extent.createTest("Validate Shoes Titles", "This test validates that the different shoe types are correct on online shoe page");
        String shoeHeading1 = "Formal Shoes";
        String shoeHeading2 = "Sports Shoes";
        String shoeHeading3 = "Sneakers";
        try {
            SoftAssert s = new SoftAssert();
            s.assertTrue(OnlineProductsPage.getShoesHeading(shoeHeading1), shoeHeading1);
            s.assertTrue(OnlineProductsPage.getShoesHeading(shoeHeading2), shoeHeading2);
            s.assertTrue(OnlineProductsPage.getShoesHeading(shoeHeading3), shoeHeading3);
            s.assertAll();
            test.log(Status.PASS, "Formal shoe title '" + shoeHeading1 + "' is correctly displayed.");
            test.log(Status.PASS, "Formal shoe title '" + shoeHeading2 + "' is correctly displayed.");
            test.log(Status.PASS, "Formal shoe title '" + shoeHeading3 + "' is correctly displayed.");


        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            throw e;
        }

    }

    @Test
    public void validateFormalShoeTitle() {
        test = extent.createTest("Validate Formal Shoes Titles", "This test validates that the Formal shoe title are correct on online shoe page");

        String title = "   Prestige Chelsea";
        OnlineProductsPage.clickFormalShoesDropdown();
        try {
            Assert.assertTrue(OnlineProductsPage.getFormalShoesTitle(title), "Shoe title not found: " + title);
            test.log(Status.PASS, "Formal shoe title '" + title + "' is correctly displayed.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            throw e; // rethrow to ensure test fails
        }


    }

    @Test
    public void validateSportsShoeTitle() {
        test = extent.createTest("Validate Sports Shoes Titles", "This test validates that the Sports shoe title are correct on online shoe page");

        String title = "   Flyte Foam";
        OnlineProductsPage.clickSportsShoesDropdown();
        try {
            Assert.assertTrue(OnlineProductsPage.getSportsShoesTitle(title), "Shoe title not found: " + title);
            test.log(Status.PASS, "Sports shoe title '" + title + "' is correctly displayed.");


        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            throw e; // rethrow to ensure test fails
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void flush() {
        extent.flush();
    }
}
