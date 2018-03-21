package create.investments.test;

import admin.pages.AdminDashboard;
import admin.pages.AdminRetirementSetupPending;
import common.elements.Header;
import create.investment.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.JointInvestments;
import user.pages.RetirementInvestments;
import user.pages.UserAccounts;

public class CreateRetirementInvestment extends TestBase {

    @BeforeMethod
    public void signInAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
    }

    @Test(groups = "CreateRetirementInvestment", dependsOnGroups = "EmailRenewInvestment", alwaysRun = true, priority = 50)
    public void createRetireInvest6Month() throws InterruptedException {
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameRetirement();
        RetirementInvestments retirementInvestments = new RetirementInvestments(app.getDriver());
        retirementInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment6Month();
        step1Invest.enterInvestmentAmount("5,000");
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
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.ADMIN);
        AdminDashboard adminDashboard = new AdminDashboard(app.getDriver());
        adminDashboard.clickLinkRetirementSetup();
        AdminRetirementSetupPending adminRetirementSetupPending = new AdminRetirementSetupPending(app.getDriver());
        adminRetirementSetupPending.clickFirstCheckBoxRetSet();
        adminRetirementSetupPending.clickChangeStatusFunPend();
        Thread.sleep(3000);
        header.clickLinkSign();
        helperMethods.signIn(Users.CHESALOV);
        userAccounts.clickAccountNameRetirement();
        app.sAssert().assertEquals(userAccounts.getAlertFinishFunding(), "FINISH FUNDING: $5,000.00");
        app.sAssert().assertAll();
    }

}
