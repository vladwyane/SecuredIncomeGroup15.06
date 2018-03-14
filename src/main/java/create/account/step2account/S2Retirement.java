package create.account.step2account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class S2Retirement extends S2Individual {

    public S2Retirement(WebDriver driver) {
        super(driver);
    }

    @Name("Retirement Type")
    @FindBy(xpath = "//select[@name='retirement_account_type']/following-sibling::span")
    private HtmlElement retirementType;

    @Name("IRA")
    @FindBy(xpath = "//span[contains(text(), 'IRA')]")
    private HtmlElement typeIRA;

    public void chooseTypeIRA() {
        retirementType.click();
        typeIRA.click();
    }

    @Name("Simple IRA")
    @FindBy(xpath = "//span[contains(text(), 'Simple IRA')]")
    private HtmlElement typeSimpleIRA;

    public void chooseTypeSimpleIRA() {
        retirementType.click();
        typeSimpleIRA.click();
    }

    @Name("403(b)")
    @FindBy(xpath = "//span[contains(text(), '403(b)')]")
    private HtmlElement type403b;

    public void chooseType403b() {
        retirementType.click();
        type403b.click();
    }

    @Name("Retirement Custodian Name")
    @FindBy(name = "retirement_custodian_name")
    private TextInput retireCustodianName;

    public void enterRetireCustodianName(String adress) {
        retireCustodianName.sendKeys(adress);
    }

    public String getRetireCustodianName() {
        return retireCustodianName.getEnteredText();
    }

    @Name("Retirement Custodian Street Address")
    @FindBy(name = "retirement_custodian_street_address")
    private TextInput retirementStreetAddress;

    public void enterRetirementStreetAddress(String adress) {
        retirementStreetAddress.sendKeys(adress);
    }

    public String getRetirementStreetAddress() {
        return retirementStreetAddress.getEnteredText();
    }

    @Name("Retirement Country Select")
    @FindBy(xpath = "//select[@name='retirement_custodian_country']//following-sibling::span")
    private HtmlElement retCountrySelect;

    @Name("Retirement Country Canada")
    @FindBy(xpath = "//span[contains(text(), 'Canada')]")
    private HtmlElement retCountryCanada;

    public void chooseRetCountryCanada() {
        retCountrySelect.click();
        retCountryCanada.click();
    }

    @Name("Retirement United States")
    @FindBy(xpath = "//span[contains(text(), 'United States')]")
    private HtmlElement retCountryUS;

    public void chooseRetCountryUS() {
        retCountrySelect.click();
        retCountryUS.click();
    }

    @Name("Retirement City")
    @FindBy(name = "retirement_custodian_city")
    private TextInput retCity;

    public void enterRetCity(String value) {
        retCity.sendKeys(value);
    }

    public String getRetCity() {
        return retCity.getEnteredText();
    }

    @Name("Retirement State Province")
    @FindBy(xpath = "//select[@name='retirement_custodian_state_province']//following-sibling::span")
    private HtmlElement retStateSelect;

    @Name("Retirement Province Alberta")
    @FindBy(xpath = "//span[contains(text(), 'Alberta')]")
    private HtmlElement retProvinceAlberta;

    public void chooseRetProvinceAlberta() {
        retStateSelect.click();
        retProvinceAlberta.click();
    }

    @Name("Retirement Province Yukon")
    @FindBy(xpath = "//span[contains(text(), 'Yukon')]")
    private HtmlElement retProvinceYukon;

    public void chooseRetProvinceYukon() {
        retStateSelect.click();
        retProvinceYukon.click();
    }

    @Name("Retirement State Nevada")
    @FindBy(xpath = "//span[contains(text(), 'Nevada')]")
    private HtmlElement retStateNevada;

    public void chooseRetStateNevada() {
        retStateSelect.click();
        retStateNevada.click();
    }

    @Name("Retirement State Alabama")
    @FindBy(xpath = "//span[contains(text(), 'Alabama')]")
    private HtmlElement retStateAlabama;

    public void chooseRetStateAlabama() {
        retStateSelect.click();
        retStateAlabama.click();
    }

    @Name("Retirement Postal Code")
    @FindBy(name = "retirement_custodian_postal_code")
    private TextInput retPostalCode;

    public void enterRetPostalCode(String value) {
        retPostalCode.clear();
        retPostalCode.sendKeys(value);
    }

    public String getRetPostalCode() {
        return retPostalCode.getEnteredText();
    }

    @Name("Retirement Phone Number")
    @FindBy(name = "retirement_custodian_phone_number")
    private TextInput retPhoneNumber;

    public void enterRetPhoneNumber(String value) {
        retPhoneNumber.clear();
        retPhoneNumber.sendKeys(value);
    }

    public String getRetPhoneNumber() {
        return retPhoneNumber.getEnteredText();
    }

    @Name("Retirement Email Address")
    @FindBy(name = "retirement_custodian_email_address")
    private TextInput retEmail;

    public void enterRetEmail(String value) {
        retEmail.clear();
        retEmail.sendKeys(value);
    }

    public String getRetEmail() {
        return retEmail.getEnteredText();
    }





}
