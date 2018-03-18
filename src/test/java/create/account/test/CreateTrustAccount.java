package create.account.test;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Retirement;
import create.account.step2account.S2Trust;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.UserAccounts;

public class CreateTrustAccount extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }


    @Test(priority = 1)
    public void createFirstTrustAccountSSN() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountTrust();
        step1Account.clickSaveButton();
        S2Trust s2Trust = new S2Trust(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.ADMIN);
        s2Trust.checkedCitizenFN();
        s2Trust.chooseCountryCanada();
        s2Trust.chooseProvinceAlberta();
        s2Trust.enterTrustName("Trust Name");
        s2Trust.checkedRadioSSN();
        s2Trust.enterTaxNumberSSN("123456789");
        s2Trust.checkedFinStatus20000();
        s2Trust.checkedKnowledgeYes();
        s2Trust.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Trust");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "TRUST NAME");
        app.sAssert().assertAll();
    }


    @Test(priority = 1)
    public void createFirstTrustAccountTIN() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountTrust();
        step1Account.clickSaveButton();
        S2Trust s2Trust = new S2Trust(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.ADMIN);
        s2Trust.checkedCitizenFN();
        s2Trust.chooseCountryCanada();
        s2Trust.chooseProvinceAlberta();
        s2Trust.enterTrustName("Trust Name");
        s2Trust.checkedRadioTIN();
        s2Trust.enterTaxNumberTIN("123456789");
        s2Trust.checkedFinStatus20000();
        s2Trust.checkedKnowledgeYes();
        s2Trust.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Trust");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "TRUST NAME");
        app.sAssert().assertAll();
    }

    @Test(priority = 2)
    public void createAnotherTrustAccountSSN() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountTrust();
        step1Account.clickSaveButton();
        S2Trust s2Trust = new S2Trust(app.getDriver());
        s2Trust.enterTrustName("Trust Name 1");
        s2Trust.checkedRadioSSN();
        s2Trust.enterTaxNumberSSN("123456789");
        s2Trust.checkedFinStatus1Mil();
        s2Trust.checkedKnowledgeNo();
        s2Trust.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Trust");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "TRUST NAME 1");
        app.sAssert().assertAll();
    }

    @Test(priority = 2)
    public void createAnotherTrustAccountTIN() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountTrust();
        step1Account.clickSaveButton();
        S2Trust s2Trust = new S2Trust(app.getDriver());
        s2Trust.enterTrustName("Trust Name 2");
        s2Trust.checkedRadioTIN();
        s2Trust.enterTaxNumberTIN("123456789");
        s2Trust.checkedFinStatus30000();
        s2Trust.checkedKnowledgeYes();
        s2Trust.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Trust");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "TRUST NAME 2");
        app.sAssert().assertAll();
    }

}
