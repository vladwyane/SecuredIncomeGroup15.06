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

    @Name("First Link Send Mail")
    @FindBy(xpath = "(//table//a[@data-prop-name='sendNew'])[1]")
    private Link firstLinkSend;

    public void clickFirstLinkSend() {
        firstLinkSend.click();
    }

    @Name("First Mails Sent Number")
    @FindBy(xpath = "(//table//span[@class='mails-num'])[1]")
    private HtmlElement firstMailNum;

    public String getFirstMailNum() {
        return firstMailNum.getText();
    }

    @Name("First Investment Number")
    @FindBy(xpath = "(//a[@class='num'])[1]")
    private Link firstInvNum;

    public String getFirstInvNum() {
        return firstInvNum.getText();
    }

}
