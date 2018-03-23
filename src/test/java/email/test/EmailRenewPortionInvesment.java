package email.test;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.FancyboxRenewInvestments;
import user.pages.UserAccounts;

public class EmailRenewPortionInvesment extends TestBase {

    @Test (groups = "EmailRenewPortionInvesment", dependsOnGroups = "CreateEntityInvestment", alwaysRun = true, priority = 70)
    public void testChooseRenewPortionInv() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameEntity();
        userAccounts.clickAlertRenewPending();
        FancyboxRenewInvestments fancyboxRenewInvestments = new FancyboxRenewInvestments(app.getDriver());
        fancyboxRenewInvestments.checkedCheckboxRenewTerm();
        fancyboxRenewInvestments.checkedRadioRenewPortionInv();
        fancyboxRenewInvestments.chooseInvestment6Month();
        fancyboxRenewInvestments.enterFieldRenewPortionInv("7,500");
        fancyboxRenewInvestments.clickAcceptButton();
        Thread.sleep(2000);
    }

    @Test (groups = "EmailRenewPortionInvesment", dependsOnGroups = "CreateEntityInvestment", alwaysRun = true, priority = 72)
    public void testEmailRenewPortionInvForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "A Portion of Investment is Set to Renew.");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailRenewPortionInvesment", dependsOnGroups = "CreateEntityInvestment", alwaysRun = true, priority = 72)
    public void testEmailRenewPortionInvForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "RENEW A PORTION");
        app.sAssert().assertAll();
    }
}
