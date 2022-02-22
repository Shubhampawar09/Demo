package com.neo.test;

import org.testng.annotations.Test;

import com.neo.page.HomePage;
import com.neo.utility.BaseTest;
import com.neo.utility.DeviceCapabilities;

public class HomeTest extends BaseTest{

	
	HomePage homepage=new HomePage(DeviceCapabilities.getDriver());
	
	@Test
	public void homeSearch() throws Exception {
		homepage.clickInvest();
		homepage.sellTrade();
		homepage.sellButton();
		homepage.enterShareToSell("18");
		homepage.clickContinueToShare();
		homepage.verifyUserReadyToSell();
		homepage.scrollToSellShare();
		homepage.verifyShareIsSell();
		
	}
	
}
