package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class FancyboxDeleteNewInvestments {

    private WebDriver driver;
    private WebDriverWait wait;

    public FancyboxDeleteNewInvestments(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Button Delete this Investment")
    @FindBy(xpath = "//a[text()='Delete this Investment']")
    private Button buttonDeleteInv;

    public void clickButtonDeleteInv() {
        buttonDeleteInv.click();
    }
}
