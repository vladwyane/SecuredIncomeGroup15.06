package registration.pages.test;

import common.elements.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import registration.pages.LostPassword;


import java.util.concurrent.TimeUnit;

public class LostPasswordTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Reporter.log("Before Suit executed",1,true);
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        softAssert = new SoftAssert();
        driver.get("http://securedincomegroup.stgng.co/member-password-lost/");
        Reporter.log("Before Method executed",1,true);
    }

    @AfterMethod
    public void teardown() {
        Reporter.log("After Method executed",1,true);
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCheckMailReset() throws InterruptedException {
        LostPassword lostPassword = new LostPassword(driver);
        lostPassword.enterUserLogin(TestData.testEmail);
        lostPassword.clickResetPasswordButton();
        //Waiting for the email to be sent
        Thread.sleep(5000);
        TestData testData = new TestData(driver);
        softAssert.assertEquals(testData.checkGoogleMail(), "[Secured Income Group] - Reset Password");
        softAssert.assertAll();
    }

    @Test
    public void testClearButton() {
        LostPassword lostPassword = new LostPassword(driver);
        lostPassword.enterUserLogin(TestData.testEmail);
        lostPassword.clickCancelButton();
        softAssert.assertEquals(lostPassword.getUserLoginValue(), "");
        softAssert.assertAll();
    }

    @Test
    public void testEmptyFields() throws InterruptedException {
        LostPassword lostPassword = new LostPassword(driver);
        lostPassword.clickResetPasswordButton();
        Thread.sleep(1000);
        softAssert.assertEquals(lostPassword.getUserLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertAll();
    }
}
