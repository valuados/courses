package com.customertimes.framework.pages;

import com.customertimes.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends AbstractPage {

    WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Аккаунт')]")
    private WebElement accountButton;

    @FindBy(xpath = "//button[@class='userToolsBtn']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='userToolsSubtitle']")
    private WebElement userSubtitleSpan;

    public HomePage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
    }


    public HomePage clickAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountButton.click();
        return this;
    }

    public  LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage(driver);
    }

    public boolean doesUserSubtitleSpanContainEmail(String email) {
        try {
        WebElement userSubtitle = wait.until(ExpectedConditions.visibilityOf(userSubtitleSpan));
        return userSubtitle.getText().equals(email);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
