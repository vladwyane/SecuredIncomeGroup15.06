package common.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class PageHeading {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageHeading(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Profile Link")
    @FindBy(xpath = "//*[@class='page-heading']//a[contains(text(), 'Profile')]")
    private Link profile;

    public void clickLinkProfile() {
        profile.click();
    }
}
