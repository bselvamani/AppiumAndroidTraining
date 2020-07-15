package com.appium.pom.app;

import java.util.List;

import com.appium.pom.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends BasePage {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement btnCart;

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    private List<WebElement> btnAddToCard;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrice;

    public ProductPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return btnCart.isDisplayed();
    }

    public ProductPage addItemsToCart() {
        btnAddToCard.get(0).click();
        return this;
    }

    public CheckOutPage onClickCart() {
        btnCart.click();
        return new CheckOutPage(driver);
    }
}
