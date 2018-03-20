package admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AdminRetirementSetupPending {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminRetirementSetupPending(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("CheckBox First Investment Retirement Setup")
    @FindBy(xpath = "(//*[@name='data-checkbox']/following-sibling::span)[1]")
    private Link firstCheckBoxRetSet;

    public void clickFirstCheckBoxRetSet() {
        firstCheckBoxRetSet.click();
    }

    @Name("Change Status Funds Pending Button")
    @FindBy(xpath = "//*[@data-prop-name='changeInvestments']")
    private Button changeStatusFunPend;

    public void clickChangeStatusFunPend() {
        changeStatusFunPend.click();
    }

}
