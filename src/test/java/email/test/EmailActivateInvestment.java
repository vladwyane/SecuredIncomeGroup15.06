package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class EmailActivateInvestment extends TestBase {

    @Test (groups = "EmailActivateInvestment", dependsOnGroups = "EmailPendingFunds", alwaysRun = true, priority = 28)
    public void testEmailActivateIndInvestForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Investment is Fully Funded");
        app.sAssert().assertAll();
    }
}
