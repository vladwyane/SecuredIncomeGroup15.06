package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Name("Register")
@Block(@FindBy(xpath = "//body[contains(@class, 'login')]"))
public class Register extends HtmlElement {

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

    public Register clickSignInButton() {
        signInButton.click();
        return this;
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
