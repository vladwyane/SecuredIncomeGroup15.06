package email.test;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.FancyboxRenewInvestments;
import user.pages.UserAccounts;

public class EmailRenewCurrentValue extends TestBase {

    @Test(groups = "EmailRenewCurrentValue", dependsOnGroups = "EmailRenewInvestment", alwaysRun = true, priority = 50)
    public void testChooseRenewCurrentValue() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameJoint();
        userAccounts.clickAlertRenewPending();
        FancyboxRenewInvestments fancyboxRenewInvestments = new FancyboxRenewInvestments(app.getDriver());
        fancyboxRenewInvestments.checkedCheckboxRenewTerm();
        fancyboxRenewInvestments.chooseInvestment6Month();
        fancyboxRenewInvestments.clickAcceptButton();
        Thread.sleep(5000);
    }

    @Test(groups = "EmailRenewCurrentValue", dependsOnGroups = "EmailRenewInvestment", alwaysRun = true, priority = 52)
    public void testEmailRenewCurrentValueForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "RENEW AT CURRENT VALUE");
        app.sAssert().assertAll();
    }

}
