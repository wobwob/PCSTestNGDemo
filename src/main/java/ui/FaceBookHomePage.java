package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FaceBookHomePage {
    public String url = "https://www.facebook.com/?sk=welcome";

    String welcomeMessageXPath = "//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]";
    String messengerIconXpath = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[2]";
    String dummyXpath = "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/span/div[1]";

    public void openMessenger() {
        Browser.driver.findElement(By.xpath(messengerIconXpath)).click();
        Browser.wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See all in Messenger"))).click();
        Browser.driver.findElement(By.xpath(dummyXpath)).click();

        Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
    }

    public WebElement getWelcomeMessage() {
        List<WebElement> welcomeMessage = Browser.driver.findElements
                (By.xpath(welcomeMessageXPath));

        if (!welcomeMessage.isEmpty()) {
            return welcomeMessage.get(0);
        }

        return null;
    }
}
