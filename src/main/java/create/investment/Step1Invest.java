package create.investment;

import create.account.step2account.S2Individual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step1Invest {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step1Invest(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Investment Term Select")
    @FindBy(xpath = "//select[@name='inv_product_type']/following-sibling::span")
    private HtmlElement investmentTermSelect;

    @Name("Investment 3 month")
    @FindBy(xpath = "(//span[contains(text(), '3 month')])[1]")
    private HtmlElement investment3Month;

    public void chooseInvestment3Month() {
        investmentTermSelect.click();
        investment3Month.click();
    }

    @Name("Investment 6 month")
    @FindBy(xpath = "(//span[contains(text(), '6 month')])[1]")
    private HtmlElement investment6Month;

    public void chooseInvestment6Month() {
        investmentTermSelect.click();
        investment6Month.click();
    }

    @Name("Investment 9 month")
    @FindBy(xpath = "(//span[contains(text(), '6 month')])[1]")
    private HtmlElement investment9Month;

    public void chooseInvestment9Month() {
        investmentTermSelect.click();
        investment6Month.click();
    }

    @Name("Investment 1 year")
    @FindBy(xpath = "(//span[contains(text(), '1 year')])[1]")
    private HtmlElement investment1Year;

    public void chooseInvestment1Year() {
        investmentTermSelect.click();
        investment1Year.click();
    }

    @Name("Investment 1.5 year")
    @FindBy(xpath = "(//span[contains(text(), '1.5 year')])[1]")
    private HtmlElement investment1AndHalfYear;

    public void chooseInvestment1AndHalfYear() {
        investmentTermSelect.click();
        investment1AndHalfYear.click();
    }

    @Name("Investment 3 year")
    @FindBy(xpath = "(//span[contains(text(), '3 year')])[1]")
    private HtmlElement investment3Year;

    public void chooseInvestment3Year() {
        investmentTermSelect.click();
        investment3Year.click();
    }

    @Name("Investment Amount")
    @FindBy(name = "inv_amount")
    private TextInput investmentAmount;

    public void enterInvestmentAmount(String value) {
        investmentAmount.clear();
        investmentAmount.sendKeys(value);
    }

    public String getInvestmentAmount() {
        return investmentAmount.getEnteredText();
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

    public Step2Invest clickSaveButton() {
        saveButton.click();
        return new Step2Invest(driver);
    }

    @Name("Error Message")
    @FindBy(css = ".error-text p")
    private HtmlElement errorMessage;

    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }
}
