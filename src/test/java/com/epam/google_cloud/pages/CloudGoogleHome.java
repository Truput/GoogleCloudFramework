package com.epam.google_cloud.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.google_cloud.utils.ExplicitWaiters;

public class CloudGoogleHome extends AbstractPage {
    private final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final Logger logger;

    @FindBy(xpath = "//form[@class=\"devsite-search-form\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@aria-label=\"Search\"]")
    private WebElement searchForm;

    public CloudGoogleHome(WebDriver driver, Logger logger) {
        super(driver);
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHome openPage() {
        driver.get(HOMEPAGE_URL);
        ExplicitWaiters.waitForJStoLoad(driver);
        logger.info("Homepage opened");
        return this;
    }

    public SearchResultPage searchByTerm(String searchTerm) {
        ExplicitWaiters.waitForToBeClickable(driver, searchButton);
        searchButton.click();
        searchForm.sendKeys(searchTerm);
        searchForm.submit();
        ExplicitWaiters.waitForJStoLoad(driver);
        logger.info("Recieved results of search");
        return new SearchResultPage(driver, searchTerm, logger);
    }
}
