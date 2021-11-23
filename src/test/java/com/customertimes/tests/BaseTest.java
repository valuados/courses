package com.customertimes.tests;

import com.customertimes.framework.driver.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.out.println("Tests automation is started");
        driver = WebDriverRunner.getWebDriver();
    }


    @AfterSuite
    public void tearDown() {
        System.out.println("Tests automation is ended");
        WebDriverRunner.closeWebDriver();
    }

}
