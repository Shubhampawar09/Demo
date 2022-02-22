package com.neo.locator;

public interface Buy {

	String collectionTech = "Tech";// id
	String clickSearchBox = "//android.widget.EditText[@text='Search Stock, ETF, News']"; // xpath
	String searchBox = "android.widget.EditText";// classname
	String clickTrade = "Trade";// id
	String clickBuy="Buy";//id
	String buyShare="(//android.view.View[@content-desc='0'])[1]";
	String clickContinue = "Continue"; // id
	String verifyUserToBuyShare="All set! Are you ready to invest?";//id

	// dynamic xpath//
	// for browserstack//
	// String
	// clickSearchedShare="//android.view.View[contains(@content-desc,'%s')]";

	// for local//
	String clickSearchedShare = "//android.widget.ImageView[contains(@content-desc,'%s')]";// xpath
}
