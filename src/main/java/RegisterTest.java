import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import registration.Register;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

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
        driver.get("http://securedincomegroup.stgng.co");
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
    public void testErrorLogin() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin("error");
        register.enterPassword("v123ch");
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "We don't have any users with that email address. Maybe you used a different one when signing up?");
        softAssert.assertAll();
    }

    @Test
    public void testErrorPassword() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin("dwyane@i.ua");
        register.enterPassword("v123ch");
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "The password you entered wasn't quite right. Did you forget your password?");
        softAssert.assertAll();
    }

    @Test
    public void testErrorEmpty() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin(" ");
        register.enterPassword(" ");
        register.clickSignInButton();
        Thread.sleep(2000);
        softAssert.assertEquals(register.getErrorMessage(), "You do have an email address, right?");
        softAssert.assertAll();
    }

    @Test
    public void testClearButton() throws InterruptedException {
        Register register = new Register(driver);
        register.enterLogin("error");
        register.clickCancelButton();
        softAssert.assertEquals(register.getLoginValue(), "");
        softAssert.assertAll();
    }






}
