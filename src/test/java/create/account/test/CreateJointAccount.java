package create.account.test;

import create.account.Step1Account;
import create.account.Step3Account;
import create.account.Step4Account;
import create.account.step2account.S2Individual;
import create.account.step2account.S2Joint;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class CreateJointAccount extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }


    @Test(priority = 1)
    public void createFirstJointAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        s2Joint.fillingInvestorInformation("Vladyslav", "Chesalov", "11/07/1987", "123456789",
                "Milutenka Street", "Kharkiv", "1234", "0668843478", app.testEmail);
        s2Joint.chooseCountryCanada();
        s2Joint.chooseProvinceYukon();
        s2Joint.fillingJointInformation("Vlad", "Ches", "12/07/2001", "987654321",
                "Shevchenka", "Kiev", "56789", "0995467891", "dwyane@i.ua");
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

    @Test(priority = 2)
    public void createAnotherJointAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        s2Joint.fillingJointInformation("V", "Ch", "01/07/1991", "987654",
                "Ivanova", "Alchevsk", "59", "0995467", "vladyslav.chesalov@p2h.com");
        s2Joint.chooseJCountryUS();
        s2Joint.chooseJStateAlabama();
        s2Joint.checkedFinStatus30000();
        s2Joint.checkedKnowledgeYes();
        s2Joint.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Joint");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "VLADYSLAV CHESALOV, V CH");
        app.sAssert().assertAll();
    }

    @Test(priority = 2)
    public void createAnotherJointAccountWithSameAddress() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountJoint();
        step1Account.clickSaveButton();
        S2Joint s2Joint = new S2Joint(app.getDriver());
        s2Joint.fillingJointInformationWithSameAddress("Vlad", "Ches", "01/27/1991",
                "98765423","09954679", "vladyslav.chesalov@p2h.com");
        s2Joint.checkedJCheckboxSameAddress();
        s2Joint.checkedFinStatus20000();
        s2Joint.checkedKnowledgeNo();
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
}
