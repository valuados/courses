package com.customertimes.framework.driver;

import com.customertimes.framework.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverRunner {

    private static WebDriver driver;

    private WebDriverRunner() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            switch (TestConfig.CONFIG.browser()) {
                case "safari": {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}



