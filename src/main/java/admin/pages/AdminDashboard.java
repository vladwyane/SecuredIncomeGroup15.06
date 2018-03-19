package admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AdminDashboard {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminDashboard(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Link No Investment Created")
    @FindBy(xpath = "//a/div/p[text()='No Investment Created']")
    private Link linkNoInvCreated;

    public void clickLinkNoInvCreated() {
        linkNoInvCreated.click();
    }

    @Name("Link Funds Pending")
    @FindBy(xpath = "//a/div/p[text()='Funds Pending']")
    private Link linkFundsPending;

    public void clickLinkFundsPending() {
        linkFundsPending.click();
    }

    @Name("Link Fund & Activate")
    @FindBy(xpath = "//a/div/p[text()='Fund & Activate']")
    private Link linkFundsActivate;

    public void clickLinkFundsActivate() {
        linkFundsActivate.click();
    }

    @Name("Status First Investment")
    @FindBy(xpath = "(//table//td)[6]")
    private HtmlElement statusFirstInvestment;

    public String getStatusFirstInvestment() {
        return statusFirstInvestment.getText();
    }

    @Name("Value First Investment")
    @FindBy(xpath = "(//table//td)[11]")
    private HtmlElement valueFirstInvestment;

    public String getValueFirstInvestment() {
        return valueFirstInvestment.getText();
    }

}
