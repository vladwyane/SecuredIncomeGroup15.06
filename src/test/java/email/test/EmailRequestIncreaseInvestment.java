package email.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class EmailRequestIncreaseInvestment extends TestBase{

    @Test(groups = "EmailRequestIncreaseInvestment", dependsOnGroups = "EmailActivateInvestment", alwaysRun = true, priority = 30)
    public void testRequestIncreaseInvestment() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkAddToInvestment();
        individualInvestments.enterAddInvestment("100");
        individualInvestments.clickSubmitFundingButton();
        //waiting until email will be sent
        Thread.sleep(3000);
        app.sAssert().assertEquals(userAccounts.getAlertFinishFunding(), "FUNDS PENDING: $100.00");
        app.sAssert().assertAll();

    }

    @Test(groups = "EmailRequestIncreaseInvestment", dependsOnGroups = "EmailActivateInvestment", alwaysRun = true, priority = 32)
    public void testEmailRequestIncreaseInvestmentForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Request to Increase Your Investment");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailRequestIncreaseInvestment", dependsOnGroups = "EmailActivateInvestment", alwaysRun = true, priority = 34)
    public void testEmailRequestIncreaseInvestmentForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "ADD TO INVESTMENT");
        app.sAssert().assertAll();
    }
}
