package com.neo.locator;	

public interface Sell {

	String homeSearch="//android.view.View[@index='3']";//xpath
	String collectionEnergy = "Energy";// id
	String clickSearchBox = "//android.widget.EditText[@text='Search Stock, ETF, News']"; // xpath
	String searchBox = "android.widget.EditText";// classname
	String clickTrade = "Trade";// id
	String clickSell = "Sell";// id
	String clickContinue = "Continue"; // id
	String verifyReadyToSell ="Sell";// id
	String invest = "Invest";// id
	String verifyMabrook = "MABROOK!";//id
	String shareToSell="(//android.view.View[@content-desc='0'])[2]";//xpath
	//String shareToSell="(//android.view.View[@content-desc='0'])[1]";
	
	//dynamic xpath//
	//for browserstack//
	//String clickSearchedShare="//android.view.View[contains(@content-desc,'%s')]";
	
	//for local//
	String clickSearchedShare="//android.widget.ImageView[contains(@content-desc,'%s')]";//xpath
	
}
