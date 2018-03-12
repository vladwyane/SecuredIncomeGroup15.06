package create.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class StepsBarAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public StepsBarAccount(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Active Item")
    @FindBy(css = ".steps-bar .active a")
    private Link activeItem;

    public String getActiveItem() {
        return activeItem.getText();
    }
}
