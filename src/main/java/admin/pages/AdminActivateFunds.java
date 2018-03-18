package admin.pages;

import create.account.Step3Account;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AdminActivateFunds {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminActivateFunds(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Enter Investment Number")
    @FindBy(id = "account-number")
    private TextInput accountNumber;

    public void enterAccountNumber(String value) {
        accountNumber.clear();
        accountNumber.sendKeys(value);
    }

    public String getAccountNumber() {
        return accountNumber.getEnteredText();
    }

    @Name("Enter Funds Received")
    @FindBy(id = "fund-amount")
    private TextInput fundAmount;

    public void enterFundAmount(String value) {
        fundAmount.clear();
        fundAmount.sendKeys(value);
    }

    public String getFundAmount() {
        return fundAmount.getEnteredText();
    }

    @Name("Enter Funding Date")
    @FindBy(name = "fund_date")
    private TextInput fundDate;

    public void enterFundDate(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('fund_date')[0].value='" + date + "'");
    }

    @Name("Submit Button")
    @FindBy(xpath = "//input[@value='Submit']")
    private Button submitButton;

    public FancyBox clickSubmitButton() {
        submitButton.click();
        return new FancyBox(driver);
    }

}
