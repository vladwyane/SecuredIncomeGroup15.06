package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import create.account.RemoveAccount;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.JointInvestments;
import user.pages.UserAccounts;

public class EmailRenewInvestment extends TestBase {

    @Test (groups = "EmailRenewInvestment", dependsOnGroups = "CreateJointInvestment", alwaysRun = true, priority = 48)
    public void testEmailRenewInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Reminder to Renew Investment");
        app.sAssert().assertAll();
    }
}
