package create.account.step2account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class S2Entity extends S2Individual {

    public S2Entity(WebDriver driver) {
        super(driver);
    }

    @Name("Entity Name")
    @FindBy(name = "entity_name")
    private TextInput entityName;

    public void enterEntityName(String fName) {
        entityName.clear();
        entityName.sendKeys(fName);
    }

    public String getValueEntityName() {
        return entityName.getEnteredText();
    }

    @Name("Entity Position")
    @FindBy(name = "position_title")
    private TextInput positionTitle;

    public void enterPositionTitle(String fName) {
        positionTitle.clear();
        positionTitle.sendKeys(fName);
    }

    public String getValuePositionTitle() {
        return positionTitle.getEnteredText();
    }

    @Name("Entity Type")
    @FindBy(xpath = "//select[@name='entity_type']//following-sibling::span")
    private HtmlElement entityType;

    @Name("Entity Type LLC")
    @FindBy(xpath = "//span[contains(text(), 'LLC')]")
    private HtmlElement entityTypeLLC;

    public void chooseEntityTypeLLC() {
        entityType.click();
        entityTypeLLC.click();
    }

    @Name("Entity Type Corporation")
    @FindBy(xpath = "//span[contains(text(), 'Corporation')]")
    private HtmlElement entityTypeCorporation;

    public void chooseEntityTypeCorporation() {
        entityType.click();
        entityTypeCorporation.click();

    }

    @Name("Tax ID Number")
    @FindBy(id = "tax-number")
    private TextInput taxNumber;

    public void enterTaxNumber(String fName) {
        taxNumber.clear();
        taxNumber.sendKeys(fName);
    }

    public String getValueTaxNumber() {
        return taxNumber.getEnteredText();
    }

    @Name("Entity Checkbox Use Same Address")
    @FindBy(xpath = "//input[@name='use_address_investor']//following-sibling::span[2]")
    private HtmlElement eCheckboxSameAddress;

    public void checkedECheckboxSameAddress() {
        eCheckboxSameAddress.click();
    }

    @Name("Entity Street Address")
    @FindBy(name = "entity_street_address")
    private TextInput eStreetAdress;

    public void enterEStreetAddress(String adress) {
        eStreetAdress.sendKeys(adress);
    }

    public String getEStreetAddress() {
        return eStreetAdress.getEnteredText();
    }

    @Name("Entity Country Select")
    @FindBy(xpath = "//select[@name='entity_country']/following-sibling::span")
    private HtmlElement eCountrySelect;

    @Name("Entity Country Canada")
    @FindBy(xpath = "//span[contains(text(), 'Canada')]")
    private HtmlElement eCountryCanada;

    public void chooseECountryCanada() {
        eCountrySelect.click();
        eCountryCanada.click();
    }

    @Name("Entity United States")
    @FindBy(xpath = "//span[contains(text(), 'United States')]")
    private HtmlElement eCountryUS;

    public void chooseECountryUS() {
        eCountrySelect.click();
        eCountryUS.click();
    }

    @Name("Entity City")
    @FindBy(name = "entity_postal_code")
    private TextInput eCity;

    public void enterECity(String value) {
        eCity.sendKeys(value);
    }

    public String getECity() {
        return eCity.getEnteredText();
    }

    @Name("Entity State Province")
    @FindBy(xpath = "//select[@name='entity_state_province']/following-sibling::span")
    private HtmlElement eStateSelect;

    @Name("Entity Province Alberta")
    @FindBy(xpath = "//span[contains(text(), 'Alberta')]")
    private HtmlElement eProvinceAlberta;

    public void chooseEProvinceAlberta() {
        eStateSelect.click();
        eProvinceAlberta.click();
    }

    @Name("Entity Province Yukon")
    @FindBy(xpath = "//span[contains(text(), 'Yukon')]")
    private HtmlElement eProvinceYukon;

    public void chooseEProvinceYukon() {
        eStateSelect.click();
        eProvinceYukon.click();
    }

    @Name("Entity State Nevada")
    @FindBy(xpath = "//span[contains(text(), 'Nevada')]")
    private HtmlElement eStateNevada;

    public void chooseEStateNevada() {
        eStateSelect.click();
        eStateNevada.click();
    }

    @Name("Entity State Alabama")
    @FindBy(xpath = "//span[contains(text(), 'Alabama')]")
    private HtmlElement eStateAlabama;

    public void chooseEStateAlabama() {
        eStateSelect.click();
        eStateAlabama.click();
    }

    @Name("Entity Postal Code")
    @FindBy(name = "entity_postal_code")
    private TextInput ePostalCode;

    public void enterEPostalCode(String value) {
        ePostalCode.clear();
        ePostalCode.sendKeys(value);
    }

    public String getEPostalCode() {
        return ePostalCode.getEnteredText();
    }

    @Name("Entity Phone Number")
    @FindBy(name = "entity_phone_number")
    private TextInput ePhoneNumber;

    public void enterEPhoneNumber(String value) {
        ePhoneNumber.clear();
        ePhoneNumber.sendKeys(value);
    }

    public String getEPhoneNumber() {
        return ePhoneNumber.getEnteredText();
    }

    @Name("Entity Email Address")
    @FindBy(name = "entity_email_address")
    private TextInput eEmail;

    public void enterEEmail(String value) {
        eEmail.clear();
        eEmail.sendKeys(value);
    }

    public String getEEmail() {
        return eEmail.getEnteredText();
    }





}
