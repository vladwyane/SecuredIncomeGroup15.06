package create.account.step2account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class S2Trust extends S2Individual {

    public S2Trust(WebDriver driver) {
        super(driver);
    }

    @Name("Name Of Trust")
    @FindBy(id = "trust-name")
    private TextInput trustName;

    public void enterTrustName(String value) {
        trustName.clear();
        trustName.sendKeys(value);
    }

    public String getTrustName() {
        return trustName.getEnteredText();
    }

    @Name("Radio SSN")
    @FindBy(xpath = "//input[@value='ssn']//following-sibling::span[2]")
    private HtmlElement radioSSN;

    public void checkedRadioSSN() {
        radioSSN.click();
    }
    @Name("Radio TIN")
    @FindBy(xpath = "//input[@value='tin']//following-sibling::span[2]")
    private HtmlElement radioTIN;

    public void checkedRadioTIN() {
        radioTIN.click();
    }

    @Name("Tax Number SSN")
    @FindBy(id = "tax-number-ssn")
    private TextInput taxNumberSSN;

    public void enterTaxNumberSSN(String value) {
        taxNumberSSN.clear();
        taxNumberSSN.sendKeys(value);
    }

    public String getTaxNumberSSN() {
        return taxNumberSSN.getEnteredText();
    }

    @Name("Tax Number TIN")
    @FindBy(id = "tax-number-tin")
    private TextInput taxNumberTIN;

    public void enterTaxNumberTIN(String value) {
        taxNumberTIN.clear();
        taxNumberTIN.sendKeys(value);
    }

    public String getTaxNumberTIN() {
        return taxNumberTIN.getEnteredText();
    }

}
