package email.test;

import admin.pages.AdminDashboard;
import admin.pages.AdminNoInvestmentCreated;
import create.account.Step1Account;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailNoInvestmentCreated extends TestBase {

    @Test (groups = "NoInvestmentCreated", dependsOnGroups = "Registration", alwaysRun = true, priority = 8)
    public void testCountMailsSent() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkNoInvCreated();
        AdminNoInvestmentCreated adminNoInvestmentCreated = new AdminNoInvestmentCreated(app.getDriver());
        adminNoInvestmentCreated.clickFirstLinkSend();
        Thread.sleep(2000);
        app.sAssert().assertEquals(adminNoInvestmentCreated.getFirstMailNum(), "1");
        app.sAssert().assertAll();
    }

    @Test (groups = "NoInvestmentCreated", dependsOnGroups = "Registration", alwaysRun = true, priority = 10)
    public void testEmailNoInvestmentCreatedForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "You Didn't Create An Investment");
        app.sAssert().assertAll();
    }
}
