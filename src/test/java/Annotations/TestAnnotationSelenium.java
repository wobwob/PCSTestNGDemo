package Annotations;

import org.testng.annotations.*;
import ui.Browser;
import ui.Pages;
import ui.User;

@Test
public class TestAnnotationSelenium {

    @BeforeClass
    public void beforeClass() {
        Browser.init();
    }

    @BeforeMethod
    public void beforeMethod() {
        Pages.FBLoginPage().goTo();
    }

    public void test1() { // successful login
        Pages.FBLoginPage().login(User.username, User.password);
        Pages.FBHomePage().openMessenger();
    }

    public void test2() { // unsuccessful login
        Pages.FBLoginPage().login("", "");
    }

    @AfterMethod
    public void afterMethod() {
        Pages.FB().logout();
    }

    @AfterClass
    public void afterClass() {
        Browser.close();
    }
}
