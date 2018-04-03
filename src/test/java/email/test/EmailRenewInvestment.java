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

    @Test (groups = "EmailRenewInvestment", dependsOnGroups = "CreateJointInvestment", alwaysRun = true, priority = 46)
    public void testActivateJointInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        String investNum = adminFundsPending.getFirstInvNum();
        Thread.sleep(5000);
        RemoveAccount actionsWithWPAdmin = new RemoveAccount(app.getDriver());
        actionsWithWPAdmin.changeYearPublish("04","2017");
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        adminDashboard.clickLinkFundsActivate();
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        adminActivateFunds.enterAccountNumber(investNum);
        adminActivateFunds.enterFundAmount("10,000.01");
        adminActivateFunds.enterFundDate("04/04/2017");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameJoint();
        JointInvestments jointInvestments = new JointInvestments(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAlertRenewPending(), "RENEWAL PENDING : DUE 04/04/2018");
        app.sAssert().assertEquals(jointInvestments.getDateFunded(), "04/04/2017");
        app.sAssert().assertEquals(jointInvestments.getMaturityDate(), "04/04/2018");
        app.sAssert().assertEquals(jointInvestments.getInvestmentRate(), "7.15%");
        app.sAssert().assertEquals(jointInvestments.getInvestmentTerm(), "1 YEAR(S)");
        app.sAssert().assertEquals(jointInvestments.getInvestmentStatus(), "ACTIVE");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailRenewInvestment", dependsOnGroups = "CreateJointInvestment", alwaysRun = true, priority = 48)
    public void testEmailRenewInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Reminder to Renew Investment");
        app.sAssert().assertAll();
    }
}
