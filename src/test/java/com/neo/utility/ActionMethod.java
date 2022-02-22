package com.neo.utility;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ActionMethod extends DeviceCapabilities {
	static Reporter report = new Reporter();
	/*
	 * common method to enter data
	 */
	public void enter_data(String locator, String locatorValue, String text) {
		switch (locator) {
		case "ID":
			MobileElement element = getDriver().findElement(MobileBy.id(locatorValue));
			if (element.getText() != null) {
				element.clear();
				element.sendKeys(text);
			} else {
				element.sendKeys(text);
			}
			break;
		case "xpath":
			MobileElement element1 = getDriver().findElement(MobileBy.xpath(locatorValue));
			if (element1.getText() != null) {
				element1.clear();
				element1.sendKeys(text);
			} else {
				element1.sendKeys(text);
			}
			break;
		case "UiSelector":
			MobileElement element2 = getDriver().findElement(MobileBy.AndroidUIAutomator(locatorValue));
			if (element2.getText() != null) {
				element2.clear();
				element2.sendKeys(text);
			} else {
				element2.sendKeys(text);
			}
			break;
		case "ClassName":
			MobileElement element3 = getDriver().findElement(MobileBy.className(locatorValue));
			if (element3.getText() != null) {
				element3.clear();
				element3.sendKeys(text);
			} else {
				element3.sendKeys(text);
			}
			break;

		}
	}

	/*
	 * common method to click
	 */
	public void click(String locator, String locatorValue) {
		//MobileElement element;
		switch (locator) {
		case "xpath":
			MobileElement element = getDriver().findElement(By.xpath(locatorValue));
			element.click();
			break;
		case "UiSelector":
			MobileElement element1 = getDriver().findElement(MobileBy.AndroidUIAutomator(locatorValue));
			element1.click();
			break;
		case "ClassName":
			MobileElement element2 = getDriver().findElement(MobileBy.className(locatorValue));
			element2.click();
			break;
		case "AccessibilityID":
			MobileElement element3 = getDriver().findElement(MobileBy.AccessibilityId(locatorValue));
			element3.click();
		}

	}

	/*
	 * common method to wait
	 */
	public void Wait() {
		try {
			getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * common method to wait for seconds
	 */
	public void waitForSeconds(int timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	/*
	 * common method to wait till element is visible
	 */
	public void waitTillElementIsVisible(String locator, String locatorValue) {
		MobileElement element;
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		switch (locator) {
		case "ID":
			 element = getDriver().findElement(MobileBy.id(locatorValue));
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("element")));
			break;
		case "xpath":
			element = getDriver().findElement(MobileBy.xpath(locatorValue));
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("element")));
			break;
		case "UiSelector":
			 element = getDriver().findElement(MobileBy.AndroidUIAutomator(locatorValue));
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("element")));
			break;
		case "ClassName":
			 element = getDriver().findElement(MobileBy.className(locatorValue));
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("element")));
			break;
		}

	}

	/*
	 * common method to scroll till element found
	 */
	public void scrollTillElementFound(String textName) {
		MobileElement element;
		try {
			element = getDriver().findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
							+ textName + "\").instance(0))"));

		} catch (Exception e) {
			waitForSeconds(5);
			element = getDriver().findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
							+ textName + "\").instance(0))"));

		}
		element.click();
	}

	/*
	 * common method to check if element is present
	 */
	public boolean isElementPresent(String locator, String LocatorValue) {

		boolean flag = true;
		switch (locator) {
		case "ID":
			MobileElement element = getDriver().findElement(MobileBy.id(LocatorValue));
			if (element.isDisplayed()) {
				flag = true;

				break;
			} else {
				flag = false;
				System.out.println("Element is not present");
			}
		case "xpath":
			MobileElement element1 = getDriver().findElement(MobileBy.xpath(LocatorValue));
			if (element1.isDisplayed()) {
				flag = true;
				System.out.println("Element is present");
				break;
			} else {
				flag = false;
				System.out.println("Element is not present");
			}
		case "UiSelector":
			MobileElement element2 = getDriver().findElement(MobileBy.AndroidUIAutomator(LocatorValue));
			if (element2.isDisplayed()) {
				flag = true;
				System.out.println("Element is present");
				break;
			} else {
				flag = false;
				System.out.println("Element is not present");
			}
		case "ClassName":
			MobileElement element3 = getDriver().findElement(MobileBy.className(LocatorValue));
			if (element3.isDisplayed()) {
				flag = true;
				System.out.println("Element is present");
				break;
			} else {
				flag = false;
				System.out.println("Element is not present");
			}
		case "AccessbilityID":
			MobileElement element4 = getDriver().findElement(MobileBy.AccessibilityId(LocatorValue));
			if (element4.isDisplayed()) {
				flag = true;
				// System.out.println("Element is present");
				break;
			} else {
				flag = false;
				// System.out.println("Element is not present");
			}
		}
		return flag;

	}

	/*
	 * common method to search
	 */

	public void enterSearch(String locator, String locatorValue, String text) {
		switch (locator) {
		case "ID":
			MobileElement element1 = getDriver().findElement(MobileBy.id(locatorValue));
			if (element1.getText() != null) {
				element1.clear();
				element1.sendKeys(text);
			} else {
				element1.sendKeys(text);
			}
		case "xpath":
			MobileElement element2 = getDriver().findElement(MobileBy.xpath(locatorValue));
			if (element2.getText() != null) {
				element2.clear();
				element2.sendKeys(text);
			} else {
				element2.sendKeys(text);
			}
		case "UiSelector":
			MobileElement element3 = getDriver().findElement(MobileBy.AndroidUIAutomator(locatorValue));
			if (element3.getText() != null) {
				element3.clear();
				element3.sendKeys(text);
			} else {
				element3.sendKeys(text);
			}
		}
	}

	public List<MobileElement> listOfElements(String Locator, String locatorValue) {

		List<MobileElement> element = null;
		switch (Locator) {
		case "xpath":
			element = getDriver().findElements(MobileBy.xpath(locatorValue));
			break;

		case "ID":
			element = getDriver().findElements(MobileBy.id(locatorValue));
			break;

		case "UiSelector":
			element = getDriver().findElements(MobileBy.AndroidUIAutomator(locatorValue));
			break;

		case "ClassName":
			element = getDriver().findElements(MobileBy.className(locatorValue));
			break;
		}
		return element;
	}

	/*
	 * COMMON METHOD TO TAKE TE SCREENSHOTS AND ADD SCREENSHOTS IN THE REPORT
	 */
	public void takeScreenShots(String s) throws IOException {

		File srcfile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + s + ".png";
		try {
			FileUtils.copyFile(srcfile, new File(destination));
		} catch (IOException e) {

			e.printStackTrace();
		}
		report.test.fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
	}

	/*
	 * MOBILE GESTURE Method to use the mobile gesture on the element
	 */
	public void tapProducts(String locator, String locatorValue) {
		WebElement element;
		TouchAction t = new TouchAction(getDriver());
		switch (locator) {
		case "ID":
			element = getDriver().findElement(MobileBy.id(locatorValue));
			t.tap(tapOptions().withElement(element(element))).perform();
			break;
		case "xpath":
			 element = getDriver().findElement(MobileBy.xpath(locatorValue));
			t.tap(tapOptions().withElement(element(element))).perform();
			break;
		case "UiSelector":
			 element = getDriver().findElement(MobileBy.AndroidUIAutomator(locatorValue));
			t.tap(tapOptions().withElement(element(element))).perform();
			break;
		case "ClassName":
			 element = getDriver().findElement(MobileBy.className(locatorValue));
			t.tap(tapOptions().withElement(element(element))).perform();
			break;
		}

	}

	/*
	 * common method to tap using coordinates
	 */
	public void tap(int start_x, int start_y) {

		(new TouchAction(getDriver())).tap(PointOption.point(start_x, start_y)).perform();

	}

	/*
	 * common method to scroll horizontal using text
	 */
	public void scrollHorizontalUsingText(String text) {

		MobileElement element = getDriver().findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()"
						+ ".scrollIntoView(new UiSelector().content-desc(\"" + text + "\"))"));
		element.click();

	}
	
	
	public void scrollHorizontalUsingObject(int steps) {

		MobileElement element = getDriver().findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()"
						+ ".scrollIntoView(new UiObject().boolean swipeLeft(\"" + steps + "\"))"));
		element.click();

	}


	/*
	 * common method to scroll using coordinates
	 */
	public void scrollHorizontal(int startx, int starty, int endx) {

		TouchAction action = new TouchAction<>(getDriver()).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, starty))
				.release();
		action.perform();

	}

	/*
	 * common method to scroll vertically using coordinates
	 */
	public void scrollVertically(int startx,int starty, int endy) {
		
		TouchAction action = new TouchAction<>(getDriver()).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startx, endy))
				.release();
		action.perform();

	}

	public void searchDevice(String devicename) {
		
		System.out.println(devicename);
		switch (devicename) 
		{
		case "Redmi":
			int startx = Integer.parseInt(prop.getProperty("Redmi_swipe_coordinates_startx"));
			int starty = Integer.parseInt(prop.getProperty("Redmi_swipe_coordinates_starty"));
			int endx = Integer.parseInt(prop.getProperty("Redmi_swipe_coordinates_endx"));
			scrollHorizontal(startx, starty, endx);
			System.out.println("Swipe for the redmi...");
			break;
		case "Galaxy S10 Lite":
			int startx1 = Integer.parseInt(prop.getProperty("Galaxy_swipe_coordinates_startx"));
			int starty1 = Integer.parseInt(prop.getProperty("Galaxy_swipe_coordinates_starty"));
			int endx1 = Integer.parseInt(prop.getProperty("Galaxy_swipe_coordinates_endx"));
			scrollHorizontal(startx1, starty1, endx1);
			System.out.println("Swipe for the galaxy s10 lite...");
			break;
		case "Google Pixel 5":
			int startx2 = Integer.parseInt(prop.getProperty("Google_Pixel5_swipe_coordinates_startx"));
			int starty2 = Integer.parseInt(prop.getProperty("Google_Pixel5_swipe_coordinates_starty"));
			int endx2 = Integer.parseInt(prop.getProperty("Google_Pixel5_swipe_coordinates_endx"));
			scrollHorizontal(startx2, starty2, endx2);
			System.out.println("Swipe for the Google Pixel 5...");
			break;
		default:
			break;
		}

	}
}
