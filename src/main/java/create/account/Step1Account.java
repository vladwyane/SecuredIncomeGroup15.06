package create.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import registration.pages.CreateAccount;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step1Account {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step1Account(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Main Heading")
    @FindBy(xpath = "//*[contains(text(), 'Account Information')]")
    private HtmlElement mainHeading;

    public String getMainHeading() {
        return mainHeading.getText();
    }

    @Name("Account Type Select")
    @FindBy(css = ".jcf-select")
    private HtmlElement accountTypeSelect;

    @Name("Individual Account")
    @FindBy(xpath = "//span[@data-index='1']")
    private HtmlElement accountIndividual;

    public void chooseAccountIndividual() {
        accountTypeSelect.click();
        accountIndividual.click();
    }

    @Name("Joint Account")
    @FindBy(xpath = "//span[@data-index='2']")
    private HtmlElement accountJoint;

    public void chooseAccountJoint() {
        accountTypeSelect.click();
        accountJoint.click();
    }

    @Name("Joint Retirement")
    @FindBy(xpath = "//span[@data-index='3']")
    private HtmlElement accountRetirement;

    public void chooseAccountRetirement() {
        accountTypeSelect.click();
        accountRetirement.click();
    }

    @Name("Joint Trust")
    @FindBy(xpath = "//span[@data-index='4']")
    private HtmlElement accountTrust;

    public void chooseAccountTrust() {
        accountTypeSelect.click();
        accountTrust.click();
    }

    @Name("Joint Entity")
    @FindBy(xpath = "//span[@data-index='5']")
    private HtmlElement accountEntity;

    public void chooseAccountEntity() {
        accountTypeSelect.click();
        accountEntity.click();
    }

    @Name("Cancel Button")
    @FindBy(xpath = "//a[text()='cancel']")
    private Button cancelButton;

    public UserAccounts clickCancelButton() {
        cancelButton.click();
        return new UserAccounts(driver);
    }

    @Name("Save Button")
    @FindBy(css = "input[value='Save & Continue']")
    private Button saveButton;

    public Step2Account clickSaveButton() {
        saveButton.click();
        return new Step2Account(driver);
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }


}
