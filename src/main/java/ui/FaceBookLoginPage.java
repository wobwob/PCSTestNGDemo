package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FaceBookLoginPage {
    public String url = "https://www.facebook.com/";

    String loginErrorXPath = "//*[@id=\"email_container\"]/div[2]";

    public void goTo() {
        Browser.goTo(url);
        Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
    }

    public void login(String username, String password) {
        Browser.driver.findElement(By.name("email")).sendKeys(username);
        Browser.driver.findElement(By.name("pass")).sendKeys(password);
        Browser.driver.findElement(By.name("login")).click();

        Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
    }

    public boolean loginPageIsShown() {
        List<WebElement> emailField = Browser.driver.findElements(By.name("email"));

        return !emailField.isEmpty();
    }

    public WebElement getLoginError() {
        List<WebElement> loginError = Browser.driver.findElements(By.xpath(loginErrorXPath));

        if (!loginError.isEmpty()) {
            return loginError.get(0);
        }

        return null;
    }
}
