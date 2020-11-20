package TestOrganization.ui;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;
import ui.User;

@Test(groups = "Login")
public class FacebookPageLogin {

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

    @DataProvider
    private Object[][] testLoginFailProvider() {
        return new Object[][]{
                {""},
                {"123"},
                {"password"}
        };
    }

    @Test(dependsOnGroups = "Smoke")
    public void test1() { // successful login
        Pages.FBLoginPage().login(User.username, User.password);
        Assert.assertEquals(Pages.FBHomePage().getWelcomeMessage().getText(),
                "Welcome to Facebook, User");
    }

    @Test(dataProvider = "testLoginFailProvider", dependsOnGroups = "Smoke")
    public void testLoginFail(String password) { // unsuccessful login
        Pages.FBLoginPage().login("", password);

        Assert.assertNotEquals(Browser.driver.getCurrentUrl(),
                Pages.FBHomePage().url);
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
