package Annotations;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;
import ui.User;

public class TestAnnotationAttributesSelenium {

    @BeforeClass
    public void beforeClass() {
        Browser.init();
    }

    @BeforeMethod
    public void beforeMethod() {
        Pages.FBLoginPage().goTo();
        if (!Pages.FBLoginPage().loginPageIsShown()) {
            throw new SkipException("Facebook login page did not load!");
        }
    }

    @Test(timeOut = 10000)
    public void test1() { // successful login
        Pages.FBLoginPage().login(User.username, User.password);

        Assert.assertEquals(Pages.FBHomePage().getWelcomeMessage().getText(),
                "Welcome to Facebook, User");
    }

    @Test(description = "Verify that user can not login to Facebook without providing credentials")
    public void test2() { // unsuccessful login
        Pages.FBLoginPage().login("", "");

        Assert.assertNull(Pages.FBHomePage().getWelcomeMessage());
        Assert.assertEquals(Pages.FBLoginPage().getLoginError().getText(),
                "The email address or phone number that you've entered doesn't match any account. " +
                        "Sign up for an account.");
    }

    @AfterMethod
    public void afterMethod() {
        Pages.FB().logout();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Browser.close();
    }
}
