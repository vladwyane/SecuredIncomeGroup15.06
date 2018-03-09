package create.investments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import registration.pages.Register;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Step1 {

    private WebDriver driver;
    private WebDriverWait wait;

    public Step1(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Main Heading")
    @FindBy(xpath = "//*[contains(text(), 'Account Information')]")
    private HtmlElement mainHeading;

    public String getMainHeading() {
        return mainHeading.getText();
    }

    @Name("Investment Select")
    @FindBy(id = "type-select")
    private Select investmentSelect;

    public void chooseSelect() {
        investmentSelect.selectByValue("trust");
    }


}
