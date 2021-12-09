package com.customertimes.tests.examples;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class AmazonTest extends BaseTest {

    @DataProvider(name = "test1")
    public Object[][] createData() {
        return new Object[][]{
                {"Amazon.com. Spend less. Smile more."}
        };
    }


    @Test(dataProvider = "test1")
    public void checkSiteTitle(String expectedTitle) {
        SoftAssert soft = new SoftAssert();
        getDriver().get("https://www.amazon.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = getDriver().getTitle();
        soft.assertEquals(actualTitle, expectedTitle, "Page title[" + actualTitle + "] is not equal to - " + expectedTitle);

        System.out.println(getDriver().findElement(By.xpath("//span[text()='English']")).isDisplayed());
        System.out.println(TestConfig.CONFIG.email());

        soft.assertAll();
    }
}
