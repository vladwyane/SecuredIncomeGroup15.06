package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class UserAccounts {

    private WebDriver driver;
    private WebDriverWait wait;

    public UserAccounts(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Sidebar Heading")
    @FindBy(xpath = "//h3[contains(text(), 'New Account')]")
    private HtmlElement headingSidebar;

    public String getHeadingSidebar() {
        return headingSidebar.getText();
    }

    @Name("Open Account Link")
    @FindBy(css = ".link-open")
    private Link openAccountLink;

    public void clickOpenAccountLink() {
        openAccountLink.click();
    }

    @Name("Account Type")
    @FindBy(xpath = "(//*[@class='account-type'])[1]")
    private HtmlElement accountType;

    public String getAccountType() {
        return accountType.getText();
    }

    @Name("Account Name")
    @FindBy(xpath = "(//*[@class='name']//a)[1]")
    private Link accountName;

    public String getAccountName() {
        return accountName.getText();
    }

}
