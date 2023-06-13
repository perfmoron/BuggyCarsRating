package org.justtestit.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement login;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    public WebElement register;

    @FindBy(xpath = "//div[contains(text(),'Registration is successful')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'UsernameExistsException: User already exists')]")
    public WebElement errorMessage;

}
