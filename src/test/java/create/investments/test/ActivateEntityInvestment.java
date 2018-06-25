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
import user.pages.EntityInvestments;
import user.pages.UserAccounts;

public class ActivateEntityInvestment extends TestBase {

    @Test(groups = "CreateEntityInvestment", dependsOnGroups = "EmailRenewCurrentValuePlus", alwaysRun = true, priority = 68)
    public void testActivateEntityInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkFundsPending();
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        String investNum = adminFundsPending.getFirstInvNum();
        RemoveAccount actionsWithWPAdmin = new RemoveAccount(app.getDriver());
        actionsWithWPAdmin.changeYearPublish("06","2015");
        app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
        adminDashboard.clickLinkFundsActivate();
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        adminActivateFunds.enterAccountNumber(investNum);
        adminActivateFunds.enterFundAmount("25,000.99");
        adminActivateFunds.enterFundDate("06/26/2015");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameEntity();
        EntityInvestments entityInvestments = new EntityInvestments(app.getDriver());
        app.sAssert().assertEquals(entityInvestments.getDateFunded(), "06/26/2015");
        app.sAssert().assertEquals(entityInvestments.getMaturityDate(), "06/26/2018");
        app.sAssert().assertEquals(entityInvestments.getInvestmentRate(), "9.00%");
        app.sAssert().assertEquals(entityInvestments.getInvestmentTerm(), "3 YEAR(S)");
        app.sAssert().assertEquals(entityInvestments.getInvestmentStatus(), "ACTIVE");
        app.sAssert().assertEquals(userAccounts.getAlertRenewPending(), "RENEWAL PENDING : DUE 06/26/2018");
        app.sAssert().assertAll();
    }
}
