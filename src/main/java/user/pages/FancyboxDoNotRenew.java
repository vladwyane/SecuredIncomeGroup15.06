package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class FancyboxDoNotRenew {

    private WebDriver driver;
    private WebDriverWait wait;

    public FancyboxDoNotRenew(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Click to CONFIRM TERMINATION")
    @FindBy(xpath = "//*[contains(text(), 'Click to CONFIRM TERMINATION')]")
    private HtmlElement checkboxConfirmTerminate;

    public void checkedConfirmTerminate() {
        checkboxConfirmTerminate.click();
    }

    @Name("Button Terminate Investment")
    @FindBy(xpath = "//a[contains(text(), 'Terminate Investment')]")
    private Button buttonTermInvest;

    public void clickButtonTermInvest() {
        buttonTermInvest.click();
    }

}
