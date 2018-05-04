package email.test;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.*;

public class EmailTerminateInvestment extends TestBase{

    @Test (groups = "EmailTerminateInvestment", dependsOnGroups = "EmailMyReview", alwaysRun = true, priority = 78)
    public void sendTerminateInvestmentEmail() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameRetirement();
        RetirementInvestments retirementInvestments = new RetirementInvestments(app.getDriver());
        retirementInvestments.clickLinkViewAlerts();
        retirementInvestments.clickSubmitDoNotRenew();
        FancyboxDoNotRenew fancyboxDoNotRenew = new FancyboxDoNotRenew(app.getDriver());
        fancyboxDoNotRenew.checkedConfirmTerminate();
        fancyboxDoNotRenew.clickButtonTermInvest();
        app.goTo("http://securedincomegroup.stgng.co");
        userAccounts.clickAccountNameRetirement();
        retirementInvestments.clickLinkTabClosed();
        app.sAssert().assertEquals(retirementInvestments.getInvestmentStatus(), "CLOSED");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailTerminateInvestment", dependsOnGroups = "EmailMyReview", alwaysRun = true, priority = 80)
    public void testEmailTerminateInvestmentForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "Renewal Cancellation");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailTerminateInvestment", dependsOnGroups = "EmailMyReview", alwaysRun = true, priority = 80)
    public void testEmailTerminateInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Renewal Cancellation");
        app.sAssert().assertAll();
    }

}
