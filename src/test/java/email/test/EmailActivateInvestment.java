package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailActivateInvestment extends TestBase {

    @Test(groups = "EmailActivateInvestment", dependsOnGroups = "EmailPendingFunds", alwaysRun = true, priority = 26)
    public void testActivateIndInvestment() throws InterruptedException {
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
        adminActivateFunds.enterFundAmount("5000");
        adminActivateFunds.enterFundDate("03/07/2018");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        app.sAssert().assertEquals(adminDashboard.getStatusFirstInvestment(), "Active");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailActivateInvestment", dependsOnGroups = "EmailPendingFunds", alwaysRun = true, priority = 28)
    public void testEmailActivateIndInvestForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Investment is Fully Funded");
        app.sAssert().assertAll();
    }
}
