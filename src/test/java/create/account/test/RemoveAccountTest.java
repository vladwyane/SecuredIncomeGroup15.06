package create.account.test;

import create.account.RemoveAccount;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.Users;
import user.pages.UserAccounts;

public class RemoveAccountTest extends TestBase {

    @BeforeMethod
    public void signInAdmin() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn("admin", "!swGo4!KVtH9z^sEOUNfcB31");
    }

    @Ignore
    @Test(priority = 3)
    public void removeAccounts() {
        RemoveAccount removeAccount = new RemoveAccount(app.getDriver());
        removeAccount.removeNAccounts(10);
    }
}
