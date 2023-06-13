package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.justtestit.buggy.pages.DefaultPage;
import org.justtestit.buggy.pages.OverallRatingPage;
import org.justtestit.buggy.pages.PopularMakePage;
import org.justtestit.buggy.pages.PopularModelPage;
import org.justtestit.buggy.pages.ProfilePage;
import org.justtestit.buggy.pages.RegisterPage;
import org.justtestit.buggy.utils.ScreenShotUtil;
import org.justtestit.buggy.utils.GenericUtils;

public class StepDefinitons {
	public WebDriver driver;
	private static String logon = "";
	private static String password = "";

    public void startDriver(String url){

        System.setProperty("webdriver.chrome.driver", new File("driver/chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            ScreenShotUtil screenShotUtil = new ScreenShotUtil();
            screenShotUtil.addScreenshot(scenario, driver);
        }
        driver.quit();
    }

	@Given("User is on the default page")
	public void user_is_on_the_default_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		String url = "https://buggy.justtestit.org";
		startDriver(url);
	}
	
	@When("User enters logon credentials {string} {string}")
	public void user_enters_credentials(String username, String password) {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.buggyRating);
		defaultpage.userName.sendKeys(username);
		defaultpage.passWord.sendKeys(password);
		defaultpage.login.click();
	}
	
	@Then("User should be able to see the logout button")
	public void user_should_be_able_to_see_the_logout_button() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.login);
	}
	
	@Then("User should be able to see the error message")
	public void user_should_be_able_to_see_the_error_message() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.errorMessage);
		String msg = defaultpage.errorMessage.getText();
		assertTrue(msg.contains("Invalid username/password"));
	}
	
	@Then("User should be able to logout successfully")
	public void user_should_be_able_to_logout_successfully() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		defaultpage.login.click();
		genericUtils.waitForElement(defaultpage.login);
		defaultpage.login.isDisplayed();
	}
	
	@When("User navigates to the register page")
	public DefaultPage user_navigates_to_the_register_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		defaultpage.registerButton.click();
		return defaultpage;
	}
	
	@Then("User should be able to register successfully")
    public void user_should_be_able_to_register_successfully() throws Throwable  {
    	RegisterPage registerpage = new RegisterPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		String logonName = genericUtils.randomString();
		genericUtils.waitForElement(registerpage.userName);
		registerpage.userName.sendKeys("testWestpac_"+logonName);
		registerpage.firstName.sendKeys("testFname_"+logonName);
		registerpage.lastName.sendKeys("testLname_"+logonName);
		registerpage.password.sendKeys("Password@1");
		registerpage.confirmPassword.sendKeys("Password@1");
		logon = registerpage.login.getText();
		registerpage.register.click();
		genericUtils.waitForElement(registerpage.successMessage);
		registerpage.successMessage.isDisplayed();

		//For new user logons
		logon = "testWestpac_"+logonName;
		password = "Password@1";

	}
	
	@When("User navigates to the profile page")
	public void user_navigates_to_the_profile_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.profileButton);
		defaultpage.profileButton.click();
	}

	@Then("User is able to edit his profile")
	public void user_is_able_to_edit_his_profile() {
		ProfilePage profilepage = new ProfilePage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		String logonName = genericUtils.randomString();
		genericUtils.waitForElement(profilepage.inputFirstName);
		profilepage.inputFirstName.clear();
		profilepage.inputFirstName.sendKeys("Fname"+logonName);
		profilepage.inputLastName.clear();
		profilepage.inputLastName.sendKeys("Lname"+logonName);
		profilepage.inputGender.clear();
		profilepage.inputGender.sendKeys("Male");
		profilepage.inputAge.clear();
		profilepage.inputAge.sendKeys("35");
		profilepage.inputAddress.clear();
		profilepage.inputAddress.sendKeys("test address");
		profilepage.inputPhone.clear();
		profilepage.inputPhone.sendKeys("12345678");
		Select option = new Select(profilepage.inputHobby);
		option.selectByIndex(1);
		profilepage.saveButton.click();
		genericUtils.waitForElement(profilepage.successmessage);
		assertTrue(profilepage.successmessage.getText().contains("The profile has been saved successful"));
	}
	
	@When("User navigates to the popular make page")
	public void user_navigates_to_the_popular_make_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.popularMakeButton);
		defaultpage.popularMakeButton.click();
	}

	@When("User selects a {string}")
	public void user_selects_a(String car) {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(popularmakepage.modelHeader);
		driver.findElement(By.xpath("//a[normalize-space()="+ car + "]")).click();
	}

	@Then("User should be able to navigate to the {string} page")
	public void user_should_be_able_to_navigate_to_page(String car) throws Throwable {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		Thread.sleep(10000);
		genericUtils.waitForElement(popularmakepage.facebookLogo);
		driver.findElement(By.xpath("//strong[text()="+ car + "]"));
	}

	@Then("User should be able to navigate to other pages")
	public void user_should_be_able_to_navigate_to_other_pages() {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(popularmakepage.nextPageButton);
		String pageOnetext = popularmakepage.pageNumberText.getText();
		assertTrue(pageOnetext.contains("page 1 of 2"));
		popularmakepage.nextPageButton.click();
		String pageTwotext = popularmakepage.pageNumberText.getText();
		assertTrue(pageTwotext.contains("page 2 of 2"));
	}
	
	@When("Logon with the new User")
	public void logon_with_the_new_User() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		defaultpage.userName.sendKeys(logon);
		defaultpage.passWord.sendKeys(password);
		defaultpage.login.click();
		genericUtils.waitForElement(defaultpage.login);
		}

	@When("User navigates to the popular model page")
	public void user_navigates_to_the_popular_model_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.popularModelButton);
		defaultpage.popularModelButton.click();
	}

	@Then("User is able to vote")
	public void user_is_able_to_vote() {
	   PopularModelPage popularmodelpage = new PopularModelPage(driver);
	   GenericUtils genericUtils = new GenericUtils(driver);
	   String CommentName = genericUtils.randomString();
	   genericUtils.waitForElement(popularmodelpage.inputComment);
	   popularmodelpage.inputComment.sendKeys("This is a test comment" +CommentName);
	   popularmodelpage.voteButton.click();
	   genericUtils.waitForElement(popularmodelpage.thankYouMessage);
	   popularmodelpage.thankYouMessage.isDisplayed();
	}

	@Then("Comment should be displayed on the page")
	public void comment_should_be_displayed_on_the_page() {
		PopularModelPage popularmodelpage = new PopularModelPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(popularmodelpage.firstComment);
		String comment = popularmodelpage.firstComment.getText();
		assertTrue(comment.contains("This is a test comment"));
	}
	
	@When("User navigates to the overall rating page")
	public void user_navigates_to_the_overall_rating_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.overallRating);
		defaultpage.overallRating.click();
	}

	@When("User clicks the buggy rating link")
	public void user_clicks_the_buggy_rating_link() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.buggyRating);
		defaultpage.buggyRating.click();
	}

	@Then("User should be able to navigate back to the default page")
	public void user_should_be_able_to_navigate_back_to_the_default_page() {
		DefaultPage defaultpage = new DefaultPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(defaultpage.popularModelButton);
		defaultpage.popularModelButton.isDisplayed();
	}
	
	@Then("Author name should be updated")
	public void author_name_should_be_updated() {
		PopularModelPage popularmodelpage = new PopularModelPage(driver);
		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.waitForElement(popularmodelpage.firstComment);
		String author = popularmodelpage.firstAuthor.getText();
		assertFalse(author.isEmpty());
	}
}
