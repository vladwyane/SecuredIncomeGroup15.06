package create.account.test;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Entity;
import create.account.step2account.S2Individual;
import create.account.step2account.S2Joint;
import create.account.step2account.S2Trust;
import create.investment.Step1Invest;
import create.investment.Step2Invest;
import create.investment.Step5Invest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class CreateEntityAccount extends TestBase {


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
    public void createFirstEntityAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.CHESALOV);
        s2Entity.checkedCitizenFN();
        s2Entity.chooseCountryCanada();
        s2Entity.chooseProvinceAlberta();
        helperMethods.fillingEntityInformation(Users.CHESALOV);
        s2Entity.chooseEntityTypeCorporation();
        s2Entity.chooseECountryUS();
        s2Entity.chooseEStateNevada();
        s2Entity.checkedFinStatus30000();
        s2Entity.checkedKnowledgeYes();
        s2Entity.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Entity/Corporation");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "ENTITYNAME");
        app.sAssert().assertAll();
    }

    @Test (groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherEntityAccount() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Year();
        step1Invest.enterInvestmentAmount("25000.99");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingEntityInformation(Users.CHESALOV);
        s2Entity.chooseEntityTypeCorporation();
        s2Entity.chooseECountryUS();
        s2Entity.chooseEStateNevada();
        s2Entity.checkedFinStatusAny();
        s2Entity.checkedKnowledgeNo();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Entity.clickSaveButton();
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
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Entity/Corporation");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "ENTITYNAME");
        app.sAssert().assertAll();
    }

    @Test (groups = "CreateAccount", dependsOnGroups = "NoInvestmentCreated", alwaysRun = true, priority = 14)
    public void createAnotherEntityAccountWithSameAddress() {
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Year();
        step1Invest.enterInvestmentAmount("25000.99");
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        s2Entity.checkedECheckboxSameAddress();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingEntitytInformationWithSameAddress(Users.CHESALOV);
        s2Entity.chooseEntityTypeLLC();
        s2Entity.checkedFinStatus30000();
        s2Entity.checkedKnowledgeYes();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        s2Entity.clickSaveButton();
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
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Entity/Llc");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "ENTITYNAME");
        app.sAssert().assertAll();


    }

}
