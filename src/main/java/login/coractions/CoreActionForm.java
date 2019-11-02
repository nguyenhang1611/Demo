package login.coractions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoreActionForm {

	public static WebDriver driver = null;

	public CoreActionForm(WebDriver driver) {
		CoreActionForm.driver = driver;
	}

	/**
	 * click on Element
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param element
	 */

	public void clickOnElement(String element) {
		WebElement onElement = driver.findElement(getObject(element));
		try {
			onElement.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sendKeys to text box
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param element
	 * @param value
	 */
	public void enterText(String element, String value) {
		WebElement e = driver.findElement(getObject(element));
		e.clear();
		e.sendKeys(value);

	}

	/**
	 * get text of element
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param element
	 * @return
	 */
	public String getCurrentTextOfElement(String element) {
		return getWebElement(element).getText().trim();
	}

	/**
	 * get element
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param target
	 * @return
	 */
	public WebElement getWebElement(String target) {
		try {
			return driver.findElement(getObject(target));
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return null;
	}

	/**
	 * get locator
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param locator
	 * 
	 */
	public By getObject(String locator) {
		By by = null;
		try {
			if (locator.startsWith("id=")) {
				locator = locator.substring(3);
				by = By.id(locator);
			} else if (locator.startsWith("name=")) {
				locator = locator.substring(5);
				by = By.name(locator);
			} else if (locator.startsWith("css=")) {
				locator = locator.substring(4);
				by = By.cssSelector(locator);
			} else if (locator.startsWith("linkText=")) {
				locator = locator.substring(5);
				by = By.linkText(locator);
			} else if (locator.startsWith("xpath=")) {
				locator = locator.substring(6);
				by = By.xpath(locator);
			} else {
				by = By.xpath(locator);
			}
			return by;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}