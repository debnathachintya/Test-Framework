package E2EProject.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class HomePage extends baseFile {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void pageNavigation(String user_name, String pass_word) throws IOException, InterruptedException {
		test = extent.createTest("HomePage - pageNavigation - user:" + user_name);

		driver.get(prop.getProperty("base_url"));
		test.info("Navigated to Base URL");
		LandingPage lp = new LandingPage(driver);

		lp.user().sendKeys(user_name);
		test.info("Entered username");

		lp.pass().sendKeys(pass_word);
		test.info("Entered password");

		lp.login().click();
		test.info("Login Button Clicked");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		test.info("Browser Closed");
		driver = null;
	}

	@DataProvider()
	public Object[][] getData() {
		Object[][] testData = new Object[2][2];
		testData[0][0] = "test";
		testData[0][1] = "mercury";
		
		testData[1][0] = "mercury";
		testData[1][1] = "test";
		return testData;
	}
}