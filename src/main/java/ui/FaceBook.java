package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FaceBook {
    String accountMenuXpath = "//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/span/div";
    String logoutBtnXpath = "//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[1]";

    public void logout() {
        List<WebElement> accountMenu = Browser.driver.findElements(By.xpath(accountMenuXpath));
        if (!accountMenu.isEmpty()) {
            accountMenu.get(0).click();
            Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(logoutBtnXpath))).click();
        }
    }
}
