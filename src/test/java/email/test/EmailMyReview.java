package email.test;

import admin.pages.AdminDashboard;
import admin.pages.AdminNoInvestmentCreated;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.IndividualInvestments;
import user.pages.MyReview;
import user.pages.UserAccounts;

public class EmailMyReview extends TestBase {

    @Test (groups = "EmailMyReview", dependsOnGroups = "EmailRenewPortionInvesment", alwaysRun = true, priority = 74)
    public void sendMyReviewEmail() {
        app.goTo("http://securedincomegroup.stgng.co");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        UserAccounts userAccounts = new UserAccounts(app.getDriver());
        userAccounts.clickAccountNameIndividual();
        IndividualInvestments individualInvestments = new IndividualInvestments(app.getDriver());
        individualInvestments.clickLinkWriteReview();
        MyReview myReview = new MyReview(app.getDriver());
        myReview.enterMyReviewTextarea("My name is Vlad");
        myReview.checkedStarsRating4();
        myReview.clickButtonSubmitReview();
        app.sAssert().assertEquals(myReview.getMyReviewTextarea(), "My name is Vlad");
        app.sAssert().assertAll();
    }

    @Test (groups = "EmailMyReview", dependsOnGroups = "EmailRenewPortionInvesment", alwaysRun = true, priority = 76)
    public void testEmailMyReviewForAdmin() throws InterruptedException {
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLAD), "Customer Review.");
        app.sAssert().assertAll();
    }

}
