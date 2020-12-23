package com.epam.google_cloud.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.google_cloud.utils.ExplicitWaiters;

import java.util.ArrayList;

public class CompleteEstimatePage {
    private WebDriver driver;
    private ArrayList<String> tabs;
    private final Logger logger;

    @FindBy(xpath = "//iframe[contains(@name, \"goog_\")]")
    private WebElement mainFrame;

    @FindBy(id = "myFrame")
    private WebElement frameInMain;

    @FindBy(xpath = "//div[@class=\"md-list-item-text ng-binding\" and contains(text(), \"VM class\")]")
    private WebElement vmClassEstimateField;

    @FindBy(xpath = "//div[@class=\"md-list-item-text ng-binding\" and contains(text(), \"Instance type\")]")
    private WebElement instanceTypeEstimateField;

    @FindBy(xpath = "//div[@class=\"md-list-item-text ng-binding\" and contains(text(), \"Region\")]")
    private WebElement region;

    @FindBy(xpath = "//div[@class=\"md-list-item-text ng-binding\" and contains(text(), \"local SSD\")]")
    private WebElement localSSD;

    @FindBy(xpath = "//div[@class=\"md-list-item-text ng-binding\" and contains(text(), \"Commitment term\")]")
    private WebElement commitmentTerm;

    @FindBy(css = "h2 > b")
    private WebElement estimatedCost;

    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement inputEemailField;

    @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
    private WebElement sendEmailButton;

    public CompleteEstimatePage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public String getVmClass() {
        String[] vmclassToArray = vmClassEstimateField.getText().split("\\s");
        return vmclassToArray[2];
    }

    public String getInstanceType() {
        String[] instanceTypeToArray = instanceTypeEstimateField.getText().split("\\s");
        return instanceTypeToArray[2];
    }

    public String getRegion() {
        String[] regionToArray = region.getText().split("\\s");
        return regionToArray[1];
    }

    public String getLocalSSD() {
        try {
            String[] localSSDToArray = localSSD.getText().split("\\s");
            return localSSDToArray[5];
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return "0";
        }
    }

    public String getCommitmentTerm() {
        String[] commitmentTermToArray = commitmentTerm.getText().split("\\s");
        return commitmentTermToArray[2] + " " + commitmentTermToArray[3];
    }

    public double getTotalEstimatedCost() {
        String[] estimatedCostToArray = estimatedCost.getText().split("\\s");
        String estimatedCostToString = estimatedCostToArray[4];
        estimatedCostToString = estimatedCostToString.replaceAll(",", "");
        return Double.parseDouble(estimatedCostToString);
    }

    public CompleteEstimatePage clickEmailEstimateButton() {
        emailEstimate.click();
        ExplicitWaiters.waitForPresence(driver, By.xpath("//input[@type=\"email\"]"));
        return this;
    }

    public TemporaryEmailPage createNewTabAndSwitch() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        switchToTab();
        logger.info("New tab created and switched to it");
        return new TemporaryEmailPage(driver, logger);
    }

    public CompleteEstimatePage inputEmail() {
        ExplicitWaiters.waitForFrame(driver, mainFrame);
        ExplicitWaiters.waitForFrame(driver, frameInMain);
        ExplicitWaiters.waitForPresence(driver, By.xpath("//input[@type=\"email\"]"));
        inputEemailField.sendKeys(Keys.chord(Keys.CONTROL + "V"));
        logger.info("Email entered");
        return this;
    }

    public CompleteEstimatePage sendEmail() {
        ExplicitWaiters.waitForToBeClickable(driver, sendEmailButton);
        sendEmailButton.click();
        logger.info("Email sent");
        return this;
    }

    public void switchToTab() {
        driver.switchTo().window(tabs.get(1));
        logger.info("Switched to another tab");
    }
}
