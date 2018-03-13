package create;

import create.account.Step1Account;
import create.account.Step2Account;
import create.account.Step3Account;
import create.account.Step4Account;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
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

    public void newAccount() {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        Step2Account step2Account = new Step2Account(app.getDriver());
        step2Account.checkedFinStatusAny();
        step2Account.checkedKnowledgeNo();
        step2Account.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.checkedCheckboxReview();
        step4Account.checkedCheckboxTaxpayer();
        step4Account.checkedCheckboxElectronic();
        step4Account.enterSignature("test");
        step4Account.clickFinishButton();

    }


    @Test
    public void testCancelButton() throws InterruptedException {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        Step2Account step2Account = new Step2Account(app.getDriver());
        step2Account.enterFirstName("Vlad");
        step2Account.enterLastName("Ches");
        step2Account.enterBirthDate("07/11/1987");
        step2Account.enterSSN("123456789");
        step2Account.checkedCitizenFN();
        step2Account.enterStreetAddress("Holodna Gora");
        step2Account.chooseCountryUS();
        step2Account.enterCity("Alchevsk");
        step2Account.chooseStateAlabama();
        step2Account.enterPostalCode("1234");
        step2Account.enterPhoneNumber("0668843478");
        step2Account.enterEmail("vladwyane@gmail.com");
        step2Account.checkedFinStatus20000();
        step2Account.checkedKnowledgeYes();
        step2Account.clickSaveButton();
        Step3Account step3Account = new Step3Account(app.getDriver());
        step3Account.clickConfirmButton();
        Step4Account step4Account = new Step4Account(app.getDriver());
        step4Account.checkedCheckboxReview();
        step4Account.checkedCheckboxTaxpayer();
        step4Account.checkedCheckboxElectronic();
        step4Account.enterSignature("test");
        step4Account.clickFinishButton();
        for (int i = 0; i < 2; i++) {
            newAccount();
        }





        // app.sAssert().assertEquals(step2Account.getValueFirstName(), "t");
        // app.sAssert().assertAll();
    }

}
