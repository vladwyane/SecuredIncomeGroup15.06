package create.account.test;

import admin.pages.Admin;
import common.elements.Header;
import common.elements.PageHeading;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.base.data.HelperMethods;
import test.base.data.Users;
import user.pages.Profile;

public class UpdateUserDate extends TestBase {

    @Test(groups = "UpdateUserProfile", dependsOnGroups = "EmailTerminateInvestment", alwaysRun = true, priority = 82)
    public void updateProfile() throws InterruptedException {
        app.goTo("http://securedincomegroup.stgng.co/");
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signIn(Users.CHESALOV);
        PageHeading pageHeading = new PageHeading(app.getDriver());
        pageHeading.clickLinkProfile();
        Profile profile = new Profile(app.getDriver());
        profile.clickCancelFormButton();
        profile.enterStreetAddress("Milutenka Street Update");
        profile.chooseCountryUS();
        profile.enterCity("Kharkiv Update");
        profile.chooseStateNevada();
        profile.enterPostalCode("9876");
        profile.enterPhoneNumber("0509881255");
        profile.clickUpdateFormButton();
        Thread.sleep(2000);
        Header header = new Header(app.getDriver());
        header.clickLinkSign();
        helperMethods.signIn(Users.ADMIN);
        Admin admin = new Admin(app.getDriver());
        admin.clickAdminBarLink();
        admin.clickItemMenuUser();
        admin.enterUserSearchInput("vladwyane");
        admin.clickUserSearchButton();
        Thread.sleep(2000);
        admin.clickEditUserLink();
        app.sAssert().assertEquals(admin.getUserFirstName(), "Vladyslav");
        app.sAssert().assertEquals(admin.getUserLastName(), "Chesalov");
        app.sAssert().assertEquals(admin.getUserEmail(), "vladwyane@gmail.com");
        app.sAssert().assertEquals(admin.getUserCity(), "Kharkiv Update");
        app.sAssert().assertEquals(admin.getUserPhoneNumber(), "0509881255");
        app.sAssert().assertEquals(admin.getUserPostCode(), "9876");
        app.sAssert().assertEquals(admin.getUserCountry(), "Unated States");
        app.sAssert().assertEquals(admin.getUserState(), "Nevada");
        app.sAssert().assertAll();

    }
}
