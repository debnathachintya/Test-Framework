package stepDefinations;

import org.testng.Assert;

import E2EProject.E2EProject.baseFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;

public class stepDefination extends baseFile {
	public static LandingPage lp;
	
	 @Given("^Browser is Initialized$")
	    public void browser_is_initialized() throws Throwable {
		 driver = initializeDriver();
	    }

	    @When("^user enters (.+) and (.+)$")
	    public void user_enters_and(String username, String password) throws Throwable {
	    	lp = new LandingPage(driver);

			lp.user().sendKeys(username);
			lp.pass().sendKeys(password);
			Thread.sleep(3000);
	    }

	    @Then("^Dashboard page is displayed and browser is closed$")
	    public void dashboard_page_is_displayed_and_browser_is_closed() throws Throwable {
	    	driver.close();
			driver = null;
	    }

	    @Then("^Page title is compared and browser is closed$")
	    public void page_title_is_compared_and_browser_is_closed() throws Throwable {
	    	String page_title = driver.getTitle();
			Assert.assertEquals(page_title, "Welcome: Mercury Tours");

			Thread.sleep(3000);
			driver.close();
			driver = null;
	    }

	    @And("^User navigates to (.+) site$")
	    public void user_navigates_to_site(String baseurl) throws Throwable {
	    	driver.get(baseurl);
	    }

	    @And("^clicks on login button$")
	    public void clicks_on_login_button() throws Throwable {
	    	lp.login().click();
	    	Thread.sleep(2000);
	    }
}
