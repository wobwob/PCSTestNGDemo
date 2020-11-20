package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FaceBookMessengerPage {
    public String url = "https://www.facebook.com/messages/t";

    public void goTo() {
        Browser.goTo(url);
        Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
    }
}
