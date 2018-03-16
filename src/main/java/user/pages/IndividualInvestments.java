package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
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
}
