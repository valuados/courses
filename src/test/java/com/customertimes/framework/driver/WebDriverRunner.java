package com.customertimes.framework.driver;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.listeners.EventListener;
import com.customertimes.framework.listeners.Highlighter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverRunner {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverRunner() {
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            switch (TestConfig.CONFIG.browser()) {
                case "safari": {
                    WebDriverManager.safaridriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                }
                default: {
//                    if (TestConfig.CONFIG.remote()) {
//                        try {
//                            //System.setProperty("webdriver.chrome.driver","/Users/valuados/selenium/drivers/chromedriver");
//                            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//                            capabilities.setPlatform(Platform.WINDOWS);
//                            driver.set(new RemoteWebDriver(new URL(TestConfig.CONFIG.seleniumServerUrl()), capabilities));
//                        } catch (MalformedURLException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
//                    driver = new EventFiringWebDriver(new ChromeDriver());
                   // }
                }
            }
            driver.get().manage().window().maximize();
//            driver.register(new EventListener());
//            driver.register(new Highlighter());
        }
        return driver.get();
    }

    public static void closeWebDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}



