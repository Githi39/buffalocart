package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelpUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserManagementPage extends TestHelpUtility {
    WebDriver driver;

    /*** Class Constructor ***/
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*** page Web Elements ***/
    private final String _userManagementButton = "//span[@class='title']";
    @FindBy(xpath = _userManagementButton)
    private WebElement userManagementButton;
    private final String _userManagementList = "//ul[@class='treeview-menu menu-open']//span";
    @FindBy(xpath = _userManagementList)
    private List<WebElement> userManagementList;
    private final String _user = "//ul[@class='treeview-menu menu-open']//i[@class='fa fa-user']";
    @FindBy(xpath = _user)
    private WebElement user;
    private final String _role = "//ul[@class='treeview-menu menu-open']//i[@class='fa fa-briefcase']";
    @FindBy(xpath = _role)
    private WebElement role;
    private final String _salesCommissionAgents = "//ul[@class='treeview-menu menu-open']//i[@class='fa fa-handshake-o']";
    @FindBy(xpath = _salesCommissionAgents)
    private WebElement salesCommissionAgents;


    /*** User Action Methods ***/
    public void clickOnUserManagementTab() {
        page.clickOnElement(userManagementButton);
    }

    public List getActualUserManagementListValues()
    {
        wait.waitForTheElementToBeVisible(driver, WaitUtility.LocaterType.Xpath,_userManagementList);
        List<String> list = new ArrayList<String>();
        for (int i = 0;i< userManagementList.size();i++)
        {
            list.add(userManagementList.get(i).getText());
        }
        return list;
    }
    public UsersPage clickOnUserMenu(){
       wait.waitForTheElementToBeVisible(driver, WaitUtility.LocaterType.Xpath,_user);
       page.clickOnElement(user);
        return new UsersPage(driver);
    }

}



