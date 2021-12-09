package com.customertimes.cucumber;

import com.customertimes.framework.pages.HomePage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class LoginStepDefs {

    private LoginPage loginPage = new LoginPage(getWebDriver());
    private HomePage homePage = new HomePage(getWebDriver());

    @Given("User goes to login page")
    public void userGoesToLoginPage() {
        homePage
                .clickAccountButton()
                .clickLoginButton();
    }

    @When("User enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        loginPage
                .enterEmail(email)
                .enterPassword(password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.submitCredentials();
        loginPage.waitForSubmitAuthorizationButtonDisappear();
    }

    @Then("User {string} should be logged to application")
    public void userShouldBeLoggedToApplication(String email) {
        homePage.clickAccountButton();

        Assert.assertTrue(homePage.doesUserSubtitleSpanContainEmail(email),
                String.format("User subtitle span should contain '%s' email", email));
    }
}

