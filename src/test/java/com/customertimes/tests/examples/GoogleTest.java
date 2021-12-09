package com.customertimes.tests.examples;

import com.customertimes.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Method;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class GoogleTest extends BaseTest {

    WebDriverWait wait;
    SoftAssert soft;

    @BeforeClass
    public void setup() {
        soft = new SoftAssert();
        wait = new WebDriverWait(getDriver(), 5);
        prepareTestData();
    }

    @Test
    public void emptyTest() {
        System.out.println("Empty test");
    }

    @Test(description = "Open Google webpage", dependsOnMethods = "emptyTest")
    public void openGoogleTest() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String googleTitle = getDriver().getTitle();
        String expectedTitle = "Google";
        soft.assertEquals(googleTitle, expectedTitle, String.format("Page title should be '%1$s' instead of '%2$s'", googleTitle, expectedTitle));

        String myString = "Text for search";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        getDriver().findElement(By.name("q")).sendKeys(Keys.chord(Keys.COMMAND, "v"));
        getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button[@aria-label='Google Search']")))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Google Search']")));

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soft.assertAll();
    }

    @AfterMethod
    private void prepareNextTest(Method method) {
        switch (method.getName()) {
            case "openGoogleTest":
                System.out.println("openGoogleTest");
                break;
            default:
                System.out.println("All other tests");
        }
    }

    private void prepareTestData() {
        getDriver().get("https://google.com");
    }

}
