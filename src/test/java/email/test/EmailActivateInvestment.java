package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class EmailActivateInvestment extends TestBase {

    @Test (groups = "EmailActivateInvestment", dependsOnGroups = "EmailPendingFunds", alwaysRun = true, priority = 26)
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
        adminActivateFunds.enterFundDate("04/23/2018");
        adminActivateFunds.clickSubmitButton();
        Thread.sleep(2000);
        FancyBox fancyBox = new FancyBox(app.getDriver());
        fancyBox.clickSubmitButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        app.sAssert().assertEquals(individualInvestments.getDateFunded(), "04/23/2018");
        app.sAssert().assertEquals(individualInvestments.getMaturityDate(), "07/23/2018");
        app.sAssert().assertEquals(individualInvestments.getInvestmentRate(), "6%");
        app.sAssert().assertEquals(individualInvestments.getInvestmentTerm(), "3 MONTH(S)");
        app.sAssert().assertEquals(individualInvestments.getInvestmentStatus(), "ACTIVE");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailActivateInvestment", dependsOnGroups = "EmailPendingFunds", alwaysRun = true, priority = 28)
    public void testEmailActivateIndInvestForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Investment is Fully Funded");
        app.sAssert().assertAll();
    }
}
