package registration.pages.test;

import create.investments.Step1;
import org.testng.annotations.Test;
import registration.pages.CreateAccount;
import registration.pages.Register;
import test.base.TestBase;

public class CreateAccountTest extends TestBase {

    @Test (groups = "registration")
    public void testCorrectRegistration() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.enterFirstName("Vladyslav");
        createAccount.enterLastName("Chesalov");
        createAccount.enterLogin(app.testEmail);
        createAccount.enterPassword(app.correctPassword);
        createAccount.clickCaptcha();
        Thread.sleep(3000);
        createAccount.clickSubmitButton();
        //Waiting for the email to be sent
        Thread.sleep(5000);
        Step1 step1 = new Step1(app.getDriver());
        app.sAssert().assertEquals(step1.getMainHeading(), "Account Information");
        app.sAssert().assertAll();
    }

    @Test
    public void testEmptyFields() {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.clickSubmitButton();
        app.sAssert().assertEquals(createAccount.getErrorMessage(), "The Google reCAPTCHA check failed. Are you a robot?");
        app.sAssert().assertEquals(createAccount.getEmailFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(createAccount.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(createAccount.getEmailFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(createAccount.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

    @Test (dependsOnGroups = "registration")
    public void testSameEmail() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.enterLogin(app.testEmail);
        createAccount.enterPassword(app.correctPassword);
        createAccount.clickCaptcha();
        Thread.sleep(3000);
        createAccount.clickSubmitButton();
        Thread.sleep(2000);
        app.sAssert().assertEquals(createAccount.getErrorMessage(), "An account exists with this email address.");
        app.sAssert().assertEquals(createAccount.getEmailFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(createAccount.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(createAccount.getEmailFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(createAccount.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

    @Test
    public void testClearButton() {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.enterLogin(app.testEmail);
        createAccount.enterPassword(app.correctPassword);
        createAccount.clickCancelButton();
        app.sAssert().assertEquals(createAccount.getEmailValue(), "");
        app.sAssert().assertEquals(createAccount.getPasswordValue(), "");
        app.sAssert().assertAll();
    }

    @Test
    public void testSignInLink() {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.clickSignInLink();
        Register register = new Register(app.getDriver());
        app.sAssert().assertEquals(register.getCreateAccountLinkValue(), "Create Account Now");
        app.sAssert().assertAll();
    }

    @Test (dependsOnGroups = "registration")
    public void testCheckMail1() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(), "Welcome To Secured Income Group");
        app.sAssert().assertAll();
    }
}
