package create.investments.test;

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
import user.pages.TrustInvestments;
import user.pages.UserAccounts;

public class ActivateTrustInvestment extends TestBase {

    @Test(groups = "CreateTrustInvestment", dependsOnGroups = "EmailRetirementInvestment", alwaysRun = true, priority = 60)
    public void testActivateTrustInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        String investNum = adminFundsPending.getFirstInvNum();
        RemoveAccount actionsWithWPAdmin = new RemoveAccount(app.getDriver());
        actionsWithWPAdmin.changeYearPublish("06","2017");
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        adminDashboard.clickLinkFundsActivate();
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        adminActivateFunds.enterAccountNumber(investNum);
        adminActivateFunds.enterFundAmount("10111.99");
        adminActivateFunds.enterFundDate("06/26/2017");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameTrust();
        TrustInvestments trustInvestments = new TrustInvestments(app.getDriver());
        app.sAssert().assertEquals(trustInvestments.getDateFunded(), "06/26/2017");
        app.sAssert().assertEquals(trustInvestments.getMaturityDate(), "06/26/2018");
        app.sAssert().assertEquals(trustInvestments.getInvestmentRate(), "7.15%");
        app.sAssert().assertEquals(trustInvestments.getInvestmentTerm(), "1 YEAR(S)");
        app.sAssert().assertEquals(trustInvestments.getInvestmentStatus(), "ACTIVE");
        app.sAssert().assertEquals(userAccounts.getAlertRenewPending(), "RENEWAL PENDING : DUE 06/26/2018");
        app.sAssert().assertAll();

    }
}
