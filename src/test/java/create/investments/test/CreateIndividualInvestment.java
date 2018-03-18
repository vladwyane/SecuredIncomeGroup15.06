package create.investments.test;

import create.investment.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.pages.Register;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
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
    public void createIndInvest3Month() {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Month();
        step1Invest.enterInvestmentAmount("5000");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingDividendInformation(Users.MANAGER);
        step2Invest.chooseDivCountryCanada();
        step2Invest.chooseDivProvinceAlberta();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByCheckButton();
        step5Invest.clickFinishButton();

    }

    @Test
    public void createIndInvest6Month() {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment6Month();
        step1Invest.enterInvestmentAmount("5,000");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
    }

    @Test
    public void createIndInvest1Year() {
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment1Year();
        step1Invest.enterInvestmentAmount("10,000.01");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedRolloverDividends();
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.fillingDividendInformation(Users.VLAD);
        step2Invest.chooseDivCountryUS();
        step2Invest.chooseDivStateNevada();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByCheckButton();
        step5Invest.clickFinishButton();
    }

    @Test
    public void createIndInvest3Year(){
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkCreateInvestment();
        Step1Invest step1Invest = new Step1Invest(app.getDriver());
        step1Invest.chooseInvestment3Year();
        step1Invest.enterInvestmentAmount("25000.99");
        step1Invest.clickSaveButton();
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.checkedPayoutDividends();
        step2Invest.checkedDivCheckboxSameAddress();
        step2Invest.clickSaveButton();
        Step3Invest step3Invest = new Step3Invest(app.getDriver());
        step3Invest.clickConfirmButton();
        Step4Invest step4Invest = new Step4Invest(app.getDriver());
        step4Invest.agreeAll("si");
        step4Invest.clickFinishButton();
        Step5Invest step5Invest = new Step5Invest(app.getDriver());
        step5Invest.clickFundByWireButton();
        step5Invest.clickMyAccountButton();
    }
}
