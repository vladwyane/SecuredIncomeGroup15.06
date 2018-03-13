package create.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step3Account {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step3Account(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Cancel Button")
    @FindBy(xpath = "//a[text()='cancel']")
    private Button cancelButton;

    public UserAccounts clickCancelButton() {
        cancelButton.click();
        return new UserAccounts(driver);
    }

    @Name("Confirm & Continue Button")
    @FindBy(css = "input[value='Confirm & Continue']")
    private Button confirmButton;

    public Step4Account clickConfirmButton() {
        confirmButton.click();
        return new Step4Account(driver);
    }
}
