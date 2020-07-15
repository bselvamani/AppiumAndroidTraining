package com.appium.pom.app;

import java.util.List;

import com.appium.pom.BasePage;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckOutPage extends BasePage {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;


    public CheckOutPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return totalAmount.isDisplayed();
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public Double getTotalAmount(){
        return Double.parseDouble(totalAmount.getText().substring(1));
    }

}
