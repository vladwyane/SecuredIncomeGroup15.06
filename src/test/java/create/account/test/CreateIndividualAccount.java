package create.account.test;

import create.account.Step1Account;
import create.account.step2account.S2Individual;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Joint;
import create.investment.Step1Invest;
import create.investment.Step2Invest;
import create.investment.Step5Invest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class CreateIndividualAccount extends TestBase {


    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }


    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 12)
    public void createFirstIndividualAccount() throws InterruptedException {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Month();
        step1Invest.enterInvestmentAmount("5000");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        S2Individual s2Individual = new S2Individual(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.CHESALOV);
        s2Individual.checkedCitizenFN();
        s2Individual.chooseCountryCanada();
        s2Individual.chooseProvinceAlberta();
        s2Individual.checkedFinStatusAny();
        s2Individual.checkedKnowledgeNo();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        helperMethods.fillingDividendInformation(Users.VLADWYANE);
        step2Invest.chooseDivCountryCanada();
        step2Invest.chooseDivProvinceAlberta();
        step2Invest.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Individual");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

    @Test(groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherIndividualAccount() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Month();
        step1Invest.enterInvestmentAmount("5000");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        S2Individual s2Individual = new S2Individual(app.getDriver());
        s2Individual.checkedFinStatus20000();
        s2Individual.checkedKnowledgeYes();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingDividendInformation(Users.VLADWYANE);
        step2Invest.chooseDivCountryCanada();
        step2Invest.chooseDivProvinceAlberta();
        s2Individual.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Individual");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

}
