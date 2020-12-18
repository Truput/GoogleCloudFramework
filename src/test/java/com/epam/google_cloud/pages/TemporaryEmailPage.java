package com.epam.google_cloud.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.google_cloud.utils.ExplicitWaiters;
import java.util.ArrayList;

public class TemporaryEmailPage extends AbstractPage {
    private final static String HOMEPAGE_URL = "https://10minutemail.com";
    private ArrayList<String> tabs;
    private final Logger logger;

    @FindBy(id = "copy_address")
    private WebElement copyAddressButton;

    @FindBy(xpath = "//div[@class=\"mail_message\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement totalEstimatedCost;

    public TemporaryEmailPage(WebDriver driver, Logger logger) {
        super(driver);
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailPage openPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.get(HOMEPAGE_URL);
        ExplicitWaiters.waitForJStoLoad(driver);
        logger.info("Temporary email page opened");
        return this;
    }

    public TemporaryEmailPage copyGeneratedEmail() {
        ExplicitWaiters.waitForToBeClickable(driver, copyAddressButton);
        copyAddressButton.click();
        logger.info("Temporary email copied");
        return this;
    }

    public TemporaryEmailPage openEmail() {
        ExplicitWaiters.waitForToBeClickable(driver, email);
        email.click();
        logger.info("Email opened");
        return this;
    }

    public double getEstimatedCost() {
        ExplicitWaiters.waitForPresence(driver, By.xpath("//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3"));
        String[] estimatedCostToArray = totalEstimatedCost.getText().split("\\s");
        String estimatedCostToString = estimatedCostToArray[1];
        estimatedCostToString = estimatedCostToString.replaceAll(",", "");
        return Double.parseDouble(estimatedCostToString);
    }

    public void switchToTab() {
        driver.switchTo().window(tabs.get(0));
        logger.info("Switched to another tab");
    }


}
