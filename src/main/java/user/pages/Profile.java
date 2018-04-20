package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import registration.pages.Register;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Profile {

    private WebDriver driver;
    private WebDriverWait wait;

    public Profile(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("User Email")
    @FindBy(id = "email-address")
    private HtmlElement emailField;

    public void enterEmail(String login) {
        emailField.sendKeys(login);
    }

    public String getEmailValue() {
        return emailField.getText();
    }

    @Name("User Password")
    @FindBy(id = "password")
    private HtmlElement passwordField;

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordValue() {
        return passwordField.getText();
    }

    @Name("Update User Button")
    @FindBy(id = "updateuser")
    private Button updateUserButton;

    public void clickUpdateUserButton() {
        updateUserButton.click();
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
    @FindBy(xpath = "//span[contains(@class, 'country-select')]")
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
    @FindBy(xpath = "//select[@id='state']/following-sibling::span")
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

    @Name("Update Form Button")
    @FindBy(xpath = "//form[contains(@class, 'steps-form')]//input[@value='Update']")
    private Button updateFormButton;

    public void clickUpdateFormButton() {
        updateFormButton.click();
    }

    @Name("Cancel Form Button")
    @FindBy(xpath = "//form[contains(@class, 'steps-form')]//input[@value='cancel']")
    private Button cancelFormButton;

    public void clickCancelFormButton() {
        cancelFormButton.click();
    }

}
