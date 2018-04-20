package create.account.test;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Retirement;
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

public class CreateRetirementAccount extends TestBase{

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
    public void createFirstRetirementAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingRInvestorInformation(Users.CHESALOV);
        s2Retirement.checkedCitizenFN();
        s2Retirement.chooseCountryCanada();
        s2Retirement.chooseProvinceAlberta();
        s2Retirement.chooseTypeIRA();
        helperMethods.fillingRetirementInformation(Users.VLADWYANE);
        s2Retirement.chooseRetCountryUS();
        s2Retirement.chooseRetStateNevada();;
        s2Retirement.checkedFinStatus1Mil();
        s2Retirement.checkedKnowledgeYes();
        s2Retirement.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Retirement/SEP IRA");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

    @Test (groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherRetirementAccount() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment6Month();
        step1Invest.enterInvestmentAmount("5,000");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.chooseTypeSimpleIRA();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingRetirementInformation(Users.VLADWYANE);
        s2Retirement.chooseRetCountryUS();
        s2Retirement.chooseRetStateNevada();;
        s2Retirement.checkedFinStatus1Mil();
        s2Retirement.checkedKnowledgeYes();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Retirement.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        app.goTo("http://securedincomegroup.stgng.co/");
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Retirement/Simple IRA");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherRetirementAccountWithoutRetireInfo() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment6Month();
        step1Invest.enterInvestmentAmount("5,000");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.chooseType403b();
        s2Retirement.checkedFinStatusAny();
        s2Retirement.checkedKnowledgeNo();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Retirement.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        app.goTo("http://securedincomegroup.stgng.co/");
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Retirement/403(b)");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }


}
