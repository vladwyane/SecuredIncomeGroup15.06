package create.account.test;

import create.account.RemoveAccount;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.UserAccounts;

public class RemoveAccountTest extends TestBase {

    @BeforeMethod
    public void signInAdmin() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.ADMIN);
    }

    @Ignore
    @Test(priority = 3)
    public void removeAccounts() {
        RemoveAccount removeAccount = new RemoveAccount(app.getDriver());
        removeAccount.removeNAccounts(10);
    }
}
