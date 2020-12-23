package com.epam.google_cloud.pages;

import com.epam.google_cloud.utils.SearchInListUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.google_cloud.utils.ExplicitWaiters;
import java.util.List;

public class SearchResultPage extends AbstractPage {
    private String searchTerm;
    private final Logger logger;

    @FindBy(xpath = "//a[@class=\"gs-title\"]")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver, String searchTerm, Logger logger) {
        super(driver);
        this.searchTerm = searchTerm;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage openResultLink() {
        ExplicitWaiters.waitForPresenceOfAllElements(driver, By.xpath("//a[@class=\"gs-title\"]"));
        SearchInListUtil.findOptionAndClickToIt(searchResults, searchTerm);
        ExplicitWaiters.waitForJStoLoad(driver);
        logger.info("Opened calculator page");
        return new CalculatorPage(driver, logger);
    }

    @Override
    protected AbstractPage openPage() {
        System.out.println("You don't need to open this page directly!");
        return null;
    }
}
