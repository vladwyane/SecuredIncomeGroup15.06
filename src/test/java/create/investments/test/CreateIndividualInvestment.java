package create.investments.test;

import create.investment.Step1Invest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.IndividualInvestments;
import user.pages.UserAccounts;

public class CreateIndividualInvestment extends TestBase {

    @BeforeMethod
    public void createAccount() {
        app.goTo("http://securedincomegroup.stgng.co/");
        Register register = new Register(app.getDriver());
        register.signIn(app.testEmail, app.correctPassword);
    }


    @Test
    public void createAnothecountWithSameAddress() throws InterruptedException {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameInvestment();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment1Year();
        step1Invest.enterInvestmentAmount("50000");
        step1Invest.clickSaveButton();
        Thread.sleep(5000);

    }
}
