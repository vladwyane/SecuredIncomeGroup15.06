package registration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class LostPassword {

    private WebDriver driver;
    private WebDriverWait wait;

    public LostPassword(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Main Heading")
    @FindBy(xpath = "//*[contains(text(), 'Enter your email')]")
    private HtmlElement mainHeading;

    public String getMainHeading() {
        return mainHeading.getText();
    }


    @Name("Email")
    @FindBy(id = "user_login")
    private HtmlElement userLoginField;

    public String getUserLoginFieldCssValue(String value) {
        return userLoginField.getCssValue(value);
    }

    public void enterUserLogin(String email) {
        userLoginField.sendKeys(email);
    }

    public String getUserLoginValue() {
        return userLoginField.getText();
    }

    @Name("Cancel Button")
    @FindBy(css = "input[value='cancel']")
    private Button cancelButton;

    public LostPassword clickCancelButton() {
        cancelButton.click();
        return this;
    }

    @Name("Reset Password Button")
    @FindBy(css = "input[value='Reset Password']")
    private Button resetPasswordButton;

    public Register clickResetPasswordButton() {
        resetPasswordButton.click();
        return new Register(driver);
    }

}
