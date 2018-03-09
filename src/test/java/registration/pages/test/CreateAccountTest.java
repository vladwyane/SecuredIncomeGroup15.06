package registration.pages.test;

import common.elements.TestData;
import create.investments.Step1;
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
import registration.pages.Register;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest {

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
        driver.get("http://securedincomegroup.stgng.co/registration/");
        Reporter.log("Before Method executed",1,true);
    }

    @AfterMethod
    public void teardown() {
        Reporter.log("After Method executed",1,true);
        if (driver != null) {
            driver.quit();
        }

    }

    @Test (groups = "registration")
    public void testCorrectRegistration() throws InterruptedException {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.enterFirstName("Vladyslav");
        createAccount.enterLastName("Chesalov");
        createAccount.enterLogin(TestData.testEmail);
        createAccount.enterPassword(TestData.correctPassword);
        createAccount.clickCaptcha();
        Thread.sleep(3000);
        createAccount.clickSubmitButton();
        //Waiting for the email to be sent
        Thread.sleep(5000);
        Step1 step1 = new Step1(driver);
        softAssert.assertEquals(step1.getMainHeading(), "Account Information");
        softAssert.assertAll();
    }

    @Test
    public void testEmptyFields() throws InterruptedException {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.clickSubmitButton();
        Thread.sleep(2000);
        softAssert.assertEquals(createAccount.getErrorMessage(), "The Google reCAPTCHA check failed. Are you a robot?");
        softAssert.assertEquals(createAccount.getEmailFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(createAccount.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(createAccount.getEmailFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(createAccount.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test (dependsOnGroups = "registration")
    public void testSameEmail() throws InterruptedException {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.enterLogin(TestData.testEmail);
        createAccount.enterPassword(TestData.correctPassword);
        createAccount.clickCaptcha();
        Thread.sleep(3000);
        createAccount.clickSubmitButton();
        Thread.sleep(2000);
        softAssert.assertEquals(createAccount.getErrorMessage(), "An account exists with this email address.");
        softAssert.assertEquals(createAccount.getEmailFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(createAccount.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        softAssert.assertEquals(createAccount.getEmailFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertEquals(createAccount.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        softAssert.assertAll();
    }

    @Test
    public void testClearButton() {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.enterLogin(TestData.testEmail);
        createAccount.enterPassword(TestData.correctPassword);
        createAccount.clickCancelButton();
        softAssert.assertEquals(createAccount.getEmailValue(), "");
        softAssert.assertEquals(createAccount.getPasswordValue(), "");
        softAssert.assertAll();
    }

    @Test
    public void testSignInLink() throws InterruptedException {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.clickSignInLink();
        Thread.sleep(2000);
        Register register = new Register(driver);
        softAssert.assertEquals(register.getCreateAccountLinkValue(), "Create Account Now");
        softAssert.assertAll();
    }

    @Test (dependsOnGroups = "registration")
    public void testCheckMail1() throws InterruptedException {
        TestData testData = new TestData(driver);
        softAssert.assertEquals(testData.checkGoogleMail(), "Welcome To Secured Income Group");
        softAssert.assertAll();
    }
}
