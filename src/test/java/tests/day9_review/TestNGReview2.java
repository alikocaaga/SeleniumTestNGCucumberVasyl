package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.logging.SocketHandler;

public class TestNGReview2 {
    //whatever is common among tests, can go into @beforemethod and @aftermethod
    // it helps to reduce code duplication
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After method!");
        driver.quit();
    }

    @Test(description = "Verify title of google.com")
    public void test1() {
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "title is bnot correct!");

    }
    @Test (description = "verifyApplePageTitle")
    public void verifyApplePageTitle(){
        System.out.println("Test 2");
        driver.get("https://www.apple.com");
        String expectedTitle = "Apple";
        String actualTitile = driver.getTitle();
        Assert.assertEquals(actualTitile,expectedTitle,"title is not correct!!");

    }
    @Test (description = "Verify title is herkul.org")
    public void verifyTitileHerkul() {

        driver.get("http://www.herkul.org");
        System.out.println(driver.getTitle());
        String expectedTitle = "Fethullah Gülen Hocaefendi'nin haftalık sohbetleri.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Not correct!!!");

    }
}
