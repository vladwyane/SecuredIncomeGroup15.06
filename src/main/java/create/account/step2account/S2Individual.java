package create.account.step2account;

import create.account.Step3Account;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class S2Individual {

    public WebDriver driver;
    private WebDriverWait wait;

    public S2Individual(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("First Name")
    @FindBy(id = "first-name")
    private TextInput firstName;

    public void enterFirstName(String fName) {
        firstName.clear();
        firstName.sendKeys(fName);
    }

    public String getValueFirstName() {
        return firstName.getEnteredText();
    }

    @Name("Last Name")
    @FindBy(id = "last-name")
    private TextInput jLastName;

    public void enterLastName(String lName) {
        jLastName.clear();
        jLastName.sendKeys(lName);
    }

    public String getValueLastName() {
        return jLastName.getEnteredText();
    }

    @Name("Birth Date")
    @FindBy(id = "date")
    private TextInput birthDate;

    public void enterBirthDate(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('date').value='" + date + "'");
    }

    public String getValueBirthDate() {
        return birthDate.getEnteredText();
    }

    @Name("Social Security Number")
    @FindBy(id = "ssn")
    private TextInput sSN;

    public void enterSSN(String number) {
        sSN.clear();
        sSN.sendKeys(number);
    }

    public String getValueSSN() {
        return sSN.getEnteredText();
    }

    @Name("Citizenship US Citizen")
    @FindBy(xpath = "//div[@id='investor-section']//span[text()='US Citizen']")
    private HtmlElement citizenUS;

    public void checkedCitizenUS() {
        citizenUS.click();
    }

    @Name("Foreign National")
    @FindBy(xpath = "//div[@id='investor-section']//span[text()='Foreign National']")
    private HtmlElement citizenFN;

    public void checkedCitizenFN() {
        citizenFN.click();
    }

    @Name("Street Address")
    @FindBy(id = "street-address")
    private TextInput streetAdress;

    public void enterStreetAddress(String adress) {
        streetAdress.clear();
        streetAdress.sendKeys(adress);
    }

    public String getStreetAddress() {
        return streetAdress.getEnteredText();
    }

    @Name("Country Select")
    @FindBy(xpath = "//div[@id='investor-section']//span[contains(@class, 'country-select')]")
    private HtmlElement countrySelect;

    @Name("Country Canada")
    @FindBy(xpath = "//span[contains(text(), 'Canada')]")
    private HtmlElement countryCanada;

    public void chooseCountryCanada() {
        countrySelect.click();
        countryCanada.click();
    }

    @Name("United States")
    @FindBy(xpath = "//span[contains(text(), 'United States')]")
    private HtmlElement countryUS;

    public void chooseCountryUS() {
        countrySelect.click();
        countryUS.click();
    }

    @Name("City")
    @FindBy(id = "city")
    private TextInput city;

    public void enterCity(String value) {
        city.clear();
        city.sendKeys(value);
    }

    public String getCity() {
        return city.getEnteredText();
    }

    @Name("State Province")
    @FindBy(xpath = "//div[@id='investor-section']//select[@id='state']/following-sibling::span")
    private HtmlElement stateSelect;

    @Name("Province Alberta")
    @FindBy(xpath = "//span[contains(text(), 'Alberta')]")
    private HtmlElement provinceAlberta;

    public void chooseProvinceAlberta() {
        stateSelect.click();
        provinceAlberta.click();
    }

    @Name("Province Yukon")
    @FindBy(xpath = "//span[contains(text(), 'Yukon')]")
    private HtmlElement provinceYukon;

    public void chooseProvinceYukon() {
        stateSelect.click();
        provinceYukon.click();
    }

    @Name("State Nevada")
    @FindBy(xpath = "//span[contains(text(), 'Nevada')]")
    private HtmlElement stateNevada;

    public void chooseStateNevada() {
        stateSelect.click();
        stateNevada.click();
    }

    @Name("State Alabama")
    @FindBy(xpath = "//span[contains(text(), 'Alabama')]")
    private HtmlElement stateAlabama;

    public void chooseStateAlabama() {
        stateSelect.click();
        stateAlabama.click();
    }

    @Name("Postal Code")
    @FindBy(id = "code")
    private TextInput postalCode;

    public void enterPostalCode(String value) {
        postalCode.clear();
        postalCode.sendKeys(value);
    }

    public String getPostalCode() {
        return postalCode.getEnteredText();
    }

    @Name("Phone Number")
    @FindBy(id = "tel")
    private TextInput phoneNumber;

    public void enterPhoneNumber(String value) {
        phoneNumber.clear();
        phoneNumber.sendKeys(value);
    }

    public String getPhoneNumber() {
        return phoneNumber.getEnteredText();
    }

    @Name("Email Address")
    @FindBy(id = "email-address")
    private TextInput email;

    public void enterEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public String getEmail() {
        return email.getEnteredText();
    }

    @Name("Financial Status 1 Million")
    @FindBy(xpath = "//input[@value='1 million']//following-sibling::span[2]")
    private HtmlElement finStatus1Mil;

    public void checkedFinStatus1Mil() {
        finStatus1Mil.click();
    }

    @Name("Financial Status 20000")
    @FindBy(xpath = "//input[@value='20000']//following-sibling::span[2]")
    private HtmlElement finStatus20000;

    public void checkedFinStatus20000() {
        finStatus20000.click();
    }

    @Name("Financial Status 30000")
    @FindBy(xpath = "//input[@value='30000']//following-sibling::span[2]")
    private HtmlElement finStatus30000;

    public void checkedFinStatus30000() {
        finStatus30000.click();
    }

    @Name("Financial Status Any of the above")
    @FindBy(xpath = "//input[@value='any of the above']//following-sibling::span[2]")
    private HtmlElement finStatusAny;

    public void checkedFinStatusAny() {
        finStatusAny.click();
    }

    @Name("Knowledge No")
    @FindBy(xpath = "//input[@value='no']//following-sibling::span[2]")
    private HtmlElement knowledgeNo;

    public void checkedKnowledgeNo() {
        knowledgeNo.click();
    }

    @Name("Knowledge Yes")
    @FindBy(xpath = "//input[@value='yes']//following-sibling::span[2]")
    private HtmlElement knowledgeYes;

    public void checkedKnowledgeYes() {
        knowledgeYes.click();
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

