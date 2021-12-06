package com.customertimes.tests;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.driver.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println("Tests automation is ended");
        WebDriverRunner.closeWebDriver();
    }

    protected WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

}
