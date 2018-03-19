package common.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Header {

    private WebDriver driver;
    private WebDriverWait wait;

    public Header(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Sign Out Link")
    @FindBy(xpath = "//div[@class='top-bar']//a[contains(text(), 'Sign')]")
    private Link linkSign;

    public void clickLinkSign() {
        linkSign.click();
    }
}
