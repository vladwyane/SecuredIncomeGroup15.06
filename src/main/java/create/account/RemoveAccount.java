package create.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class RemoveAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public RemoveAccount(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Admin Select Month")
    @FindBy(id = "mm")
    private Select adminSelectMonth;

    public void chooseAdminSelectNovMonth(String month) {
        adminSelectMonth.selectByValue(month);
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

    public void changeYearPublish(String month, String year) throws InterruptedException {
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        driver.findElement(By.id("menu-posts-investment")).click();
        driver.findElements(By.cssSelector(".row-title")).get(0).click();
        driver.findElement(By.xpath("//*[contains(@class, 'edit-timestamp')]")).click();
        chooseAdminSelectNovMonth(month);
        driver.findElement(By.id("aa")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("aa")).sendKeys(year);
        driver.findElement(By.id("publish")).click();
        Thread.sleep(5000);

    }

}
