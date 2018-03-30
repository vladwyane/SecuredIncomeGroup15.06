package create.account.test;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Joint;
import create.investment.Step1Invest;
import create.investment.Step2Invest;
import create.investment.Step5Invest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.UserAccounts;

public class CreateJointAccount extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }

    @Ignore
    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 12)
    public void createFirstJointAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.CHESALOV);
        s2Joint.chooseCountryCanada();
        s2Joint.chooseProvinceYukon();
        helperMethods.fillingJointInformation(Users.VLADWYANE);
        s2Joint.chooseJCountryUS();
        s2Joint.chooseJStateNevada();
        s2Joint.checkedJCitizenUS();
        s2Joint.checkedFinStatus1Mil();
        s2Joint.checkedKnowledgeYes();
        s2Joint.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Joint");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV, VLAD CHES");
        app.sAssert().assertAll();
    }

    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherJointAccount() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment1Year();
        step1Invest.enterInvestmentAmount("10,000.01");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingJointInformation(Users.VLAD);
        s2Joint.chooseJCountryUS();
        s2Joint.chooseJStateAlabama();
        s2Joint.checkedFinStatus30000();
        s2Joint.checkedKnowledgeYes();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Joint.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Joint");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV, V CH");
        app.sAssert().assertAll();
    }

    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherJointAccountWithSameAddress() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment1Year();
        step1Invest.enterInvestmentAmount("10,000.01");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingJointInformationWithSameAddress(Users.VLADWYANE);
        s2Joint.checkedJCheckboxSameAddress();
        s2Joint.checkedFinStatus20000();
        s2Joint.checkedKnowledgeNo();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Joint.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Joint");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV, VLAD CHES");
        app.sAssert().assertAll();
    }
}
