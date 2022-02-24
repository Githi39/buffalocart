package com.buffalocart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public static final long PAGE_LOAD_WAIT = 20;
    public static final long EXPLICIT_WAIT = 50;

    public enum LocaterType
    {
        Id, Name, ClassName, Xpath, LinkText, PartialLinkText,TagName;
    }

    public void waitForTheElementToBeVisible(WebDriver driver, Enum locatertype, String target) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if(locatertype.equals(LocaterType.Id))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
        }
        else if(locatertype.equals(LocaterType.ClassName))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
        }
        else if(locatertype.equals(LocaterType.Name))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
        }
        else  if(locatertype.equals(LocaterType.Xpath))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
        }
        else if(locatertype.equals(LocaterType.LinkText))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
        }
        else if(locatertype.equals(LocaterType.PartialLinkText))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
        }
        else if (locatertype.equals(LocaterType.TagName))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
        }
        else
        {
            try {
                throw new Exception("invalid locator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void waitToBeElementToBeClickable(WebDriver driver, String target, Enum locatertype)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

        if(locatertype.equals(LocaterType.Id))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(target)));

        }
        else  if(locatertype.equals(LocaterType.ClassName))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.className(target)));
        }
        else  if(locatertype.equals(LocaterType.Name))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.name(target)));
        }
        else  if(locatertype.equals(LocaterType.Xpath))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
        }
        else  if(locatertype.equals(LocaterType.LinkText))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(target)));
        }
        else  if(locatertype.equals(LocaterType.PartialLinkText))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(target)));
        }
        else  if(locatertype.equals(LocaterType.TagName))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName(target)));
        }
        else
        {
            try {
                throw new Exception("invalid locator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void waitforElementToBeSelected(WebDriver driver, String target, Enum locatertype)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

        if(locatertype.equals(LocaterType.Id))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.id(target)));


        }
        else  if(locatertype.equals(LocaterType.ClassName))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.className(target)));
        }
        else  if(locatertype.equals(LocaterType.Name))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.name(target)));
        }
        else  if(locatertype.equals(LocaterType.Xpath))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));
        }
        else  if(locatertype.equals(LocaterType.LinkText))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.linkText(target)));
        }
        else  if(locatertype.equals(LocaterType.PartialLinkText))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.partialLinkText(target)));
        }
        else  if(locatertype.equals(LocaterType.TagName))
        {
            wait.until(ExpectedConditions.elementToBeSelected(By.tagName(target)));

        }
        else
        {
            try {
                throw new Exception("invalid locator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
