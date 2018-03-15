package create.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class RemoveAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public RemoveAccount(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    public void removeNAccounts(int count) {
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        driver.findElement(By.id("menu-posts-account")).click();
        for (int i = 0; i < count; i++) {
            driver.findElements(By.cssSelector("#the-list tr")).get(0).click();
            driver.findElements(By.cssSelector(".trash")).get(1).click();
        }
        driver.findElement(By.cssSelector(".subsubsub .trash")).click();
        for (int i = 0; i < count; i++) {
            driver.findElements(By.cssSelector("#the-list tr")).get(0).click();
            driver.findElements(By.cssSelector(".delete")).get(0).click();
        }
    }

}
