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
import user.pages.RetirementInvestments;
import user.pages.UserAccounts;

public class EmailRetirementInvestment extends TestBase{

    @Test(groups = "EmailRetirementInvestment", dependsOnGroups = "CreateRetirementInvestment", alwaysRun = true, priority = 55)
    public void testEmailRetirementInvForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Retirement Investment Request Has Been Received");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailRetirementInvestment", dependsOnGroups = "CreateRetirementInvestment", alwaysRun = true, priority = 55)
    public void testEmailRetirementInvForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "SIG Website: PENDING RETIREMENT SETUP");
        app.sAssert().assertAll();
    }


}
