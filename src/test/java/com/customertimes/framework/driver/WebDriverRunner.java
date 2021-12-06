package com.customertimes.framework.driver;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.listeners.EventListener;
import com.customertimes.framework.listeners.Highlighter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
//                    driver = new EventFiringWebDriver(new SafariDriver());
                    break;
                }
                default: {
                    if (TestConfig.CONFIG.remote()) {
                        try {
//                            DesiredCapabilities capabilities = new DesiredCapabilities();
//                            capabilities.setBrowserName("chrome");
//                            capabilities.setPlatform(Platform.MAC);
//                            ChromeOptions options = new ChromeOptions();
//                            options.setHeadless(true);
//                            options.merge(capabilities);
                            driver = new RemoteWebDriver(new URL(TestConfig.CONFIG.seleniumServerUrl()), DesiredCapabilities.chrome());
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
//                    driver = new EventFiringWebDriver(new ChromeDriver());
                    }
                }
            }
            driver.manage().window().maximize();
//            driver.register(new EventListener());
//            driver.register(new Highlighter());
        }
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}



