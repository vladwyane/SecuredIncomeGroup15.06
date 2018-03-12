package create.account;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Step2Account {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step2Account(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("First Name")
    @FindBy(id = "first-name")
    private TextInput firstName;

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public String getValueFirstName() {
        return firstName.getEnteredText();
    }

    @Name("Last Name")
    @FindBy(id = "last-name")
    private TextInput lastName;

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public String getValueLastName() {
        return lastName.getEnteredText();
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
        sSN.sendKeys(number);
    }

    public String getValueSSN() {
        return sSN.getEnteredText();
    }

    @Name("Citizenship US Citizen")
    @FindBy(xpath = "//span[text()='US Citizen']")
    private HtmlElement citizenUS;

    public void checkedCitizenUS() {
        citizenUS.click();
    }

    @Name("Foreign National")
    @FindBy(xpath = "//span[text()='Foreign National']")
    private HtmlElement citizenFN;

    public void checkedCitizenFN() {
        citizenFN.click();
    }

    @Name("Street Address")
    @FindBy(id = "street-address")
    private TextInput streetAdress;

    public void enterStreetAddress(String adress) {
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







}

