package com.customertimes.tests;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.driver.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;


public class BaseTest {

    protected WebDriverWait wait;
    protected SoftAssert soft;
    protected String email = TestConfig.CONFIG.email();
    protected String password = TestConfig.CONFIG.password();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        System.out.println("Tests automation is started");
        soft = new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        System.out.println("Tests automation is ended");
        WebDriverRunner.closeWebDriver();
    }

    protected WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

}
