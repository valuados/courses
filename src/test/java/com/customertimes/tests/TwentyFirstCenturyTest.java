package com.customertimes.tests;

import com.customertimes.framework.pages.HomePage;
import com.customertimes.model.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;


public class TwentyFirstCenturyTest extends BaseTest {

    private static final String TWENTY_FIRST_CENTURY_URL = "https://www.21vek.by/";
    User user;
    HomePage homePage;

    @BeforeClass
    public void beforeClassMethod() {
        homePage = new HomePage(getDriver());
        user = User.newBuilder().withEmail(email).withPassword(password).build();
        getDriver().get(TWENTY_FIRST_CENTURY_URL);
    }

    @Test(description = "Verify login to 21vek.by")
    public void loginToTwentyFirstCenturyTest() {

        homePage.clickAccountButton()
                .clickLoginButton()
                .loginAs(user)
                .clickAccountButton();
        //File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        Assert.assertTrue(homePage.doesUserSubtitleSpanContainEmail(user.getEmail()),
                String.format("User subtitle span should contain '%s' email", user.getEmail()));
    }

    @AfterMethod
    private void afterMethod(Method method) {
        switch (method.getName()) {
            case "loginToTwentyFirstCenturyTest":
                getDriver().navigate().refresh();
                waitForLoad();
                break;
            default:
                System.out.println("All other tests");
        }
    }

    void waitForLoad() {
        new WebDriverWait(getDriver(), 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
