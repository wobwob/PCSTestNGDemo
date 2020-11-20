package Assertions;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;
import ui.User;

@Test
public class TestAssertionSelenium {

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

    public void test1() { // successful login
        Pages.FBLoginPage().login(User.username, User.password);

        Assert.assertEquals(Browser.driver.getCurrentUrl(),
                Pages.FBHomePage().url);
        Assert.assertEquals(Pages.FBHomePage().getWelcomeMessage().getText(),
                "Welcome to Facebook, User");

        Pages.FBHomePage().openMessenger();

        Assert.assertEquals(Browser.driver.getCurrentUrl(),
                Pages.FBMessengerPage().url);
    }

    public void test2() { // unsuccessful login
        Pages.FBLoginPage().login("", "");

        Assert.assertNotEquals(Browser.driver.getCurrentUrl(),
                Pages.FBHomePage().url);
        Assert.assertNull(Pages.FBHomePage().getWelcomeMessage());

        Assert.assertEquals(Pages.FBLoginPage().getLoginError().getText(),
                "Wrong credentials\n" +
                        "Invalid username or password");
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
