package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailRenewInvestment extends TestBase {

    @Test (groups = "EmailRenewInvestment", dependsOnGroups = "CreateJointInvestment", alwaysRun = true, priority = 46)
    public void testActivateJointInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        String investNum = adminFundsPending.getFirstInvNum();
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        adminDashboard.clickLinkFundsActivate();
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        adminActivateFunds.enterAccountNumber(investNum);
        adminActivateFunds.enterFundAmount("10,000.01");
        adminActivateFunds.enterFundDate("05/01/2017");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        app.sAssert().assertEquals(adminDashboard.getStatusFirstInvestment(), "Renewal Pending");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailRenewInvestment", dependsOnGroups = "CreateJointInvestment", alwaysRun = true, priority = 48)
    public void testEmailRenewInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Reminder to Renew Investment");
        app.sAssert().assertAll();
    }
}
