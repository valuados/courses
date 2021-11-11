package com.customertimes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AppTest extends BaseTest
{
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @Test(description = "Open Google webpage")
    public void OpenGoogleTest()
    {
        driver.get("https://google.com");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String googleTitle = driver.getTitle();
        String expectedTitle = "Googl";
        Assert.assertEquals(googleTitle, expectedTitle, String.format("Page title should be '%s' instead of '%s'", googleTitle, expectedTitle));

    }

    @Test(description = "Open Google webpage")
    public void SendSomethingTest()
    {
        SoftAssert soft = new SoftAssert();
        driver.get("https://google.com");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String googleTitle = driver.getTitle();
        String expectedTitle = "Onliner";
        soft.assertTrue("dof".equals("lol"), "2");
        soft.assertTrue("cow".equals("mow"), "1");
        soft.assertEquals(googleTitle, expectedTitle, String.format("Page title should be '%1$s' instead of '%2$s'", googleTitle, expectedTitle));
        soft.assertAll();
    }

    @Test
    public void JavaStringTest()
    {
        int i = 1;
        String accountDescription = "abc" + "_" + (i + 1);
        System.out.println(accountDescription);
    }
}
