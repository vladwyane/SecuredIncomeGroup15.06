package common.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class TestData {

    private WebDriver driver;
    private WebDriverWait wait;

    public TestData(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    public static String securUrl = "http://securedincomegroup.stgng.co";
    public static String testEmail = "vladwyane@gmail.com";
    public static String correctPassword = "V123456789ch";

    public String checkGoogleMail() throws InterruptedException {
        driver.get("http://mail.google.com");
        driver.findElement(By.cssSelector("[name='identifier']")).sendKeys("vladwyane@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("rdf49dw07");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
        Thread.sleep(3000);
        String boldHeading = driver.findElements(By.cssSelector("div span b")).get(0).getText();

        return  boldHeading;
    }
}
