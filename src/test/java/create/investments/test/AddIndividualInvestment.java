package create.investments.test;

import common.elements.Header;
import create.investment.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class AddIndividualInvestment extends TestBase {

    @BeforeMethod
    public void signInAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
    }

    @Ignore
    @Test
    public void addCountInvestments(int count) throws InterruptedException {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkAddToInvestment();
        individualInvestments.enterAddInvestment("100");
        individualInvestments.clickSubmitFundingButton();
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        Thread.sleep(3000);



    }
}
