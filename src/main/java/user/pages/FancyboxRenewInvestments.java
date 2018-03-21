package user.pages;

import create.investment.Step1Invest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class FancyboxRenewInvestments extends Step1Invest {

    public FancyboxRenewInvestments(WebDriver driver) {
        super(driver);
    }

    @Name("Checkbox Renewal Terms and Conditions")
    @FindBy(xpath = "//*[contains(@id, 'check-renew')]//following-sibling::span[1]")
    private HtmlElement checkboxRenewTerm;

    public void checkedCheckboxRenewTerm() {
        checkboxRenewTerm.click();
    }

    @Name("Accept Button")
    @FindBy(xpath = "//*[@value='Accept and Re-Invest']")
    private Button acceptButton;

    public void clickAcceptButton() {
        acceptButton.click();
    }

    @Name("Radio Renewal Current Value Plus")
    @FindBy(xpath = "//*[@value='renew_plus']//following-sibling::span[2]")
    private HtmlElement radioRenewCurValPlus;

    public void checkedRadioRenewCurValPlus() {
        radioRenewCurValPlus.click();
    }

    @Name("Field Renewal Current Value Plus")
    @FindBy(name = "renew_plus_value")
    private TextInput fieldRenewCurValPlus;

    public void enterFieldRenewCurValPlus(String value) {
        fieldRenewCurValPlus.clear();
        fieldRenewCurValPlus.sendKeys(value);
    }

    public String getJStreetAddress() {
        return fieldRenewCurValPlus.getEnteredText();
    }

    @Name("Radio Renewal Portion of Investment")
    @FindBy(xpath = "//*[@value='renew_portion']//following-sibling::span[2]")
    private HtmlElement radioRenewPortionInv;

    public void checkedRadioRenewPortionInv() {
        radioRenewPortionInv.click();
    }

    @Name("Field Renewal Portion of Investment")
    @FindBy(name = "renew_portion_value")
    private TextInput fieldRenewPortionInv;

    public void enterFieldRenewPortionInv(String value) {
        fieldRenewPortionInv.clear();
        fieldRenewPortionInv.sendKeys(value);
    }

    public String getFieldRenewPortionInv() {
        return fieldRenewPortionInv.getEnteredText();
}


}
