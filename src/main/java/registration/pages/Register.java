package registration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccount;

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
    private TextInput loginField;

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public String getLoginValue() {
        return loginField.getEnteredText();
    }

    @Name("User Password")
    @FindBy(id = "user_pass")
    private TextInput passwordField;

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
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

    public UserAccount clickSignInButton() {
        signInButton.click();
        return new UserAccount(driver);
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Name("Create Step1 Link")
    @FindBy(xpath = "//*[contains(text(), 'Create Step1')]")
    private Link createAccountLink;

    public CreateAccount createAccountLinkClick() {
        createAccountLink.click();
        return new CreateAccount(driver);
    }

    @Name("Lost Password Link")
    @FindBy(xpath = "//*[contains(text(), 'Reset My Password')]")
    private Link lostPasswordLink;

    public LostPassword lostPasswordLinkClick() {
        lostPasswordLink.click();
        return new LostPassword(driver);
    }


}
