package user.pages;

import create.account.Step3Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class IndividualInvestments {

    private WebDriver driver;
    private WebDriverWait wait;

    public IndividualInvestments(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Link Create Investment")
    @FindBy(xpath = "//*[contains(@class, 'sub-nav')]//p[contains(text(), 'Create A New Investment')]")
    private Link linkCreateInvestment;

    public String getLinkCreateInvestment() {
        return linkCreateInvestment.getText();
    }

    public void clickLinkCreateInvestment() {
        linkCreateInvestment.click();
    }

    @Name("Link Add To Investment")
    @FindBy(xpath = "//div[@class='info-heading']//a[@data-prop-name='add-funds']")
    private Link linkAddToInvestment;

    public String getLinkAddToInvestment() {
        return linkAddToInvestment.getText();
    }

    public void clickLinkAddToInvestment() {
        linkAddToInvestment.click();
    }

    @Name("Add Investment Field")
    @FindBy(name = "fund_value")
    private TextInput addInvestment;

    public void enterAddInvestment(String fName) {
        addInvestment.clear();
        addInvestment.sendKeys(fName);
    }

    @Name("Submit Funding Request")
    @FindBy(xpath = "//*[@value='Submit Funding Request']")
    private Button submitFundingButton;

    public IndividualInvestments clickSubmitFundingButton() {
        submitFundingButton.click();
        return new IndividualInvestments(driver);
    }

    @Name("DATE FUNDED")
    @FindBy(xpath = "//div[@class='footer-person-info']//p[text()='Date Funded: ']/strong")
    private HtmlElement dateFunded;

    public String getDateFunded() {
        return dateFunded.getText();
    }

    @Name("MATURITY DATE")
    @FindBy(xpath = "//div[@class='footer-person-info']//p[text()='Maturity Date: ']/strong")
    private HtmlElement maturityDate;

    public String getMaturityDate() {
        return maturityDate.getText();
    }


}
