package admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class FancyBox {

    private WebDriver driver;
    private WebDriverWait wait;

    public FancyBox(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("Submit Button")
    @FindBy(xpath = "//div[@class='lightbox white-lightbox']//input[@type='submit']")
    private Button submitButton;

    public AdminActivateFunds clickSubmitButton() {
        submitButton.click();
        return new AdminActivateFunds(driver);

    }


}
