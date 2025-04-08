package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{

	private static final By PRODUCT_LISTING_TITLE_LOCATOR=By.xpath("//span[@class='lighter']");
	private static final By SEARCHED_PRODUCT_NAMES=By.xpath("//h5[@itemprop='name']//a");
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords=Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList=getAllVisibleText(SEARCHED_PRODUCT_NAMES);
		return productNamesList.stream()
			.anyMatch(name->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
	}
	public ProductDetailPage clickOnTheProductAtIndex(int index) {
		clickOn(getAllElements(SEARCHED_PRODUCT_NAMES).get(index));
		return new ProductDetailPage(getDriver());
	}
	
}
