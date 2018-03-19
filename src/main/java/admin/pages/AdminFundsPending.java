package admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AdminFundsPending {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminFundsPending(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("First Link Send Mail New Tab")
    @FindBy(xpath = "(//table//a[@data-prop-name='sendNew'])[1]")
    private Link firstLinkSend;

    public void clickFirstLinkSend() {
        firstLinkSend.click();
    }

    @Name("First Mails Sent Number New Tab")
    @FindBy(xpath = "(//table//span[@class='mails-num'])[1]")
    private HtmlElement firstMailNum;

    public String getFirstMailNum() {
        return firstMailNum.getText();
    }

    @Name("First Investment Number New Tab")
    @FindBy(xpath = "(//a[@class='num'])[1]")
    private Link firstInvNum;

    public String getFirstInvNum() {
        return firstInvNum.getText();
    }

    @Name("Active Funds Pending Tab")
    @FindBy(xpath = "//ul[contains(@class, 'tabset')]//a[text()='ACTIVE/Funds Pending']")
    private Link activeTab;

    public void clickActiveTab() {
        activeTab.click();
    }

    @Name("First Link Send Mail Active Tab")
    @FindBy(xpath = "(//div[@id='table-tab2']//a[@data-prop-name='sendActive'])[1]")
    private Link firstLinkSendActive;

    public void clickFirstLinkSendActive() {
        firstLinkSendActive.click();
    }

    @Name("First Mails Sent Number Active Tab")
    @FindBy(xpath = "(//div[@id='table-tab2']//span[@class='mails-num'])[1]")
    private HtmlElement firstMailNumActive;

    public String getFirstMailNumActive() {
        return firstMailNumActive.getText();
    }

    @Name("First Investment Number Active Tab")
    @FindBy(xpath = "(//div[@id='table-tab2']//a[@class='num'])[1]")
    private Link firstInvNumActive;

    public String getFirstInvNumActive() {
        return firstInvNumActive.getText();
    }

}
