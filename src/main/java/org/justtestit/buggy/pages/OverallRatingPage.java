package org.justtestit.buggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
public class OverallRatingPage {
        public OverallRatingPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//a[normalize-space()='Make']")
        public WebElement makeHeader;

        @FindBy(xpath = "//a[normalize-space()='Model']")
        public WebElement modelHeader;

        @FindBy(xpath = "//a[normalize-space()='Rank']")
        public WebElement rankHeader;

        @FindBy(xpath = "//a[normalize-space()='Votes']")
        public WebElement votesHeader;

        @FindBy(xpath = "//input[@type='text']")
        public WebElement inputPageNo;

        @FindBy(xpath = "//a[normalize-space()='»']")
        public WebElement nextPageButton;

}
