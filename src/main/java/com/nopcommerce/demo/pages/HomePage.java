package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customerlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li")
    List<WebElement> topMenuTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Welcome to our store']")
    WebElement getTextWelcome;

    @CacheLookup
    @FindBy(xpath = "(//a[text()='Electronics '])[1]")
    WebElement mouseHoverToElectronic;

    @CacheLookup
    @FindBy(xpath = "(//a[text()='Cell phones '])[1]")
    WebElement getMouseHoverToElectronicAndClickOnCellPhone;

    public void selectMenu(String menu) {
        try {
            List<WebElement> list = topMenuTab;
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = topMenuTab;
        }
        CustomListeners.test.log(Status.PASS, "Click on Top Menu");
        Reporter.log("Click on Top Menu" + topMenuTab.toString());
    }

    public void clickOnComputerTab() {
        CustomListeners.test.log(Status.PASS, "Click on Computer Tab");
        clickOnElement(computerTab);
        Reporter.log("Click on Computer Tab" + computerTab.toString());
    }

    public String verifyWelcomeText() {
        CustomListeners.test.log(Status.PASS, "Get Welcome Text");
        Reporter.log("Get Welcome Text" + getTextWelcome.toString());
        return getTextFromElement(getTextWelcome);
    }

    public void setMouseHoverToElectronic() {
        mouseHoverToElement(mouseHoverToElectronic);
        CustomListeners.test.log(Status.PASS, "Mouse hover to Electronic");
        Reporter.log("Mouse hover to Electronic" + mouseHoverToElectronic.toString());
    }

    public void setGetMouseHoverToElectronicAndClickOnCellPhone() {
        CustomListeners.test.log(Status.PASS, "Mouse hover to Electronic Tab and Click on Cell Phone");
        mouseHoverToElementAndClick(getMouseHoverToElectronicAndClickOnCellPhone);
        Reporter.log("Mouse hover to Electronic Tab and Click on Cell Phone" + getMouseHoverToElectronicAndClickOnCellPhone.toString());
    }
}
