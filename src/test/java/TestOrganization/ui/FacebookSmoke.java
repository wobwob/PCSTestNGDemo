package TestOrganization.ui;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;

public class FacebookSmoke {

    @BeforeClass
    public void beforeClass() {
        Browser.init();
    }

    @BeforeMethod
    public void beforeMethod() {
        Pages.FBLoginPage().goTo();
    }

    @Test(groups = "Smoke")
    public void test1() { // checks that Facebook home page is shown
        Assert.assertTrue(Pages.FBLoginPage().loginPageIsShown(),
                "Facebook login page did not load!");
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
