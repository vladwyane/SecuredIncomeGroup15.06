package email.test;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.Users;

public class EmailCreateInvestment extends TestBase {

    @Test(groups = "EmailCreateInvestment", dependsOnGroups = "CreateIndividualInvestment", alwaysRun = true, priority = 18)
    public void testEmailCreateIndInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Investment Has Been Created and is Ready to Fund.");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailCreateIndIndInvestment", dependsOnGroups = "CreateIndividualInvestment", alwaysRun = true, priority = 20)
    public void testEmailCreateInvestmentForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "Added new investment");
        app.sAssert().assertAll();
    }

}
