package create.investments.test;

import admin.pages.AdminActivateFunds;
import admin.pages.AdminDashboard;
import admin.pages.AdminFundsPending;
import admin.pages.FancyBox;
import common.elements.Header;
import create.account.RemoveAccount;
import create.investment.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.EntityInvestments;
import user.pages.FancyboxDeleteNewInvestments;
import user.pages.TrustInvestments;
import user.pages.UserAccounts;

public class CreateEntityInvestment extends TestBase {

    @Test(groups = "CreateEntityInvestment", dependsOnGroups = "EmailRenewCurrentValuePlus", alwaysRun = true, priority = 66)
    public void createTrustEntity3Year() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameEntity();
        EntityInvestments entityInvestments = new EntityInvestments(app.getDriver());
        entityInvestments.clickLinkDelNewInvestt();
        FancyboxDeleteNewInvestments fancyboxDeleteNewInvestments = new FancyboxDeleteNewInvestments(app.getDriver());
        fancyboxDeleteNewInvestments.clickButtonDeleteInv();
        Thread.sleep(5000);
        entityInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Year();
        step1Invest.enterInvestmentAmount("25000.99");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByCheckButton();
        step5Invest.clickFinishButton();
        app.sAssert().assertEquals(userAccounts.getAlertFinishFunding(), "FUNDS PENDING: $25,000.99");
        app.sAssert().assertAll();
    }
}
