package com.epam.google_cloud.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaiters {
    private static final int TIMEOUT = 30;

    public static void waitForToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(WebDriver driver, By by) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForPresenceOfAllElements(WebDriver driver, By by) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void waitForFrame(WebDriver driver, WebElement frameLocator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void waitForJStoLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        wait.until(jsLoad);
    }
}
