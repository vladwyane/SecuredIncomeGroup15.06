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
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
    }

    @Test(priority = 1)
    public void createFirstEntityAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingInvestorInformation(Users.ADMIN);
        s2Entity.checkedCitizenFN();
        s2Entity.chooseCountryCanada();
        s2Entity.chooseProvinceAlberta();
        helperMethods.fillingEntityInformation(Users.ADMIN);
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

    @Test(priority = 2)
    public void createAnotherEntityAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingEntityInformation(Users.ADMIN);
        s2Entity.chooseEntityTypeCorporation();
        s2Entity.chooseECountryUS();
        s2Entity.chooseEStateNevada();
        s2Entity.checkedFinStatusAny();
        s2Entity.checkedKnowledgeNo();
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

    @Test(priority = 2)
    public void createAnotherEntityAccountWithSameAddress() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountEntity();
        step1Account.clickSaveButton();
        S2Entity s2Entity = new S2Entity(app.getDriver());
        s2Entity.checkedECheckboxSameAddress();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingEntitytInformationWithSameAddress(Users.ADMIN);
        s2Entity.chooseEntityTypeLLC();
        s2Entity.checkedFinStatus30000();
        s2Entity.checkedKnowledgeYes();
        s2Entity.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.agreeAll("Sign");
        step4Account.clickFinishButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getAccountType(), "Entity/Llc");
        app.sAssert().assertEquals(userAccounts.getAccountName(), "ENTITY");
        app.sAssert().assertAll();


    }

}
