package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ResetPasswordTest extends Base {
    LoginPage login;
    ResetPasswordPage reset;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 5,description = "TC_005_Verify error message displyed on  Reset Password page with invalid email id")
    public void verifyErrorMessageOnResetPasswordPage()
    {
        extentTest.get().assignCategory("Regression");
        List<List<String>> data=excel.excelDataReader("Recoveremail");
        login=new LoginPage(driver);
        reset = login.clickOnForgotPassword();
        extentTest.get().log(Status.PASS, "Successfully clicked on forgot password");
        String recoverEmail = data.get(1).get(0);
        reset.recoverEmailToEnter(recoverEmail);
        extentTest.get().log(Status.PASS, "Recover email address entered successfully");
        reset.clickOnResetPasswordButton();
        extentTest.get().log(Status.PASS, "Successfully clicked on reset password button");
        String actualErrorMessage = reset.getActualErrorMessage();
        extentTest.get().log(Status.PASS, "Actual error message successfully captured");
        String expectedErrorMessage = data.get(1).get(1);
        extentTest.get().log(Status.PASS, "Expected error message successfully captured");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"MISMATCH FOUND IN ERROR MESSAGE DISPLAYED WHEN INVALID RECOVER EMAIL IS ENTERED");
        extentTest.get().log(Status.PASS, "Verify error message displyed on  Reset Password page with invalid email id test case passed");
    }
    }

