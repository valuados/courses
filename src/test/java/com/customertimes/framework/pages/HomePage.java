package com.customertimes.framework.pages;

import com.customertimes.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class HomePage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);

    private static String accountButton = "//span[contains(text(),'Аккаунт')]";
    private static String loginButton = "//button[@class='userToolsBtn']";
    private static String userSubtitleSpan = "//span[@class='userToolsSubtitle']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }


    public HomePage clickAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountButton)));
        driver.findElement(By.xpath(accountButton)).click();
        return this;
    }

    public  LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginButton)));
        driver.findElement(By.xpath(loginButton)).click();
        return new LoginPage(driver);
    }

    public boolean doesUserSubtitleSpanContainEmail(String email) {
        try {
        WebElement userSubtitle = wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(userSubtitleSpan))));
        return userSubtitle.getText().equals(email);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
