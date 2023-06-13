package org.justtestit.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {

    @FindBy(linkText = "Buggy Rating")
    public WebElement buggyRating;

    @FindBy(linkText = "Register")
    public WebElement register;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement login;

    @FindBy(name = "login")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement passWord;

    @FindBy(xpath = "//span[contains(text(),'Hi')] ")
    public WebElement greeting;

    @FindBy(xpath = "//a[normalize-space()='Profile']")
    public WebElement profileButton;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//img[@title='Lamborghini']")
    public WebElement popularMakeButton;

    @FindBy(xpath = "//img[@title='Diablo']")
    public WebElement popularModelButton;

    @FindBy(xpath = "//span[contains(text(),'Invalid username/password')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/overall']")
    public WebElement overallRating;

    @FindBy(linkText = "Profile")
    public WebElement profile;

    public DefaultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginAvailable() {
        return login.isEnabled();
    }

}
