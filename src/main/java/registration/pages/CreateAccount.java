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

public class CreateAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public CreateAccount(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Main Heading")
    @FindBy(xpath = "//*[text()='Create Your Account']")
    private HtmlElement mainHeading;

    public String getMainHeading() {
        return mainHeading.getText();
    }

    @Name("First Name")
    @FindBy(id = "name")
    private TextInput firstName;

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }


    @Name("Last Name")
    @FindBy(id = "last-name")
    private TextInput lastName;

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    @Name("Email")
    @FindBy(id = "email")
    private HtmlElement emailField;

    public void enterLogin(String email) {
        emailField.sendKeys(email);
    }

    public String getEmailValue() {
        return emailField.getText();
    }

    public String getEmailFieldCssValue(String value) {
        return emailField.getCssValue(value);
    }

    @Name("User Password")
    @FindBy(id = "password")
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

    @Name("Captcha")
    @FindBy(xpath = "//div[@class='g-recaptcha']")
    private Link captcha;

    public CreateAccount clickCaptcha() {
        captcha.click();
        return this;
    }

    @Name("Cancel Button")
    @FindBy(css = "input[value='cancel']")
    private Button cancelButton;

    public CreateAccount clickCancelButton() {
        cancelButton.click();
        return this;
    }

    @Name("Submit Button")
    @FindBy(css = "input[value='submit']")
    private Button submitButton;

    public UserAccount clickSubmitButton() {
        submitButton.click();
        return new UserAccount(driver);
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Name("Sign In Link")
    @FindBy(xpath = "//*[contains(text(), 'Sign in')]")
    private Link signInLink;

    public Register clickSignInLink() {
        signInLink.click();
        return new Register(driver);
    }


}
