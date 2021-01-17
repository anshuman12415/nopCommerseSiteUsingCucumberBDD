package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

	}

	@When("user open URL {string}")
	public void user_open_URL(String url) {
		driver.get(url);

	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);

	}

	@When("click on login")
	public void click_on_login() {
		lp.clickLogin();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws Exception {
		lp.clickLogout();
		Thread.sleep(3000);

	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

}
