package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customerlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class ComputerMenu extends BaseTest {
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    AddToCartPage addToCartPage = new AddToCartPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    GuestCheckOutPage guestCheckOutPage = new GuestCheckOutPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();
        addToCartPage = new AddToCartPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
        guestCheckOutPage = new GuestCheckOutPage();
    }

    @Test(groups = {"sanity" , "regression"})
//    1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        homePage.clickOnComputerTab();
        //1.2 Click on Desktop
        computerPage.clickOnDesktop();
        ArrayList<String> originalProductList = desktopPage.defaultProductList();
        System.out.println(originalProductList);
        Collections.reverse(originalProductList);
        //1.3 Select Sort By position "Name: Z to A"
        System.out.println(originalProductList);
        desktopPage.sortByPositionByNameZtoA();
        ArrayList<String> afterSortByZtoAList = desktopPage.defaultProductList();
        System.out.println(originalProductList);
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(afterSortByZtoAList, afterSortByZtoAList);

    }

    @Test(groups = {"smoke" , "regression"})
    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        homePage.clickOnComputerTab();
        //2.2 Click on Desktop
        computerPage.clickOnDesktop();
        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.sortByPositionByNameZtoA();
        //2.4 Click on "Add To Cart"
        //    waitUntilVisibilityOfElementLocated(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]"), 5);
        Thread.sleep(1000);
        desktopPage.clickOnAddToCart();
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals(addToCartPage.verifyBuildYourOwnComputerText(), "Build your own computer", "Not found");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        addToCartPage.selectProcessor();
        //2.7.Select "8GB [+$60.00]" using Select class.
        addToCartPage.selectRam();
        //2.8 Select HDD radio "400 GB [+$100.00]"
        addToCartPage.selectHDD();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        addToCartPage.selectOS();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        addToCartPage.selectSoftware();
        //2.11 Verify the price "$1,475.00"
        // waitUntilVisibilityOfElementLocated(By.xpath("//span[@id='price-value-1']"),5);
        Thread.sleep(2000);
        Assert.assertEquals(addToCartPage.verifyThePrice(), "$1,475.00", "Wrong Price");
        //2.12 Click on "ADD TO CARD" Button.
        addToCartPage.clickOnAddToCart();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(addToCartPage.verifyAddToCartSuccessfully(), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        addToCartPage.clickOnCrossButton();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        addToCartPage.mouceHoverToShopingCart();
        addToCartPage.clickOnGoToCart();
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(), "Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.changeTheQuantity();
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals(shoppingCartPage.verifyTotalPrice(), "$2,950.00");
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckBox();
        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(checkOutPage.verifyWelcomeText(), "Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        checkOutPage.clickOnCheckOutAsGuest();
        //2.22 Fill the all mandatory field
        guestCheckOutPage.enterDetails();
        //2.23 Click on “CONTINUE”
        guestCheckOutPage.clickOnContinueButton();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        guestCheckOutPage.clickOnNextDayAir();
        //2.25 Click on “CONTINUE”
        guestCheckOutPage.clickOnContinue();
        //2.26 Select Radio Button “Credit Card”
        guestCheckOutPage.clickOnCreditCard();
        guestCheckOutPage.clickOnContinues();
        //2.27 Select “Master card” From Select credit card dropdown
        guestCheckOutPage.selectMasterCard();
        //2.28 Fill all the details
        guestCheckOutPage.enterDetailsOfCard();
        //2.29 Click on “CONTINUE”
        guestCheckOutPage.clickOnContinueButton3();
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(guestCheckOutPage.verifyCreditCardPaymentMethod(), "Payment Method: Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(guestCheckOutPage.verifyShippingMethod(), "Shipping Method: Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(guestCheckOutPage.verifyTotalPrice(), "$2,950.00");
        //2.34 Click on “CONFIRM”
        guestCheckOutPage.clickOnConfirm();
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals(guestCheckOutPage.verifyThankYouMessage(), "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(guestCheckOutPage.verifyOrderPlacedSuccessfullyText(), "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        guestCheckOutPage.clickOnContinueButton4();
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.verifyWelcomeText(), "Welcome to our store");
    }
}
