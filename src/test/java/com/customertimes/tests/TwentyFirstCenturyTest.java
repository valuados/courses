package com.customertimes.tests;

import com.customertimes.framework.pages.HomePage;
import com.customertimes.model.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class TwentyFirstCenturyTest extends BaseTest {

    private static final String TWENTY_FIRST_CENTURY_URL = "https://www.21vek.by/";
    User user;
    HomePage homePage = new HomePage(getWebDriver());

    @BeforeClass
    public void beforeClassMethod() {
        user = User.newBuilder().withEmail(email).withPassword(password).build();
        getWebDriver().get(TWENTY_FIRST_CENTURY_URL);
    }

    @Test(description = "Verify login to 21vek.by")
    public void loginToTwentyFirstCenturyTest() {

        homePage.clickAccountButton()
                .clickLoginButton()
                .loginAs(user)
                .clickAccountButton();
        Assert.assertTrue(homePage.doesUserSubtitleSpanContainEmail(user.getEmail()),
                String.format("User subtitle span should contain '%s' email", user.getEmail()));
    }

//
//        wait = new WebDriverWait(getWebDriver(), 5);
//        boolean result = wait.until((ExpectedCondition<Boolean>) driver -> {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            if (js.executeScript("return document.readyState;").equals("complete")){
//                return Boolean.TRUE;
//            }
//            return Boolean.FALSE;
//        });

    @AfterMethod
    private void afterMethod(Method method) {
        switch (method.getName()) {
            case "loginToTwentyFirstCenturyTest":
                getWebDriver().navigate().refresh();
                wait.until((ExpectedCondition<Boolean>) driver -> {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    if (js.executeScript("return document.readyState;").equals("complete")) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                });
                break;
            default:
                System.out.println("All other tests");
        }
    }
}
