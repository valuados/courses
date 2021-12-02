package com.customertimes.framework.pages;

import com.customertimes.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class LoginPage extends AbstractPage {

    private static String emailInput = "//div[@class='style_inputContainer__2tRgM undefined']/input[@label='Электронная почта']";
    private static String passwordInput = "//div[@class='style_inputContainer__2tRgM undefined']/input[@label='Пароль']";
    private static String submitAuthorizationButton = "//div[@class='style_actions__2mIsz']/button";


    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath(emailInput)).clear();
        driver.findElement(By.xpath(emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath(passwordInput)).clear();
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public void submitCredentials() {
        driver.findElement(By.xpath(submitAuthorizationButton)).click();
    }

    public HomePage waitForSubmitAuthorizationButtonDisappear() {
        try{
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(submitAuthorizationButton))));
            return new HomePage(driver);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("'Submit Authorization' Button was not found");
        }

    }


    public HomePage loginAs(User user) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submitAuthorizationButton)));
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        submitCredentials();
        waitForSubmitAuthorizationButtonDisappear();
        return new HomePage(driver);
    }
}
