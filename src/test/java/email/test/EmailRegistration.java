package email.test;

import create.account.Step1Account;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;

public class EmailRegistration extends TestBase{

    @Ignore
    @Test (groups = "Registration", priority = 2)
    public void testCorrectRegistration() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/registration/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.registration(Users.CHESALOV);
        Step1Account step1Account = new Step1Account(app.getDriver());
        app.sAssert().assertEquals(step1Account.getMainHeading(), "Account Information");
        app.sAssert().assertAll();
    }

    @Test (groups = "Registration", priority = 4)
    public void testEmailRegistrationForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Welcome To Secured Income Group");
        app.sAssert().assertAll();
    }

    @Test (groups = "Registration", priority = 6)
    public void testEmailRegistrationForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "[SecuredIncomeGroup] New User Registration");
        app.sAssert().assertAll();
    }
}
