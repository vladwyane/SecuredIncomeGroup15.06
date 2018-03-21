package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import create.account.RemoveAccount;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.FancyboxRenewInvestments;
import user.pages.UserAccounts;

public class EmailRenewCurrentValuePlus extends TestBase {

    @Test(groups = "EmailRenewCurrentValuePlus", dependsOnGroups = "CreateTrustInvestment", alwaysRun = true, priority = 62)
    public void testChooseRenewCurrentValuePlus() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameTrust();
        userAccounts.clickAlertRenewPending();
        FancyboxRenewInvestments fancyboxRenewInvestments = new FancyboxRenewInvestments(app.getDriver());
        fancyboxRenewInvestments.checkedCheckboxRenewTerm();
        fancyboxRenewInvestments.checkedRadioRenewCurValPlus();
        fancyboxRenewInvestments.chooseInvestment3Year();
        fancyboxRenewInvestments.enterFieldRenewCurValPlus("14888.01");
        fancyboxRenewInvestments.clickAcceptButton();
        Thread.sleep(2000);
        app.sAssert().assertEquals(userAccounts.getAlertFinishFunding(), "FINISH FUNDING: $14,888.01");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailRenewCurrentValuePlus", dependsOnGroups = "CreateTrustInvestment", alwaysRun = true, priority = 64)
    public void testEmailRenewCurrentValuePlusForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "RENEW & INCREASE INVESTMENT");
        app.sAssert().assertAll();
    }
}
