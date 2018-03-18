package create.investment;

import create.account.Step3Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step5Invest {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step5Invest(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Fund by Check Button")
    @FindBy(xpath = "//a[contains(text(), 'Fund by Check')]")
    private Button fundByCheckButton;

    public void clickFundByCheckButton() {
        fundByCheckButton.click();
    }

    @Name("Fund by Wire Button")
    @FindBy(xpath = "//a[contains(text(), 'Fund by Wire')]")
    private Button fundByWireButton;

    public void clickFundByWireButton() {
        fundByWireButton.click();
    }

    @Name("Finish Button")
    @FindBy(xpath = "(//a[text()='Finish'])[1]")
    private Button finishButton;

    public UserAccounts clickFinishButton() {
        finishButton.click();
        return new UserAccounts(driver);
    }

    @Name("My Account Button")
    @FindBy(xpath = "(//a[text()='View MY Account'])[2]")
    private Button myAccountButton;

    public UserAccounts clickMyAccountButton() {
        myAccountButton.click();
        return new UserAccounts(driver);
    }

    @Name("Change to FUnd By Check")
    @FindBy(xpath = "//a[text()='Change to FUnd By Check']")
    private Link changeLink;

    public void clickChangeLink() {
        changeLink.click();
    }

}
