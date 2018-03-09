package registration.pages.test;

import common.elements.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import registration.pages.CreateAccount;
import registration.pages.LostPassword;
import registration.pages.Register;
import user.pages.UserAccount;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Reporter.log("Before Suit executed", 1, true);
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        softAssert = new SoftAssert();
        driver.get(TestData.securUrl);
        Reporter.log("Before Method executed", 1, true);
    }

    @AfterMethod
    public void teardown() {
        Reporter.log("After Method executed", 1, true);
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEmptyFields() throws InterruptedException {
        Register register = new Register(driver);
        register.clickSignInButton();
        Thread.sleep(1000);
        softAssert.assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test
    public void testErrorLogin() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin("error");
        register.enterPassword(TestData.correctPassword);
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "We don't have any users with that email address. Maybe you used a different one when signing up?");
        softAssert.assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test
    public void testErrorPassword() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin(TestData.testEmail);
        register.enterPassword("v123ch");
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "The password you entered wasn't quite right. Did you forget your password?");
        softAssert.assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test
    public void testErrorSpaces() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin(" ");
        register.enterPassword(" ");
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "You do have an email address, right?");
        softAssert.assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test
    public void testClearButton() {
        Register register = new Register(driver);
        register.enterLogin("error");
        register.enterPassword("v1234");
        register.clickCancelButton();
        softAssert.assertEquals(register.getLoginValue(), "");
        softAssert.assertEquals(register.getPasswordValue(), "");
        softAssert.assertAll();
    }

    @Test
    public void testCreateAccountLink() throws InterruptedException {
        Register register = new Register(driver);
        register.clickCreateAccountLink();
        Thread.sleep(2000);
        CreateAccount createAccount = new CreateAccount(driver);
        softAssert.assertEquals(createAccount.getMainHeading(), "Create Your Account");
        softAssert.assertAll();
    }

    @Test
    public void testResetPasswordLink() throws InterruptedException {
        Register register = new Register(driver);
        register.clickLostPasswordLink();
        Thread.sleep(2000);
        LostPassword lostPassword = new LostPassword(driver);
        softAssert.assertEquals(lostPassword.getMainHeading(), "Enter your email address and we'll send you a link you can use to pick a new password.");
        softAssert.assertAll();
    }

    @Test
    public void testCorrectSignIn() {
        Register register = new Register(driver);
        register.enterLogin(TestData.testEmail);
        register.enterPassword(TestData.correctPassword);
        register.clickSignInButton();
        UserAccount userAccount = new UserAccount(driver);
        softAssert.assertEquals(userAccount.getHeadingSidebar(), "Open A New Account");
        softAssert.assertAll();
    }
}