package create.investment;

import create.account.Step3Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class Step2Invest {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step2Invest(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("ROLLOVER Dividends")
    @FindBy(xpath = "//input[@value='Rollover']//following-sibling::span[2]")
    private HtmlElement rolloverDividends;

    public void checkedRolloverDividends() {
        rolloverDividends.click();
    }

    @Name("PAYOUT Dividends")
    @FindBy(xpath = "//input[@value='Payout']//following-sibling::span[2]")
    private HtmlElement payoutDividends;

    public void checkedPayoutDividends() {
        payoutDividends.click();
    }

    @Name("Dividend Checkbox Use Same Address")
    @FindBy(xpath = "//input[@name='dividend_use_address_investor']//following-sibling::span[2]")
    private HtmlElement divCheckboxSameAddress;

    public void checkedDivCheckboxSameAddress() {
        divCheckboxSameAddress.click();
    }

    @Name("Dividend Full Name")
    @FindBy(name = "dividend_full_name")
    private TextInput divFullName;

    public void enterDivFullName(String adress) {
        divFullName.sendKeys(adress);
    }

    public String getDivFullName() {
        return divFullName.getEnteredText();
    }

    @Name("Dividend Secondary Address")
    @FindBy(name = "dividend_trust_name")
    private TextInput divSecondaryAddress;

    public void enterDivSecondaryAddress(String adress) {
        divSecondaryAddress.sendKeys(adress);
    }

    public String getDivSecondaryAddress() {
        return divSecondaryAddress.getEnteredText();
    }

    @Name("Dividend Street Address")
    @FindBy(name = "dividend_street_address")
    private TextInput divStreetAdress;

    public void enterDivStreetAddress(String adress) {
        divStreetAdress.sendKeys(adress);
    }

    public String getDivStreetAddress() {
        return divStreetAdress.getEnteredText();
    }

    @Name("Dividend Country Select")
    @FindBy(xpath = "//select[@name='dividend_country']/following-sibling::span")
    private HtmlElement divCountrySelect;

    @Name("Dividend Country Canada")
    @FindBy(xpath = "(//span[contains(text(), 'Canada')])[2]")
    private HtmlElement divCountryCanada;

    public void chooseDivCountryCanada() {
        divCountrySelect.click();
        divCountryCanada.click();
    }

    @Name("Dividend United States")
    @FindBy(xpath = "//span[@class='jcf-option' and contains(text(), 'United States')]")
    private HtmlElement divCountryUS;

    public void chooseDivCountryUS() {
        divCountrySelect.click();
        divCountryUS.click();
    }

    @Name("Dividend City")
    @FindBy(name = "dividend_city")
    private TextInput divCity;

    public void enterDivCity(String value) {
        divCity.sendKeys(value);
    }

    public String getDivCity() {
        return divCity.getEnteredText();
    }

    @Name("Dividend State Province")
    @FindBy(xpath = "//select[@name='dividend_state_province']/following-sibling::span")
    private HtmlElement divStateSelect;

    @Name("Dividend Province Alberta")
    @FindBy(xpath = "(//span[contains(text(), 'Alberta')])[2]")
    private HtmlElement divProvinceAlberta;

    public void chooseDivProvinceAlberta() {
        divStateSelect.click();
        divProvinceAlberta.click();
    }

    @Name("Dividend Province Yukon")
    @FindBy(xpath = "(//span[contains(text(), 'Yukon')])[2]")
    private HtmlElement divProvinceYukon;

    public void chooseDivProvinceYukon() {
        divStateSelect.click();
        divProvinceYukon.click();
    }

    @Name("Dividend State Nevada")
    @FindBy(xpath = "//span[@class='jcf-option' and contains(text(), 'Nevada')]")
    private HtmlElement divStateNevada;

    public void chooseDivStateNevada() {
        divStateSelect.click();
        divStateNevada.click();
    }

    @Name("Dividend State Alabama")
    @FindBy(xpath = "//span[contains(text(), 'Alabama')]")
    private HtmlElement divStateAlabama;

    public void chooseDivStateAlabama() {
        divStateSelect.click();
        divStateAlabama.click();
    }

    @Name("Dividend Postal Code")
    @FindBy(name = "dividend_postal_code")
    private TextInput divPostalCode;

    public void enterDivPostalCode(String value) {
        divPostalCode.clear();
        divPostalCode.sendKeys(value);
    }

    @Name("Cancel Button")
    @FindBy(xpath = "//a[text()='cancel']")
    private Button cancelButton;

    public UserAccounts clickCancelButton() {
        cancelButton.click();
        return new UserAccounts(driver);
    }

    @Name("Save Button")
    @FindBy(css = "input[type='submit']")
    private Button saveButton;

    public Step3Account clickSaveButton() {
        saveButton.click();
        return new Step3Account(driver);
    }




}
