package test.base;

import create.account.step2account.S2Individual;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.BrowserType;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import test.base.data.Users;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SoftAssert sAssert() {
        return softAssert;
    }

    public static String securUrl = "http://securedincomegroup.stgng.co";
    public static String testEmail = "vladwyane@gmail.com";
    public static String correctPassword = "V123456789ch";

    public void goTo(String url) {
        driver.get(url);
    }

    public void setup() {
        if (browser.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
        } else if (browser.equals(BrowserType.IE)) {
            WebDriverManager.iedriver().setup();
        } else if (browser.equals(BrowserType.EDGE)) {
            WebDriverManager.edgedriver().setup();
        }
    }

    public void unit() {
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        softAssert = new SoftAssert();

    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String checkGoogleMail() throws InterruptedException {
        goTo("http://mail.google.com");
        driver.findElement(By.cssSelector("[name='identifier']")).sendKeys("vladwyane@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("rdf49dw07");
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(3000);
        String boldHeading = driver.findElements(By.cssSelector("div span b")).get(0).getText();

        return  boldHeading;
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
