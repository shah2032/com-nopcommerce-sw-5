package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenu extends Utility {
    HomePage homePage;
    ComputerPage computerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyPageNavigation() {
//        1. create class "TopMenuTest"
//        1.1 create method with name "selectMenu" it has one parameter name "menu" of type
//        string
//        1.2 This method should click on the menu whatever name is passed as parameter.
        homePage.selectMenu("Computers");
//        1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
//        select the Menu and click on it and verify the page navigation
        String expectedMessage = "Computers";
        String actualMessage = computerPage.verifyComputerText();
        Assert.assertEquals(actualMessage, expectedMessage, "Computers page not display");
    }

}
