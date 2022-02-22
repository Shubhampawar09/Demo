package com.neo.locator;

public interface Home {

	String invest="Invest"; //id
	String clickTrade = "Trade";// id
	String clickSell = "Sell";// id
	String clickContinue = "Continue"; // id
	String verifyReadyToSell = "Sell";// id
	String investText = "Invest";// id
	String verifyMabrook ="MABROOK!";//id
	String shareToSell="(//android.view.View[@content-desc='0'])[2]";//xpath
	String seeAll = "See all";// AccessibliltyID
	String searchBox = "//android.widget.EditText[@text='Search Stock, ETF, News']";// xpath
	String enterSearch = "android.widget.EditText";// classname
	
	//dynamic xpath//
	//String clickSearchedShare="//android.view.View[contains(@content-desc,'%s')]";
	
	//for local device
	String clickSearchedShare="//android.widget.ImageView[contains(@content-desc,'%s')]";
}

