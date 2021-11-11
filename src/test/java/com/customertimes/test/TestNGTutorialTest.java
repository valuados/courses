package com.customertimes.test;

import com.customertimes.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGTutorialTest extends BaseTest {

    @DataProvider(name = "test1")
    public Object[][] createData() {
        return new Object[][]{
                {"Google", 1},
                {"Onliner", 2}
        };
    }


    @Test(dataProvider = "test1")
    public void checkSiteTitle(String expectedTitle, int number) {
        SoftAssert soft = new SoftAssert();
        driver.get("https://google.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = driver.getTitle();
        System.out.println("Number" + number);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title[" + actualTitle + "] is not equal to - " + expectedTitle);
    }
}
