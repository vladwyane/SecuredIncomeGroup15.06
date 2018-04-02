package registration.pages.test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.CreateAccount;
import registration.pages.LostPassword;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class RegisterTest extends TestBase {

    @Ignore
    @Test
    public void testEmptyFields() throws InterruptedException {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.clickSignInButton();
        Thread.sleep(1000);
        app.sAssert().assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

   @Ignore
    @Test
    public void testErrorLogin() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.enterLogin("error");
        register.enterPassword(app.correctPassword);
        register.clickSignInButton();
        app.sAssert().assertEquals(register.getErrorMessage(), "We don't have any users with that email address. Maybe you used a different one when signing up?");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

   @Ignore
    @Test
    public void testErrorPassword() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.enterLogin(app.testEmail);
        register.enterPassword("v123ch");
        register.clickSignInButton();
        app.sAssert().assertEquals(register.getErrorMessage(), "The password you entered wasn't quite right. Did you forget your password?");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testErrorSpaces() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.enterLogin(" ");
        register.enterPassword(" ");
        register.clickSignInButton();
        app.sAssert().assertEquals(register.getErrorMessage(), "You do have an email address, right?");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertEquals(register.getLoginFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertEquals(register.getPasswordFieldCssValue("background-color"), "rgba(248, 248, 248, 1)");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testClearButton() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.enterLogin("error");
        register.enterPassword("v1234");
        register.clickCancelButton();
        app.sAssert().assertEquals(register.getLoginValue(), "");
        app.sAssert().assertEquals(register.getPasswordValue(), "");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testCreateAccountLink() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.clickCreateAccountLink();
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        app.sAssert().assertEquals(createAccount.getMainHeading(), "Create Your Account");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testResetPasswordLink() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.clickLostPasswordLink();
        LostPassword lostPassword = new LostPassword(app.getDriver());
        app.sAssert().assertEquals(lostPassword.getMainHeading(), "Enter your email address and we'll send you a link you can use to pick a new password.");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testCorrectSignIn() {
        app.goTo(app.securUrl);
        Register register = new Register(app.getDriver());
        register.enterLogin(app.testEmail);
        register.enterPassword(app.correctPassword);
        register.clickSignInButton();
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        app.sAssert().assertEquals(userAccounts.getHeadingSidebar(), "Open A New Account");
        app.sAssert().assertAll();
    }
}