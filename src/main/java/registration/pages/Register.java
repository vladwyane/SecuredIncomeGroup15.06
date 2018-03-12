package registration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Register {

    private WebDriver driver;
    private WebDriverWait wait;

    public Register(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("User Login")
    @FindBy(id = "user_login")
    private HtmlElement loginField;

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public String getLoginValue() {
        return loginField.getText();
    }

    public String getLoginFieldCssValue(String value) {
        return loginField.getCssValue(value);
    }

    @Name("User Password")
    @FindBy(id = "user_pass")
    private HtmlElement passwordField;

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordValue() {
        return passwordField.getText();
    }

    public String getPasswordFieldCssValue(String value) {
        return passwordField.getCssValue(value);
    }

    @Name("Cancel Button")
    @FindBy(css = "input[value='cancel']")
    private Button cancelButton;

    public Register clickCancelButton() {
        cancelButton.click();
        return this;
    }

    @Name("Sign In Button")
    @FindBy(css = "input[value='sign in']")
    private Button signInButton;

    public UserAccounts clickSignInButton() {
        signInButton.click();
        return new UserAccounts(driver);
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Name("Create Account Link")
    @FindBy(xpath = "//*[contains(text(), 'Create Account')]")
    private Link createAccountLink;

    public CreateAccount clickCreateAccountLink() {
        createAccountLink.click();
        return new CreateAccount(driver);
    }

    public String getCreateAccountLinkValue() {
        return createAccountLink.getText();
    }

    @Name("Lost Password Link")
    @FindBy(xpath = "//*[contains(text(), 'Reset My Password')]")
    private Link lostPasswordLink;

    public LostPassword clickLostPasswordLink() {
        lostPasswordLink.click();
        return new LostPassword(driver);
    }

    public UserAccounts signIn(String email, String password) {
        enterLogin(email);
        enterPassword(password);
        clickSignInButton();
        return new UserAccounts(driver);
    }
}
