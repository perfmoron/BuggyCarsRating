package org.justtestit.buggy.utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element) {
        //Generic wait
       waitForElement(element, 10);
    }

    public void waitForElement(WebElement element, int seconds) {
        //waiting for a particular element
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            Assert.fail("Element not found on page: " + element);
        }
    }
    
    public String randomString() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
