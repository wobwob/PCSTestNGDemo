package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Browser {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void init() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(Browser.driver, 5);
    }

    public static void goTo(String url) {
        driver.get(url);
    }

    public static void close() {
        driver.close();
    }
}
