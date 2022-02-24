package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelpUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestHelpUtility {
    WebDriver driver;
    /*** Class Constructor ***/
    public UsersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String _searchBox = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchBox)
    private WebElement searchBox;
    public String getActualUsersPageTitle() {
        return page.getPageTitle(driver);
    }
}
