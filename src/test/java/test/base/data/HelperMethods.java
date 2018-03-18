package test.base.data;

import create.account.step2account.S2Entity;
import create.account.step2account.S2Individual;
import create.account.step2account.S2Joint;
import create.account.step2account.S2Retirement;
import create.investment.Step2Invest;
import registration.pages.CreateAccount;
import registration.pages.Register;
import test.base.TestBase;
import user.pages.UserAccounts;

public class HelperMethods extends TestBase{

    public void fillingInvestorInformation(Users users) {
        S2Individual s2Individual = new S2Individual(app.getDriver());
        s2Individual.enterFirstName(users.getFirstUserName());
        s2Individual.enterLastName(users.getLastUserName());
        s2Individual.enterBirthDate(users.getBirthDate());
        s2Individual.enterSSN(users.getSSN());
        s2Individual.enterStreetAddress(users.getStAddress());
        s2Individual.enterCity(users.getCity());
        s2Individual.enterPostalCode(users.getPCode());
        s2Individual.enterPhoneNumber(users.getPhNumber());
        s2Individual.enterEmail(users.getEmail());
    }

    public void fillingEntityInformation(Users users) {
        S2Entity s2Entity = new S2Entity(app.getDriver());
        s2Entity.enterEntityName(users.getEntityName());
        s2Entity.enterPositionTitle(users.getPosition());
        s2Entity.enterTaxNumber(users.getTaxNum());
        s2Entity.enterEStreetAddress(users.getStAddress());
        s2Entity.enterECity(users.getCity());
        s2Entity.enterEPostalCode(users.getPCode());
        s2Entity.enterEPhoneNumber(users.getPhNumber());
        s2Entity.enterEEmail(users.getEmail());
    }

    public void fillingEntitytInformationWithSameAddress(Users users) {
        S2Entity s2Entity = new S2Entity(app.getDriver());
        s2Entity.enterEntityName(users.getEntityName());
        s2Entity.enterPositionTitle(users.getPosition());
        s2Entity.enterTaxNumber(users.getTaxNum());
    }

    public void fillingJointInformation(Users users) {
        S2Joint s2Joint = new S2Joint(app.getDriver());
        s2Joint.enterJFirstName(users.getFirstUserName());
        s2Joint.enterJLastName(users.getLastUserName());
        s2Joint.enterJBirthDate(users.getBirthDate());
        s2Joint.enterJSSN(users.getSSN());
        s2Joint.enterJStreetAddress(users.getStAddress());
        s2Joint.enterJCity(users.getCity());
        s2Joint.enterJPostalCode(users.getPCode());
        s2Joint.enterJPhoneNumber(users.getPhNumber());
        s2Joint.enterJEmail(users.getEmail());

    }

    public void fillingJointInformationWithSameAddress(Users users) {
        S2Joint s2Joint = new S2Joint(app.getDriver());
        s2Joint.enterJFirstName(users.getFirstUserName());
        s2Joint.enterJLastName(users.getLastUserName());
        s2Joint.enterJBirthDate(users.getBirthDate());
        s2Joint.enterJSSN(users.getSSN());
        s2Joint.enterJPhoneNumber(users.getPhNumber());
        s2Joint.enterJEmail(users.getEmail());
    }

    public void fillingRInvestorInformation(Users users) {
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.enterFirstName(users.getFirstUserName());
        s2Retirement.enterLastName(users.getLastUserName());
        s2Retirement.enterBirthDate(users.getBirthDate());
        s2Retirement.enterStreetAddress(users.getStAddress());
        s2Retirement.enterCity(users.getCity());
        s2Retirement.enterPostalCode(users.getPCode());
        s2Retirement.enterPhoneNumber(users.getPhNumber());
        s2Retirement.enterEmail(users.getEmail());

    }

    public void fillingRetirementInformation(Users users) {
        S2Retirement s2Retirement = new S2Retirement(app.getDriver());
        s2Retirement.enterRetireCustodianName(users.getRetireName());
        s2Retirement.enterRetirementStreetAddress(users.getStAddress());
        s2Retirement.enterRetCity(users.getCity());
        s2Retirement.enterRetPostalCode(users.getPCode());
        s2Retirement.enterRetPhoneNumber(users.getPhNumber());
        s2Retirement.enterRetEmail(users.getEmail());
    }

    public void fillingDividendInformation(Users users) {
        Step2Invest step2Invest = new Step2Invest(app.getDriver());
        step2Invest.enterDivFullName(users.getDivFullName());
        step2Invest.enterDivSecondaryAddress(users.getSecondAddress());
        step2Invest.enterDivStreetAddress(users.getStAddress());
        step2Invest.enterDivCity(users.getCity());
        step2Invest.enterDivPostalCode(users.getPCode());
    }

    public void signIn(Users users) {
        Register register = new Register(app.getDriver());
        register.enterLogin(users.getEmail());
        register.enterPassword(users.getPassword());
        register.clickSignInButton();
    }

    public void registration(Users users) throws InterruptedException {
        CreateAccount createAccount = new CreateAccount(app.getDriver());
        createAccount.enterFirstName(users.getFirstUserName());
        createAccount.enterLastName(users.getLastUserName());
        createAccount.enterLogin(users.getEmail());
        createAccount.enterPassword(users.getPassword());
        createAccount.clickCaptcha();
        Thread.sleep(3000);
        createAccount.clickSubmitButton();
    }


}
