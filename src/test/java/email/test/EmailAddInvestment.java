package email.test;

import admin.pages.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailAddInvestment extends TestBase{

    @Test(groups = "EmailAddInvestment", dependsOnGroups = "EmailRequestIncreaseInvestment", alwaysRun = true, priority = 36)
    public void testCountMailsSentActiveTab() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        adminFundsPending.clickActiveTab();
        adminFundsPending.clickFirstLinkSendActive();
        Thread.sleep(2000);
        app.sAssert().assertEquals(adminFundsPending.getFirstMailNumActive(), "1");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailAddInvestment", dependsOnGroups = "EmailRequestIncreaseInvestment", alwaysRun = true, priority = 38)
    public void testEmailRemindPendingFundsForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Pending Funds");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailAddInvestment", dependsOnGroups = "EmailRequestIncreaseInvestment", alwaysRun = true, priority = 40)
    public void testAddToInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        adminFundsPending.clickActiveTab();
        String investNum = adminFundsPending.getFirstInvNumActive();
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        adminDashboard.clickLinkFundsActivate();
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        adminActivateFunds.enterAccountNumber(investNum);
        adminActivateFunds.enterFundAmount("100");
        adminActivateFunds.enterFundDate("03/10/2018");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        app.sAssert().assertEquals(adminDashboard.getValueFirstInvestment(), "5,100.00");
        app.sAssert().assertAll();
    }

}
