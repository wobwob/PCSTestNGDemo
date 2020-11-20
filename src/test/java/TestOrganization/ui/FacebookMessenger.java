package TestOrganization.ui;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;
import ui.User;

@Test(dependsOnGroups = "Login", groups = "Messenger")
public class FacebookMessenger {

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

    @Test
    public void test1() { // successful login
        Pages.FBLoginPage().login(User.username, User.password);
        Pages.FBHomePage().openMessenger();

        Assert.assertEquals(Browser.driver.getCurrentUrl(),
                Pages.FBMessengerPage().url);

        //Some meaningful assertions go here
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
