package create.investments.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import create.investment.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

import java.util.Random;

public class AddIndividualInvestment extends TestBase {

    @Test(groups = "AddIndividualInvestment", dependsOnGroups = "EmailAddInvestment", alwaysRun = true, priority = 42)
    public void testAddCountInvestments() throws InterruptedException {
        addCountInvestment(8);
    }

    public void addCountInvestment(int count) throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        AdminFundsPending adminFundsPending = new AdminFundsPending(app.getDriver());
        AdminActivateFunds adminActivateFunds = new AdminActivateFunds(app.getDriver());
        FancyBox fancyBox = new FancyBox(app.getDriver());
        Random rand = new Random();
        float minSum = 1.0f;
        float maxSum = 1000.0f;
        float finalSumFl;
        String sum;
        String day;

        for (int i = 0; i < count; i++) {
            helperMethods.signIn(Users.CHESALOV);
            userAccounts.clickAccountNameIndividual();
            IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
            individualInvestments.clickLinkAddToInvestment();
            finalSumFl = rand.nextFloat() * (maxSum - minSum) + minSum;
            sum = String.format("%.2f", finalSumFl);
            individualInvestments.enterAddInvestment(sum);
            individualInvestments.clickSubmitFundingButton();
            Thread.sleep(5000);
            Header header = new Header(app.getDriver());
            header.clickLinkSign();
            helperMethods.signIn(Users.ADMIN);
            adminDashboard.clickLinkFundsPending();
            adminFundsPending.clickActiveTab();
            String investNum = adminFundsPending.getFirstInvNumActive();
            app.goTo("http://securedincomegroup.stgng.co/admin-dashboard/");
            adminDashboard.clickLinkFundsActivate();
            adminActivateFunds.enterAccountNumber(investNum);
            adminActivateFunds.enterFundAmount(sum);
            day = Integer.toString(23 + i);
            adminActivateFunds.enterFundDate("03/" + day + "/2018");
            adminActivateFunds.clickSubmitButton();
            fancyBox.clickSubmitButton();
            header.clickLinkSign();
        }

    }
}
