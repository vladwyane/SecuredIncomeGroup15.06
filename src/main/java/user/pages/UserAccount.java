package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class UserAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public UserAccount(WebDriver driver) {
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

}
