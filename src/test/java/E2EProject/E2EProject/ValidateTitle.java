package E2EProject.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateTitle extends baseFile {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("base_url"));
	}

	@Test
	public void pageNavigation() throws IOException, InterruptedException {
		test = extent.createTest("ValidateTitle - pageNavigation");
		test.info("Navigated to Base URL");

		String page_title = driver.getTitle();
		test.info("Captured Page Title");
		Assert.assertEquals(page_title, "Welcome: Mercury Tours");

		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		test.info("Browser Closed");
		driver = null;
	}
}