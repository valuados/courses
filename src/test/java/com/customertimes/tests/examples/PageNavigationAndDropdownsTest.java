package com.customertimes.tests.examples;

import com.customertimes.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class PageNavigationAndDropdownsTest extends BaseTest {

    private static final String SELECT_EXAMPLE_WEB_SITE = "http://demo.guru99.com";
    private static String COUNTRY_DROPDOWN_TITLE_LOCATOR = "//form//td[.//b[contains(text(), 'Country')]]";
    private static String COUNTRY_SELECT_LOCATOR = COUNTRY_DROPDOWN_TITLE_LOCATOR + "/following-sibling::*/select";

    @BeforeClass
    public void setup() {
        getWebDriver().get(SELECT_EXAMPLE_WEB_SITE);
    }

    @Test
    public void checkNavigateMethodTest() {
        getWebDriver().navigate().to(SELECT_EXAMPLE_WEB_SITE + "/test/newtours/register.php");
        WebElement dropdownPageHeaderElement = getWebDriver().findElement(By.xpath(COUNTRY_DROPDOWN_TITLE_LOCATOR));
        Assert.assertTrue(dropdownPageHeaderElement.isDisplayed(), "Country header for 'Dropdown' page is not visible");
        Select gender = new Select(getWebDriver().findElement(By.xpath(COUNTRY_SELECT_LOCATOR)));
        gender.selectByIndex(1);
    }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethodActions() {
//        getWebDriver().navigate().refresh();
//        try{
//            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(DROPDOWN_PAGE_HEADER_LOCATOR))));
//        }catch (TimeoutException e) {
//            throw new TimeoutException("Page header for 'Dropdown' page was not found");
//        }
//    }

}
