package com.neo.test;

import org.testng.annotations.Test;

import com.neo.page.BuyPage;
import com.neo.utility.DeviceCapabilities;

public class BuyTest {

	BuyPage buyPage=new BuyPage(DeviceCapabilities.getDriver());
	
	@Test
	public void buyShare() {
		buyPage.scrollTillTech();
		buyPage.clicktech();
		buyPage.searchInstrument("T");
		buyPage.clickTrade();
		buyPage.clickBuy();
		buyPage.enterAmountToBuyShare("100");
		buyPage.clickContinue();
		buyPage.verifyUserReadyToInvest();
		buyPage.swipeToBuyInstrument();
		
	}
	
	
}
