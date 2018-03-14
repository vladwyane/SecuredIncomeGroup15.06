package create;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Individual;
import create.account.step2account.S2Retirement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class CreateRetirementAccount extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }

    @Ignore
    @Test
    public void createFirstRetirementAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.fillingRInvestorInformation("Vladyslav", "Chesalov", "11/27/1987",
              "Milutenka Street", "Kharkiv", "1234", "0668843478", app.testEmail);
        s2Retirement.checkedCitizenFN();
        s2Retirement.chooseCountryCanada();
        s2Retirement.chooseProvinceAlberta();
        s2Retirement.chooseTypeIRA();
        s2Retirement.fillingRetirementInformation("RetireName", "Shevchenka", "Kiev",
                "95321", "09957867891", "dwyane@i.ua");
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

    @Test(priority = 2)
    public void createAnotherRetirementAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.chooseTypeSimpleIRA();
        s2Retirement.fillingRetirementInformation("RetireName", "Shevchenka", "Kiev",
                "95321", "09957867891", "dwyane@i.ua");
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
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Retirement/Simple IRA");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

    @Test(priority = 2)
    public void createAnotherRetirementAccountWithoutRetireInfo() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountRetirement();
        step1Account.clickSaveButton();
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.chooseType403b();
        s2Retirement.checkedFinStatusAny();
        s2Retirement.checkedKnowledgeNo();
        s2Retirement.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Retirement/403(b)");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }


}
