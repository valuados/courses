package com.customertimes.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class GoogleTest extends BaseTest {

    @Test(description = "Open Google webpage")
    public void openGoogleTest() {
        SoftAssert soft = new SoftAssert();
        getWebDriver().get("https://google.com");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String googleTitle = getWebDriver().getTitle();
        String expectedTitle = "Google";
        soft.assertEquals(googleTitle, expectedTitle, String.format("Page title should be '%1$s' instead of '%2$s'", googleTitle, expectedTitle));

        String myString = "Text for search";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        getWebDriver().findElement(By.name("q")).sendKeys(Keys.chord(Keys.COMMAND, "v"));

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soft.assertAll();
    }
}
