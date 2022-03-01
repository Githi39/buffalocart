package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.DateUtility;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base{
    LoginPage login;
    HomePage home;
    ExcelUtility excel =new ExcelUtility();
    DateUtility date=new DateUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 6,description = "TC_006_Verify Home page title")
    public void verifyHomePageTitle() {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        //home = new HomePage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        List<List<String>> data1 = excel.excelDataReader("homepage");
        String actualHomePagetitle = home.getHomePageTitle();
        extentTest.get().log(Status.PASS, "suceffuly got the actual home page title");
        String expectedHomePageTitle = data1.get(1).get(0);
        extentTest.get().log(Status.PASS, "suceffuly got Expected home page title ");
        Assert.assertEquals(actualHomePagetitle, expectedHomePageTitle, "ERROR : INVALID HOME PAGE TITLE PAGE FOUND");
        extentTest.get().log(Status.PASS, "verify home page title test case passed");
    }
    @Test(priority = 7,description = "TC_007_Verify date displayed in home page")
    public void verify_date_displayed_in_home_page(){
        login=new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualDate=home.getDateDisplayedOnHomePage();
        String expectedDate= home.getSystemDate();
        Assert.assertEquals(actualDate,expectedDate,"ERROR ::Not current Date");
        extentTest.get().log(Status.PASS, "verify date displayed in home page passed");
    }

    }

