package create.account.step2account;

import create.account.Step3Account;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import user.pages.UserAccounts;

public class S2Joint extends S2Individual{

    public S2Joint(WebDriver driver) {
        super(driver);
    }

    @Name("Joint First Name")
    @FindBy(name = "joint_first_name")
    private TextInput jFirstName;

    public void enterJFirstName(String fName) {
        jFirstName.clear();
        jFirstName.sendKeys(fName);
    }

    public String getValueJFirstName() {
        return jFirstName.getEnteredText();
    }

    @Name("Joint Last Name")
    @FindBy(name = "joint_last_name")
    private TextInput jLastName;

    public void enterJLastName(String lName) {
        jLastName.clear();
        jLastName.sendKeys(lName);
    }

    public String getValueJLastName() {
        return jLastName.getEnteredText();
    }

    @Name("Joint Birth Date")
    @FindBy(name = "joint_birth_date")
    private TextInput jBirthDate;

    public void enterJBirthDate(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('joint_birth_date')[0].value='" + date + "'");
    }

    public String getValueJBirthDate() {
        return jBirthDate.getEnteredText();
    }

    @Name("Joint Social Security Number")
    @FindBy(id = "number2")
    private TextInput jSSN;

    public void enterJSSN(String number) {
        jSSN.sendKeys(number);
    }

    public String getValueJSSN() {
        return jSSN.getEnteredText();
    }

    @Name("Joint Citizenship US Citizen")
    @FindBy(xpath = "//div[@id='joint-section']//span[text()='US Citizen']")
    private HtmlElement jCitizenUS;

    public void checkedJCitizenUS() {
        jCitizenUS.click();
    }

    @Name("Joint Foreign National")
    @FindBy(xpath = "//div[@id='joint-section']//span[text()='Foreign National']")
    private HtmlElement jCitizenFN;

    public void checkedJCitizenFN() {
        jCitizenFN.click();
    }

    @Name("Joint Checkbox Use Same Address")
    @FindBy(xpath = "//input[@name='joint_use_address_investor']//following-sibling::span[2]")
    private HtmlElement jCheckboxSameAddress;

    public void checkedJCheckboxSameAddress() {
        jCheckboxSameAddress.click();
    }

    @Name("Joint Street Address")
    @FindBy(name = "joint_street_address")
    private TextInput jStreetAdress;

    public void enterJStreetAddress(String adress) {
        jStreetAdress.sendKeys(adress);
    }

    public String getJStreetAddress() {
        return jStreetAdress.getEnteredText();
    }

    @Name("Joint Country Select")
    @FindBy(xpath = "//div[@id='joint-section']//span[contains(@class, 'country-select')]")
    private HtmlElement jCountrySelect;

    @Name("Joint Country Canada")
    @FindBy(xpath = "//span[contains(text(), 'Canada')]")
    private HtmlElement jCountryCanada;

    public void chooseJCountryCanada() {
        jCountrySelect.click();
        jCountryCanada.click();
    }

    @Name("Joint United States")
    @FindBy(xpath = "//span[contains(text(), 'United States')]")
    private HtmlElement jCountryUS;

    public void chooseJCountryUS() {
        jCountrySelect.click();
        jCountryUS.click();
    }

    @Name("Joint City")
    @FindBy(name = "joint_city")
    private TextInput jCity;

    public void enterJCity(String value) {
        jCity.sendKeys(value);
    }

    public String getJCity() {
        return jCity.getEnteredText();
    }

    @Name("Joint State Province")
    @FindBy(xpath = "//div[@id='joint-section']//select[@id='state2']/following-sibling::span")
    private HtmlElement jStateSelect;

    @Name("Joint Province Alberta")
    @FindBy(xpath = "//span[contains(text(), 'Alberta')]")
    private HtmlElement jProvinceAlberta;

    public void chooseJProvinceAlberta() {
        jStateSelect.click();
        jProvinceAlberta.click();
    }

    @Name("Joint Province Yukon")
    @FindBy(xpath = "//span[contains(text(), 'Yukon')]")
    private HtmlElement jProvinceYukon;

    public void chooseJProvinceYukon() {
        jStateSelect.click();
        jProvinceYukon.click();
    }

    @Name("Joint State Nevada")
    @FindBy(xpath = "//span[contains(text(), 'Nevada')]")
    private HtmlElement jStateNevada;

    public void chooseJStateNevada() {
        jStateSelect.click();
        jStateNevada.click();
    }

    @Name("Joint State Alabama")
    @FindBy(xpath = "//span[contains(text(), 'Alabama')]")
    private HtmlElement jStateAlabama;

    public void chooseJStateAlabama() {
        jStateSelect.click();
        jStateAlabama.click();
    }

    @Name("Joint Postal Code")
    @FindBy(name = "joint_postal_code")
    private TextInput jPostalCode;

    public void enterJPostalCode(String value) {
        jPostalCode.clear();
        jPostalCode.sendKeys(value);
    }

    public String getJPostalCode() {
        return jPostalCode.getEnteredText();
    }

    @Name("Joint Phone Number")
    @FindBy(name = "joint_phone_number")
    private TextInput jPhoneNumber;

    public void enterJPhoneNumber(String value) {
        jPhoneNumber.clear();
        jPhoneNumber.sendKeys(value);
    }

    public String getJPhoneNumber() {
        return jPhoneNumber.getEnteredText();
    }

    @Name("Joint Email Address")
    @FindBy(name = "joint_email_address")
    private TextInput jEmail;

    public void enterJEmail(String value) {
        jEmail.clear();
        jEmail.sendKeys(value);
    }

    public String getJEmail() {
        return jEmail.getEnteredText();
    }

    public void fillingJointInformation(String fName, String lName, String birthDate, String SSN,
                                           String sAddress, String city, String pCode, String phNumber, String email ) {
        enterJFirstName(fName);
        enterJLastName(lName);
        enterJBirthDate(birthDate);
        enterJSSN(SSN);
        enterJStreetAddress(sAddress);
        enterJCity(city);
        enterJPostalCode(pCode);
        enterJPhoneNumber(phNumber);
        enterJEmail(email);

    }
}
