package DataProviders;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;

public class TestDataProviderSelenium {

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

    @Test(dataProvider = "testLoginFailProvider")
    public void testLoginFail(String password) { // unsuccessful login
        Pages.FBLoginPage().login("", password);

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
