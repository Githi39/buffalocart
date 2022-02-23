package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelpUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends TestHelpUtility {
    WebDriver driver;
    /*** Class Constructor ***/
    public ResetPasswordPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /*** page Web Elements ***/

    private final String _recoverEmailId = "email";
    @FindBy(id=_recoverEmailId)
    private WebElement recoverEmailId;

    private final String _resetButton = "//button[@class='btn btn-primary']";
    @FindBy(xpath=_resetButton)
    private WebElement resetButton;

    private final String _resetErrorMessage = "//span[@class='help-block']//strong";
    @FindBy(xpath=_resetErrorMessage)
    private WebElement resetErrorMessage;
    public void recoverEmailToEnter(String recoverEmailToEnter)
    {
        page.EnterText(recoverEmailId,recoverEmailToEnter);
    }
    public void clickOnResetPasswordButton()
    {
        page.clickOnElement(resetButton);
    }
    public String getActualErrorMessage()
    {
        return page.getElementText(resetErrorMessage);
    }

}
