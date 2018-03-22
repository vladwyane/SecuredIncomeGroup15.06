package user.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class MyReview {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyReview(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    @Name("My Review Textarea")
    @FindBy(name = "review_content")
    private TextInput myReviewTextarea;

    public void enterMyReviewTextarea(String value) {
        myReviewTextarea.clear();
        myReviewTextarea.sendKeys(value);
    }

    public String getMyReviewTextarea() {
        return myReviewTextarea.getEnteredText();
    }

    @Name("Star Rating 4")
    @FindBy(xpath = "(//*[@class='rating']/label)[2]")
    private HtmlElement starsRating4;

    public void checkedStarsRating4() {
        starsRating4.click();
    }

    @Name("Button Submit Review")
    @FindBy(css = "[value='Submit']")
    private Button buttonSubmitReview;

    public void clickButtonSubmitReview() {
        buttonSubmitReview.click();
    }


}
