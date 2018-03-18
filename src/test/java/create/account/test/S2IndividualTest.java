package create.account.test;

import create.account.Step1Account;
import create.account.step2account.S2Individual;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.UserAccounts;

public class S2IndividualTest extends TestBase{

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickOpenAccountLink();
        Step1Account step1Account = new Step1Account(app.getDriver());
        step1Account.chooseAccountIndividual();
        step1Account.clickSaveButton();
    }

    @Ignore
    @Test
    public void testCancelButton() throws InterruptedException {

        S2Individual s2Individual = new S2Individual(app.getDriver());
        s2Individual.enterFirstName("Vlad");
        Thread.sleep(3000);
        s2Individual.enterLastName("Last");
        Thread.sleep(3000);
        s2Individual.enterBirthDate("09/11/2015");
        s2Individual.enterSSN("123");
        s2Individual.checkedCitizenFN();
        s2Individual.enterStreetAddress("Alch");
        s2Individual.chooseCountryUS();
        Thread.sleep(3000);
       // app.sAssert().assertEquals(s2Individual.getValueFirstName(), "t");
       // app.sAssert().assertAll();
    }

}
