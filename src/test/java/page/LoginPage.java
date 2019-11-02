package page;

import org.openqa.selenium.WebDriver;

import login.coractions.CoreActionForm;

public class LoginPage extends CoreActionForm {

	private String emailTxt = "name=email";
	private String pwdTxt = "name=password";
	private String loginBtn = "xpath=//button[@data-track_event-action='Login']";
	private String errorMsgLabel = "xpath=//*[@id='client-login']//div[@class='form-errors clearfix']";
	private String emailLabel = "id=header-link-email";
	private String logoutOption = "xpath=//a[contains(@href,'/user/logout')]";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * login
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param email
	 * @param pwd
	 */
	public void login(String email, String pwd) {
		try {
			enterText(emailTxt, email);
			enterText(pwdTxt, pwd);
			Thread.sleep(5000);
			clickOnElement(loginBtn);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * logout
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 */
	public void logout() {
		clickOnElement(emailLabel);
		clickOnElement(logoutOption);
	}

	/**
	 * get error messages
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @return
	 */
	public String getErrorMsg() {
		return getCurrentTextOfElement(errorMsgLabel);
	}

	/**
	 * get login success label
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @return
	 */
	public String getLoginSucessLabel() {
		return getCurrentTextOfElement(emailLabel);
	}
}
