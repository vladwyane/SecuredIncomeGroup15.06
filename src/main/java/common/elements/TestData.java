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

    public void testSearch() throws InterruptedException {
      /*  driver.findElement(By.xpath("//a[text()='Create Step1 Now']")).click();
        driver.findElement(By.id("name")).sendKeys("Vladyslav");
        driver.findElement(By.id("last-name")).sendKeys("Chesalov");
        driver.findElement(By.id("email")).sendKeys("vladwyane@gmail.com");
        driver.findElement(By.id("password")).sendKeys("V123456789ch");
        driver.findElement(By.xpath("//div[@class='g-recaptcha']")).click();
        Thread.sleep(10000);
        driver.findElement(By.name("wp-submit")).click();
        Thread.sleep(10000);
        */
        // driver.get("https://accounts.google.com");
        driver.findElement(By.cssSelector("[name='identifier']")).sendKeys("vladwyane@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("rdf49dw07");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
        Thread.sleep(100000);
       // softAssert.assertEquals(driver.findElements(By.cssSelector("div span b")).get(0).getText(), "Welcome To Secured Income Group");
    //    softAssert.assertAll();

    }



}
