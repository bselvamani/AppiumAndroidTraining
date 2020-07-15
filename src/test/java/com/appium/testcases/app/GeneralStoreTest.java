package com.appium.testcases.app;

import com.appium.pom.app.CheckOutPage;
import com.appium.pom.app.HomePage;
import com.appium.pom.app.ProductPage;

import com.appium.testcases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GeneralStoreTest extends BaseTest {

    protected HomePage homePage;
    protected ProductPage productPage;
    protected CheckOutPage checkOutPage;

    @Test
    public void test_checkout_from_bag() {
        homePage = new HomePage((AndroidDriver< AndroidElement>) driver);
        assertTrue(homePage.isInitialized());

        productPage = homePage.setName("Bright")
                .onClickGender("Male")
                .selectCountry("Argentina")
                .onClickLetsShop();
        assertTrue(productPage.isInitialized());

        checkOutPage = productPage.addItemsToCart()
                .addItemsToCart()
                .onClickCart();
        assertTrue(checkOutPage.isInitialized());

        assertTrue( checkOutPage.getTotalAmount() >=0 );
    }
}