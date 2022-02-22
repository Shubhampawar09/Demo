package com.neo.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.neo.locator.Home;
import com.neo.utility.ActionMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ActionMethod implements Home {

	ActionMethod action = new ActionMethod();
	Logger log = Logger.getLogger(HomePage.class);

	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void clickInvest() {
		action.waitForSeconds(5);
		action.click("AccessibilityID", invest);
		log.info("Logs: User clicks on invest option");
		action.waitForSeconds(1);

	}

	public void sellTrade() {
		action.click("AccessibilityID", clickTrade);
		log.info("Logs: User clicks on trade option");
		action.waitForSeconds(1);
	}

	public void sellButton() {
		action.click("AccessibilityID", clickSell);
		log.info("Logs: User clicks on sell option");
		action.waitForSeconds(2);
	}

	public void enterShareToSell(String share) {
		action.waitForSeconds(2);
		action.click("xpath", shareToSell);
		// getDriver().findElement(MobileBy.xpath("(//android.view.View[@content-desc='0'])[2]")).click();

		char[] amt = share.toCharArray();
		for (int i = 0; i < amt.length; i++) {
			String id = String.valueOf(amt[i]);
			action.click("AccessibilityID", id);
			action.waitForSeconds(1);
		}
		log.info("Logs: User enters the quantity to sell the share");
	}

	public void clickContinueToShare() {

		action.click("AccessibilityID", clickContinue);
		log.info("Logs: User clicks on continue to share option");

	}

	public void verifyUserReadyToSell() {

		if (action.isElementPresent("AccessbilityID", verifyReadyToSell)) {
			// System.out.println("user will able to sell the share");
			log.info("Logs: User is able to sell the share");
		} else {
			// System.out.println("User is on wrong page");
			log.info("Logs: User is not able to sell the share");
		}

	}

	public void scrollToSellShare() {

		action.searchDevice(prop.getProperty("DeviceName"));
		log.info("Logs: User scroll to sell the share");
		action.waitForSeconds(2);
	}

	public void verifyShareIsSell() {

		if (action.isElementPresent("AccessbilityID", verifyMabrook)) {
			log.info("Logs: User share is sell");
		} else {
			log.info("Logs: User is on wrong page");
		}
	}

}
