package com.neo.page;

import org.openqa.selenium.support.PageFactory;

import com.neo.locator.homeSwipe;
import com.neo.utility.ActionMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeSwipe extends ActionMethod implements homeSwipe{

	ActionMethod action= new ActionMethod();
	
	public HomeSwipe(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void scrollToViewAllInstrument() {
		action.waitForSeconds(1);
		action.scrollHorizontalUsingText("GOOGL");
		action.click("AccessibilityID", clickInvest);
		action.waitForSeconds(1);
		
	}
}
