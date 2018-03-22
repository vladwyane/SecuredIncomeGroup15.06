package email.test;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.Users;

public class EmailRetirementInvestment extends TestBase{

    @Test(groups = "EmailRetirementInvestment", dependsOnGroups = "CreateRetirementInvestment", alwaysRun = true, priority = 56)
    public void testEmailRetirementInvForUser() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "Your Retirement Investment Request Has Been Received");
        app.sAssert().assertAll();
    }

    @Test(groups = "EmailRetirementInvestment", dependsOnGroups = "CreateRetirementInvestment", alwaysRun = true, priority = 56)
    public void testEmailRetirementInvForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "SIG Website: PENDING RETIREMENT SETUP");
        app.sAssert().assertAll();
    }
}
