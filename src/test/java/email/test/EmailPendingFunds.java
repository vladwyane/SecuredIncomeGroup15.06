package email.test;

import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.AdminNoInvestmentCreated;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailPendingFunds extends TestBase{

    @Test(groups = "EmailPendingFunds", dependsOnGroups = "EmailCreateInvestment", alwaysRun = true, priority = 22)
    public void testCountMailsSentInd() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        adminFundsPending.clickFirstLinkSend();
        Thread.sleep(2000);
        app.sAssert().assertEquals(adminFundsPending.getFirstMailNum(), "1");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailPendingFunds", dependsOnGroups = "EmailCreateInvestment", alwaysRun = true, priority = 24)
    public void testEmailPendingFundsIndForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "You’re Investment Is Pending Funds");
        app.sAssert().assertAll();
    }
}
