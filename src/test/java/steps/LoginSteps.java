package steps;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import login.coractions.ReadExcelFile;
import page.LoginPage;

public class LoginSteps {
	private LoginPage loginPageObj;
	public WebDriver driver = null;
	private String workingDir = System.getProperty("user.dir") + "/src/main/resources/";

	@Parameters({ "baseURL" })
	@BeforeClass
	public void initializeTestBaseSetup(@Optional("https:cp.qc.coccoc.com/user/login") String baseURL) {
		try {
			driver = new ChromeDriver();
			setPropertyChromeDriver();
			driver.manage().window().fullscreen();
			driver.navigate().to(baseURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());

		}
	}

	private void setPropertyChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", workingDir + "chromedriver_mac");
		}
		if (os.contains("window")) {
			System.setProperty("webdriver.chrome.driver", workingDir + "chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", workingDir + "chromedriver_linux");
		}
	}

	/**
	 * Login Success
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 */
	@Test(priority = 1)
	public void loginSuccess() {
		loginPageObj = new LoginPage(driver);
		loginPageObj.login("hangnguyenycn@gmail.com", "123456a");
		AssertJUnit.assertEquals(loginPageObj.getLoginSucessLabel(), "hangnguyenycn@gmail.com");
		loginPageObj.logout();
	}

	/**
	 * Login Fail
	 * 
	 * @author HangNT
	 * @throws IOException
	 * @since 2019/11/01
	 */
	@Test(priority = 2)
	public void loginFail() throws IOException {
		loginPageObj = new LoginPage(driver);
		ReadExcelFile readExcelFileObj = new ReadExcelFile();
		String workingDir = System.getProperty("user.dir") + "/src/test/resources/";
		int rowCount = readExcelFileObj.getRowCount(workingDir, "Excel.xlsx", "Sheet1");
		System.out.println("Total rows : " + rowCount);

		for (int i = 0; i <= rowCount; i++) {
			String userName = readExcelFileObj.getCellValue(workingDir, "Excel.xlsx", "Sheet1", i, 0);
			String passWord = readExcelFileObj.getCellValue(workingDir, "Excel.xlsx", "Sheet1", i, 1);
			String errorMsg = readExcelFileObj.getCellValue(workingDir, "Excel.xlsx", "Sheet1", i, 2);
			loginPageObj = new LoginPage(driver);
			loginPageObj.login(userName, passWord);
			AssertJUnit.assertEquals(loginPageObj.getErrorMsg(), errorMsg);

		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
