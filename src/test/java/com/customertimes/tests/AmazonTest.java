package com.customertimes.tests;

import com.customertimes.framework.config.TestConfig;
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
        getWebDriver().get("https://www.amazon.com/");
        getWebDriver().get("https://www.amazon.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = getWebDriver().getTitle();
        soft.assertEquals(actualTitle, expectedTitle, "Page title[" + actualTitle + "] is not equal to - " + expectedTitle);

        System.out.println(getWebDriver().findElement(By.xpath("//span[text()='English']")).isDisplayed());
        System.out.println(TestConfig.CONFIG.email());

        soft.assertAll();
    }
}
