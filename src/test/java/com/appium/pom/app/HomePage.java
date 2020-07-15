package com.appium.pom.app;

import com.appium.pom.BasePage;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement txtName;

    @AndroidFindBy(xpath = "//*[@text='Male']")
    private WebElement btnMale;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    private WebElement btnFemale;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement txtCountry;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return this.btnLetsShop.isDisplayed();
    }

    public HomePage setName(String name) {
        txtName.sendKeys(name);
        hideKeyboard();
        return this;
    }

    public HomePage onClickGender(String gender) {
        if (gender.equalsIgnoreCase("Male"))
            btnMale.click();
        else if (gender.equalsIgnoreCase("Female"))
            btnFemale.click();

        return this;
    }

    public HomePage selectCountry(String country) {
        txtCountry.click();
        scrollToText(country);
        return this;
    }

    public ProductPage onClickLetsShop() {
        btnLetsShop.click();
        return new ProductPage(driver);
    }

    private void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));").click();
    }
}
