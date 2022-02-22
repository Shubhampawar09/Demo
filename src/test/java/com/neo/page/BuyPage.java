package com.neo.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.neo.locator.Buy;
import com.neo.utility.ActionMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuyPage extends ActionMethod implements Buy {

	ActionMethod action = new ActionMethod();
	Logger log = Logger.getLogger(BuyPage.class);

	public BuyPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void scrollTillTech() {
		action.waitForSeconds(2);
		int startx = Integer.parseInt(prop.getProperty("scroll_vertical_to_find_tech_startx"));
		int starty = Integer.parseInt(prop.getProperty("scroll_vertical_to_find_tech_starty"));
		int endy = Integer.parseInt(prop.getProperty("scroll_vertical_to_find_tech_endy"));
		action.scrollVertically(startx, starty, endy);
		log.info("Logs: User scroll to find the tech collection tab");
		action.waitForSeconds(1);

	}

	public void clicktech() {
		action.click("AccessibilityID", collectionTech);
		log.info("Logs: User clicks on tech collection");
		action.waitForSeconds(1);
	}

	public void searchInstrument(String instrument) {
		action.click("xpath", clickSearchBox);
		action.enter_data("ClassName", searchBox, instrument);
		action.Wait();
		String s = String.format(clickSearchedShare, instrument);
		action.click("xpath", s);
		log.info("Logs: User clicks on the searched instrument");
		action.waitForSeconds(1);

	}

	public void clickTrade() {
		action.click("AccessibilityID", clickTrade);
		log.info("Logs: User clicks on trade button");
		action.waitForSeconds(1);
	}

	public void clickBuy() {
		action.click("AccessibilityID", clickBuy);
		log.info("Logs: User click on buy to purchase the share");
		action.waitForSeconds(1);
	}

	public void enterAmountToBuyShare(String share) {
		action.click("xpath", buyShare);
		action.waitForSeconds(1);
		char[] amt = share.toCharArray();
		for (int i = 0; i < amt.length; i++) {
			String id = String.valueOf(amt[i]);
			action.click("AccessibilityID", id);
			action.waitForSeconds(1);
		}
		log.info("Logs: User enters the quantity to buy the share");
	}

	public void clickContinue() {
		action.click("AccessibilityID", clickContinue);
		log.info("Logs: User clicks on continue option to buy the shares");
		action.waitForSeconds(1);
	}

	public void verifyUserReadyToInvest() {

		if (action.isElementPresent("AccessbilityID", verifyUserToBuyShare)) {
			log.info("Logs: User is ready to buy the instrument");
		} else {
			log.info("Logs: User is not ready to buy the instrument");
		}
	}

	public void swipeToBuyInstrument() {
		action.searchDevice(prop.getProperty("DeviceName"));
		log.info("Logs: User scroll to buy the instrument");
		action.waitForSeconds(1);
	}

}
