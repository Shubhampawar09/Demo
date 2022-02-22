package com.neo.test;

import org.testng.annotations.Test;

import com.neo.page.SellPage;
import com.neo.utility.BaseTest;
import com.neo.utility.DeviceCapabilities;

public class SellTest extends BaseTest{

	SellPage sellpage= new SellPage(DeviceCapabilities.getDriver());


	@Test
	public void sellShare() {
		sellpage.searchShare();
		sellpage.scrollTillEnergy();
		sellpage.clickEnergy();
		sellpage.searchInstrument("ECL");
		sellpage.sellTrade();
		sellpage.sellButton();
		sellpage.enterShareToSell("18");
		sellpage.clickContinueToShare();
		sellpage.verifyUserReadyToInvest();
		sellpage.scrollToSellShare();
		sellpage.verifyShareIsSell();
	}
	

}
