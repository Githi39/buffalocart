package com.buffalocart.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class PageUtility {
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void EnterText(WebElement element, String value) {
        element.sendKeys(value);
    }
    public void clearText(WebElement element){
        element.clear();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }
    public List<WebElement> getWebElementList(WebDriver driver,String xpath){
        return driver.findElements(By.xpath(xpath));
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    public void clearValue(WebElement element) {
        element.clear();
    }

    public Dimension getElementSize(WebElement element) {
        return element.getSize();
    }

    public boolean getDisplayValue(WebElement element) {
        boolean status = element.isDisplayed();
        return status;
    }

    public boolean getSelectedValue(WebElement element) {
        boolean status = element.isSelected();
        return status;
    }

    public boolean getEnabledValue(WebElement element) {
        boolean status = element.isEnabled();
        return status;
    }

    public void SubmitButton(WebElement element) {
        element.submit();
    }

    public Point getLocationValue(WebElement element) {
        return element.getLocation();
    }

    public void getClear(WebElement element) {
        element.clear();
    }

    public String getTagnameValue(WebElement element) {
        return element.getTagName();
    }

    public void selectDropDownByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void deselectDropDownByByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByVisibleText(value);
    }

    public void selectDropDownByIndex(WebElement element, int i) {
        Select select = new Select(element);
        select.selectByIndex(i);
    }

    public void deselectDropDownByIndex(WebElement element, int i) {
        Select select = new Select(element);
        select.deselectByIndex(i);
    }

    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void deselectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }

    public void selectDropDownByisMultiple(WebElement element) {
        Select select = new Select(element);
        select.isMultiple();
    }

    public void selectDropDownBydeSelectall(WebElement element) {
        Select select = new Select(element);
        select.deselectAll();
    }

    public void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void enterTextOnAlert(WebDriver driver, String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    public void alertDismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void doubleClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    public void clickAndHoldAnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }

    public void dragAndDropAnElement(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public void dragAndDropByDragToaPosition(WebDriver driver, WebElement source, int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source, x, y).build().perform();
    }

    public void moveToAnElement(WebDriver driver, WebElement source, int x, int y) {
        Actions actions = new Actions(driver);
        actions.moveToElement(source, x, y).build().perform();
    }

    public void rightClickOnElement(WebDriver driver, WebElement target) {
        Actions actions = new Actions(driver);
        actions.contextClick(target).build().perform();
    }

    public List<WebElement> getDropDownValues(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    public void navigateToApplication(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public void navigateForwardToApplication(WebDriver driver) {
        driver.navigate().forward();
    }

    public void navigateBackToApplication(WebDriver driver) {
        driver.navigate().back();
    }

    public void navigateRefreshToApplication(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void getWindowhandleId(WebDriver driver, String value) {
        driver.getWindowHandle();
    }

    public void switchToframeByIndex(WebDriver driver, int i) {
        Frame frame = new Frame();
        driver.switchTo().frame(i);
    }

    public void switchToframeByNameOrId(WebDriver driver, String value) {
        Frame frame = new Frame();
        driver.switchTo().frame(value);
    }

    public void switchToframeByWebElement(WebDriver driver, WebElement element) {
        Frame frame = new Frame();
        driver.switchTo().frame(element);
    }

    public String getWindowHandleId(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandlesId(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public void javaScriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void javaScriptScroll(WebDriver driver, int x, long y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(x,y)");
    }

    public void javaScriptGetAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + message + "')");
    }

    public void javaScriptSendKeys(WebDriver driver, String id, String values) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('id').value='values'");

    }
}
