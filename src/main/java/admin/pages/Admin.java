package admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Admin {

    private WebDriver driver;
    private WebDriverWait wait;

    public Admin(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Admin Memu Item Users")
    @FindBy(id = "menu-users")
    private Link itemMenuUser;

    public void clickItemMenuUser() {
        itemMenuUser.click();
    }

    @Name("WP Admin Bar Link")
    @FindBy(id = "wp-admin-bar-site-name")
    private Link adminBarLink;

    public void clickAdminBarLink() {
        adminBarLink.click();
    }


    @Name("User Serch Input")
    @FindBy(id = "user-search-input")
    private TextInput userSearchInput;

    public void enterUserSearchInput(String userName) {
        userSearchInput.clear();
        userSearchInput.sendKeys(userName);
    }

    public String getUserSearchValue() {
        return userSearchInput.getEnteredText();
    }

    @Name("User Search Button")
    @FindBy(id = "search-submit")
    private Button userSearchButton;

    public void clickUserSearchButton() {
        userSearchButton.click();
    }

    @Name("Edit Users")
    @FindBy(xpath = "(//td[@data-colname='Username']//a)[1]")
    private Link editUserLink;

    public void clickEditUserLink() {
        editUserLink.click();
    }

    @Name("User Street adress Input")
    @FindBy(xpath = "//tr[@data-name='street_address']//input")
    private TextInput userStreetAdress;

    public void enterUserStreetAdress(String adress) {
        userStreetAdress.clear();
        userStreetAdress.sendKeys(adress);
    }

    public String getUserStreetAdress() {
        return userStreetAdress.getEnteredText();
    }

    @Name("User Country Input")
    @FindBy(xpath = "//tr[@data-name='country']//input")
    private TextInput userCountry;

    public void enterUserCountry(String country) {
        userCountry.clear();
        userCountry.sendKeys(country);
    }

    public String getUserCountry() {
        return userCountry.getEnteredText();
    }

    @Name("User Firsts Name Input")
    @FindBy(xpath = "//tr[@class='user-first-name-wrap']//input")
    private TextInput userFirstName;

    public void enterUserFirstName(String fName) {
        userFirstName.clear();
        userFirstName.sendKeys(fName);
    }

    public String getUserFirstName() {
        return userFirstName.getEnteredText();
    }

    @Name("User Last Name Input")
    @FindBy(xpath = "//tr[@class='user-last-name-wrap']//input")
    private TextInput userLastName;

    public void enterUserLastName(String lName) {
        userLastName.clear();
        userLastName.sendKeys(lName);
    }

    public String getUserLastName() {
        return userLastName.getEnteredText();
    }

    @Name("User Email Input")
    @FindBy(xpath = "//tr[@class='user-email-wrap']//input")
    private TextInput userEmail;

    public void enterUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public String getUserEmail() {
        return userEmail.getEnteredText();
    }

    @Name("User City")
    @FindBy(xpath = "//tr[@data-name='city']//input")
    private TextInput userCity;

    public void enterUserCity(String city) {
        userCity.clear();
        userCity.sendKeys(city);
    }

    public String getUserCity() {
        return userCity.getEnteredText();
    }

    @Name("User State")
    @FindBy(xpath = "//tr[@data-name='state_province']//input")
    private TextInput userState;

    public void enterUserState(String state) {
        userState.clear();
        userState.sendKeys(state);
    }

    public String getUserState() {
        return userState.getEnteredText();
    }

    @Name("User Post Code")
    @FindBy(xpath = "//tr[@data-name='postal_code']//input")
    private TextInput userPostCode;

    public void enterUserPostCode(String postCode) {
        userPostCode.clear();
        userPostCode.sendKeys(postCode);
    }

    public String getUserPostCode() {
        return userPostCode.getEnteredText();
    }

    @Name("User Phone Number")
    @FindBy(xpath = "//tr[@data-name='phone_number']//input")
    private TextInput userPhoneNumber;

    public void enterUserPhonNumber(String phoneNumber) {
        userPhoneNumber.clear();
        userPhoneNumber.sendKeys(phoneNumber);
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber.getEnteredText();
    }


}

