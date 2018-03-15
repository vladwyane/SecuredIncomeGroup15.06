package create.account.test;

import create.account.Step1Account;
import create.account.step2account.S2Individual;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Joint;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.Users;
import user.pages.UserAccounts;

public class CreateIndividualAccount extends TestBase {

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }

    @Test(priority = 1)
    public void createFirstIndividualAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        S2Individual s2Individual = new S2Individual(app.getDriver());
        s2Individual.fillingInvestorInformation("Vladyslav", "Chesalov", "11/07/1987", "123456789",
                "Milutenka Street", "Kharkiv", "1234", "0668843478", app.testEmail);
        s2Individual.checkedCitizenFN();
        s2Individual.chooseCountryCanada();
        s2Individual.chooseProvinceAlberta();
        s2Individual.checkedFinStatusAny();
        s2Individual.checkedKnowledgeNo();
        s2Individual.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Individual");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

    @Test(priority = 2)
    public void createAnotherIndividualAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        S2Individual s2Individual = new S2Individual(app.getDriver());
        s2Individual.checkedFinStatus20000();
        s2Individual.checkedKnowledgeYes();
        s2Individual.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Individual");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV");
        app.sAssert().assertAll();
    }

}
