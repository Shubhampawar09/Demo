package com.neo.test;

import org.testng.annotations.Test;

import com.neo.page.HomeSwipe;
import com.neo.utility.BaseTest;
import com.neo.utility.DeviceCapabilities;

public class HomeSwipeTest extends BaseTest{

	HomeSwipe homeswipe= new HomeSwipe(DeviceCapabilities.getDriver());

	@Test
	public void HomeSwipe() {
		
		homeswipe.scrollToViewAllInstrument();
	}
	
}
