package create.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step4Account {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step4Account(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Review Checkbox")
    @FindBy(xpath = "//input[@value='no']//following-sibling::span[2]")
    private HtmlElement knowledgeNo;

    public void checkedKnowledgeNo() {
        knowledgeNo.click();
    }

    @Name("Review Checkbox")
    @FindBy(xpath = "//input[@id='approve-check1']//following-sibling::span[2]")
    private HtmlElement checkboxReview;

    public void checkedCheckboxReview() {
        checkboxReview.click();
    }

    @Name("Taxpayer Checkbox")
    @FindBy(xpath = "//input[@id='approve-check2']//following-sibling::span[2]")
    private HtmlElement checkboxTaxpayer;

    public void checkedCheckboxTaxpayer() {
        checkboxTaxpayer.click();
    }

    @Name("Electronic Checkbox")
    @FindBy(xpath = "//input[@id='approve-check3']//following-sibling::span[2]")
    private HtmlElement checkboxElectronic;

    public void checkedCheckboxElectronic() {
        checkboxElectronic.click();
    }

    @Name("Investor Signature")
    @FindBy(id = "signature")
    private TextInput signature;

    public void enterSignature(String value) {
        signature.sendKeys(value);
    }

    @Name("Cancel Button")
    @FindBy(xpath = "//a[text()='cancel']")
    private Button cancelButton;

    public UserAccounts clickCancelButton() {
        cancelButton.click();
        return new UserAccounts(driver);
    }

    @Name("Save Button")
    @FindBy(css = "input[value='Finish']")
    private Button finishButton;

    public UserAccounts clickFinishButton() {
        finishButton.click();
        return new UserAccounts(driver);
    }

    public void agreeAll(String signature) {
        checkedCheckboxReview();
        checkedCheckboxTaxpayer();
        checkedCheckboxElectronic();
        enterSignature(signature);
    }


}
