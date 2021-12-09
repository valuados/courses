package com.customertimes.framework.pages;

import com.customertimes.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='style_inputContainer__2tRgM undefined']/input[@label='Электронная почта']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='style_inputContainer__2tRgM undefined']/input[@label='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='style_actions__2mIsz']/button")
    private WebElement submitAuthorizationButton;

    By submitAuthorizationButtonLocator = By.xpath("//div[@class='style_actions__2mIsz']/button");

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
    }

    @Step
    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    @Step
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public LoginPage submitCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(submitAuthorizationButton));
        submitAuthorizationButton.click();
        return this;
    }

    @Step
    public HomePage waitForSubmitAuthorizationButtonDisappear() {
        try{
            wait.until(ExpectedConditions.numberOfElementsToBe(submitAuthorizationButtonLocator, 0));
            return new HomePage(driver);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("'Submit Authorization' Button was not found");
        }

    }


    @Step("Login as {0}")
    public HomePage loginAs(User user) {
        wait.until(ExpectedConditions.elementToBeClickable(submitAuthorizationButton));
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        submitCredentials();
        waitForSubmitAuthorizationButtonDisappear();
        return new HomePage(driver);
    }
}
