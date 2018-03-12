package create.account.test;

import create.account.Step1Account;
import create.account.Step2Account;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class Step2AccountTest extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
    }


    @Test
    public void testCancelButton() throws InterruptedException {

        Step2Account step2Account = new Step2Account(app.getDriver());
        step2Account.enterBirthDate("29/11/2015");
        step2Account.enterSSN("123");
        step2Account.checkedCitizenFN();
        step2Account.enterStreetAddress("Alch");
        step2Account.chooseCountryUS();
        Thread.sleep(3000);
       // app.sAssert().assertEquals(step2Account.getValueFirstName(), "t");
       // app.sAssert().assertAll();
    }

}
