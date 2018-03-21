package create.investments.test;

import create.investment.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.JointInvestments;
import user.pages.UserAccounts;

public class CreateJointInvestment extends TestBase{

    @BeforeMethod
    public void signInAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
    }

    @Test(groups = "CreateJointInvestment", dependsOnGroups = "AddIndividualInvestment", alwaysRun = true, priority = 44)
    public void createJointInvest1Year() {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameJoint();
        JointInvestments jointInvestments = new JointInvestments(app.getDriver());
        jointInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment1Year();
        step1Invest.enterInvestmentAmount("10,000.01");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingDividendInformation(Users.VLAD);
        step2Invest.chooseDivCountryUS();
        step2Invest.chooseDivStateNevada();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByCheckButton();
        step5Invest.clickFinishButton();
        app.sAssert().assertEquals(userAccounts.getAlertFinishFunding(), "FINISH FUNDING: $10,000.01");
        app.sAssert().assertAll();

    }
}
