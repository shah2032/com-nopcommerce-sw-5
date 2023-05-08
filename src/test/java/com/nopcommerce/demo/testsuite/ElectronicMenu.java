package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customerlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ElectronicMenu extends BaseTest {
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    AddToCartPage addToCartPage = new AddToCartPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    GuestCheckOutPage guestCheckOutPage = new GuestCheckOutPage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();
        addToCartPage = new AddToCartPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
        guestCheckOutPage = new GuestCheckOutPage();
        cellPhonesPage = new CellPhonesPage();
    }

    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        homePage.setMouseHoverToElectronic();
        //1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        homePage.setGetMouseHoverToElectronicAndClickOnCellPhone();
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.verifyTextCellPhone(), "Cell phones");
    }

    @Test(groups = {"smoke", "regression"})
    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        homePage.setMouseHoverToElectronic();
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.setGetMouseHoverToElectronicAndClickOnCellPhone();
        //2.3 Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.verifyTextCellPhone(), "Cell phones");
        //2.4 Click on List View Tab
        cellPhonesPage.clickOnListView();
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        // waitUntilVisibilityOfElementLocated(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"),5);
        cellPhonesPage.clickOnNokiaLumia1020();
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(cellPhonesPage.verifyTextNokiaLumia1020(), "Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        Assert.assertEquals(cellPhonesPage.verifyPrice(), "$349.00");
        //2.8 Change quantity to 2
        cellPhonesPage.changeThatQty();
        //2.9 Click on “ADD TO CART” tab
        cellPhonesPage.clickOnAddToCart();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(cellPhonesPage.verifyAddToCartSuccessfully(), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        cellPhonesPage.clickOnCrossButton();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        cellPhonesPage.mouseHoverToShoppingCart();
        //2.12 Verify the message "Shopping cart"
        shoppingCartPage.verifyShoppingCartText();
        //2.13 Verify the quantity is 2
        Assert.assertEquals(shoppingCartPage.verifyQty(), "2");
        //2.14 Verify the Total $698.00
        Assert.assertEquals(shoppingCartPage.verifyPriceText(), "$698.00");
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckBox();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(checkOutPage.verifyWelcomeText(), "Welcome, Please Sign In!");
        //From here shopping cart showing empty
        //2.18 Click on “Login” tab
        checkOutPage.enterLogindetailsAndClickOnLoginButton();
        checkOutPage.clickOnCheckOutBox();
        checkOutPage.clickOnCheckOutButton();
        //2.20 Fill the mandatory fields
        checkOutPage.enterMandatoryDetails();
        //2.21 Click on “Continue” Button
        checkOutPage.clickOnContinue();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkOutPage.clickOnradioButton();
        //2.30 Click on “CONTINUE”
        checkOutPage.clickOnContinueButton();
        //2.31 Select Radio Button “Credit Card”
        checkOutPage.clickOnCreditCard();
        checkOutPage.clickOnContinueButton3();
        //2.32 Select “Visa” From Select credit card dropdown
        checkOutPage.selectCardType();
        //2.33 Fill all the details
        checkOutPage.enterCardDetails();
        //2.34 Click on “CONTINUE”
        checkOutPage.clickOnContinueButton2();
        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkOutPage.verifyPaymentMethod(), "Payment Method: Credit Card");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals(checkOutPage.verifyShippingMethod(), "Shipping Method: 2nd Day Air");
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals(checkOutPage.verifyTotalPrice(), "$698.00");
        //2.38 Click on “CONFIRM”
        checkOutPage.clickOnConfirm();
        //2.39 Verify the Text “Thank You”
        Assert.assertEquals(checkOutPage.verifyThankYouMessage(), "Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkOutPage.verifyOrderPlacedMessageText(), "Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        checkOutPage.clickOnContinueButton4();
        //2.42 Verify the text “Welcome to our store”
        Assert.assertEquals(checkOutPage.verifyWelcomeToOurStoreText(), "Welcome to our store");
        //2.43 Click on “Logout” link
        checkOutPage.clickOnLogOutLink();
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Assert.assertEquals(checkOutPage.verifyCurrentUrl(), "https://demo.nopcommerce.com/");
    }
}
