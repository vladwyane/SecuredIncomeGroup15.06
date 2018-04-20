package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class UserAccounts {

    private WebDriver driver;
    private WebDriverWait wait;

    public UserAccounts(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Sidebar Heading")
    @FindBy(xpath = "//h3[contains(text(), 'New Account')]")
    private HtmlElement headingSidebar;

    public String getHeadingSidebar() {
        return headingSidebar.getText();
    }

    @Name("Open Account Link")
    @FindBy(css = ".link-open")
    private Link openAccountLink;

    public void clickOpenAccountLink() {
        openAccountLink.click();
    }

    @Name("Link Pending")
    @FindBy(xpath = "(//*[@class='link-pending']/span)[1]")
    private Link linkPending;

    public String getTextLinkPending() {
        return linkPending.getText();
    }

    public void clickLinkPending() {
        linkPending.click();
    }

    @Name("Account Type")
    @FindBy(xpath = "(//*[@class='account-type'])[1]")
    private HtmlElement accountType;

    public String getAccountType() {
        return accountType.getText();
    }

    @Name("Account Name")
    @FindBy(xpath = "(//*[@class='name']//a)[1]")
    private Link accountName;

    public String getAccountName() {
        return accountName.getText();
    }

    @Name("Account Name Individual")
    @FindBy(xpath = "(//span[contains(text(), 'Individual')]//following-sibling::form//a)[1]")
    private Link accountNameIndividual;

    public String getAccountNameIndividual() {
        return accountNameIndividual.getText();
    }

    public void clickAccountNameIndividual() {
        accountNameIndividual.click();
    }

    @Name("Account Name Joint")
    @FindBy(xpath = "(//span[contains(text(), 'Joint')]//following-sibling::form//a)[1]")
    private Link accountNameJoint;

    public String getAccountNameJoint() {
        return accountNameJoint.getText();
    }

    public void clickAccountNameJoint() {
        accountNameJoint.click();
    }

    @Name("Account Name Retirement")
    @FindBy(xpath = "(//span[contains(text(), 'Retirement/Simple IRA')]//following-sibling::form//a)[1]")
    private Link accountNameRetirement;

    public String getAccountNameRetirement() {
        return accountNameRetirement.getText();
    }

    public void clickAccountNameRetirement() {
        accountNameRetirement.click();
    }

    @Name("Account Name Trust")
    @FindBy(xpath = "(//span[contains(text(), 'Trust')]//following-sibling::form//a)[1]")
    private Link accountNameTrust;

    public String getAccountNameTrust() {
        return accountNameTrust.getText();
    }

    public void clickAccountNameTrust() {
        accountNameTrust.click();
    }

    @Name("Account Name Entity")
    @FindBy(xpath = "(//span[contains(text(), 'Entity/Corporation')]//following-sibling::form//a)[1]")
    private Link accountNameEntity;

    public String getAccountNameEntity() {
        return accountNameEntity.getText();
    }

    public void clickAccountNameEntity() {
        accountNameEntity.click();
    }

    @Name("Finish Funding")
    @FindBy(xpath = "//*[@data-prop-name='finish-funds']//span")
    private Link alertFinishFunding;

    public String getAlertFinishFunding() {
        return alertFinishFunding.getText();
    }

    public void clickAlertFinishFunding() {
        alertFinishFunding.click();
    }

    @Name("Renew Pending")
    @FindBy(xpath = "//*[@data-prop-name='lrenew']//span")
    private Link alertRenewPending;

    public String getAlertRenewPending() {
        return alertRenewPending.getText();
    }

    public void clickAlertRenewPending() {
        alertRenewPending.click();
    }


}
