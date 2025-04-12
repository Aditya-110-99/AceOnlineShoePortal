package com.qa.base;

import com.qa.utiities.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\adity\\IdeaProjects\\QAAutoamtionFramework\\src\\main\\java\\com\\" + "qa\\configuration\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void initialization() {
        String browserName = System.getProperty("browser");
        String headless=System.getProperty("headless");
        if (browserName.equals("chrome")) {
            ChromeOptions options =   new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            if (headless!=null)
            {
                options.addArguments("--headless");

            }
        }

        else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


    }


    @AfterSuite(alwaysRun = true)
    public static void env()
    {
        String browserValue = System.getProperty("Browser");
        String moduleValue = System.getProperty("Module");
        String executorValue =System.getProperty("Executor");

        Properties properties = new Properties();
        properties.setProperty("Browser",browserValue);
        properties.setProperty("Module",moduleValue);
        properties.setProperty("Executor",executorValue);


        try(FileOutputStream fs = new FileOutputStream("Reports/environment.properties"))
        {
            properties.store(fs,"Environment Configuration");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

