package registration.pages.test;

import org.testng.annotations.*;
import registration.pages.LostPassword;
import test.base.TestBase;
import test.base.data.Users;

public class LostPasswordTest extends TestBase{

    @Ignore
    @Test
    public void testCheckMailReset() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/member-password-lost/");
        LostPassword lostPassword = new LostPassword(app.getDriver());
        lostPassword.enterUserLogin(app.testEmail);
        lostPassword.clickResetPasswordButton();
        //Waiting for the email to be sent
        Thread.sleep(5000);
        app.sAssert().assertEquals(app.checkGoogleMail(Users.VLADWYANE), "[Secured Income Group] - Reset Password");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testClearButton() {
        app.goTo("http://securedincomegroup.stgng.co/member-password-lost/");
        LostPassword lostPassword = new LostPassword(app.getDriver());
        lostPassword.enterUserLogin(app.testEmail);
        lostPassword.clickCancelButton();
        app.sAssert().assertEquals(lostPassword.getUserLoginValue(), "");
        app.sAssert().assertAll();
    }

    @Ignore
    @Test
    public void testEmptyFields() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/member-password-lost/");
        LostPassword lostPassword = new LostPassword(app.getDriver());
        lostPassword.clickResetPasswordButton();
        Thread.sleep(1000);
        app.sAssert().assertEquals(lostPassword.getUserLoginFieldCssValue("border-color"), "rgb(255, 21, 31)");
        app.sAssert().assertAll();
    }
}
