package test.base;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners(MyTestListener.class)
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public static void setupClass() {
       app.setup();
        Reporter.log("Before Suit executed",1,true);
    }

    @BeforeMethod
    public void setupTest(ITestContext context) throws Exception{
        app.unit();
        context.setAttribute("app", app);
    }

    @AfterSuite
    public void teardown() {
        app.stop();
    }
}
