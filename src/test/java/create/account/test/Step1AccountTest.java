package create.account.test;

import create.CreateIndividualAccount;
import create.account.Step1Account;
import create.account.StepsBarAccount;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.CreateAccount;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class Step1AccountTest extends TestBase {

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
    public void testCancelButton() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.clickCancelButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getHeadingSidebar(), "Open A New Account");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testEmptyFields() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.clickSaveButton();
        app.sAssert().assertTrue(step1Account.getErrorMessage());
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void correctChooseAccount() {
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
        StepsBarAccount stepsBarAccount = new StepsBarAccount(app.getDriver());
        app.sAssert().assertEquals(stepsBarAccount.getActiveItem(), "Investor Info");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void activeStep1Account() {
        StepsBarAccount stepsBarAccount = new StepsBarAccount(app.getDriver());
        app.sAssert().assertEquals(stepsBarAccount.getActiveItem(), "Account");
        app.sAssert().assertAll();
    }
}
