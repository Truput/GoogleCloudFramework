package com.epam.google_cloud.pages;

import com.epam.google_cloud.calculator_options.*;
import com.epam.google_cloud.utils.SearchInListUtil;
import com.epam.google_cloud.utils.ExplicitWaiters;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalculatorPage extends AbstractPage {
    private final Logger logger;

    @FindBy(xpath = "//iframe[contains(@name, \"goog_\")]")
    private WebElement mainFrame;

    @FindBy(css = "#myFrame")
    private WebElement frameInMain;

    @FindBy(xpath = "//md-autocomplete-wrap/input")
    private WebElement searchEngineField;

    @FindBy(css = "input[ng-model=\"listingCtrl.computeServer.quantity\"]")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//div[3]/md-select-menu/md-content/md-option")
    private List<WebElement> operatingSystemsOptions;

    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.os\"]")
    private WebElement operatingSystems;

    @FindBy(xpath = "//md-option[@value=\"sql-enterprise\"]")
    private WebElement operatingSystemsLastOption;

    @FindBy(css = "md-select[placeholder=\"Series\"]")
    private WebElement series;

    @FindBy(xpath = "//div[5]/md-select-menu/md-content/md-option")
    private List<WebElement> seriesOptions;

    @FindBy(css = "md-option[value=\"n1\"]")
    private WebElement n1SeriesOption;

    @FindBy(css = "md-select[placeholder=\"Instance type\"]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[6]/md-select-menu/md-content/md-optgroup/md-option")
    private List<WebElement> instanceTypeOptions;

    @FindBy(xpath = "//div[6]/md-select-menu/md-content/md-optgroup/md-option[1]")
    private WebElement instanceFirstType;

    @FindBy(css = "md-checkbox[ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    private WebElement addGPUs;

    @FindBy(xpath = "//md-select[contains(@aria-label, \"Number of GPUs\")]/md-select-value")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//div[7]/md-select-menu/md-content/md-option")
    private List<WebElement> numberOfGPUsOptions;

    @FindBy(xpath = "//div[7]/md-select-menu/md-content/md-option[2]")
    private WebElement numberOfGPUsOption;

    @FindBy(xpath = "//md-select[contains(@aria-label, \"GPU type\")]/md-select-value")
    private WebElement gpuType;

    @FindBy(xpath = "//div[8]/md-select-menu/md-content/md-option")
    private List<WebElement> gpuTypeOptions;

    @FindBy(xpath = "//md-option[@value=\"NVIDIA_TESLA_V100\"]")
    private WebElement gpuTypeTesla100Option;

    @FindBy(xpath = "//md-select[@placeholder=\"Local SSD\"]")
    private WebElement localSSD;

    @FindBy(xpath = "//div[9]/md-select-menu/md-content/md-option")
    private List<WebElement> localSSDOptions;

    @FindBy(xpath = "//div[9]/md-select-menu/md-content/md-option[3]")
    private WebElement localSSDOption2x375;

    @FindBy(xpath = "//md-select[contains(@aria-label, \"Datacenter location\")]")
    private WebElement dataCenterLocation;

    @FindBy(xpath = "//div[10]/md-select-menu/md-content/md-option")
    private List<WebElement> dataCenterLocationOptions;

    @FindBy(xpath = "//div[10]/md-select-menu/md-content/md-option[5]")
    private WebElement dataCenteAnyLocation;

    @FindBy(xpath = "//md-select[contains(@aria-label, \"Committed usage\")]")
    private WebElement commitedUsage;

    @FindBy(xpath = "//div[11]/md-select-menu/md-content/md-option")
    private List<WebElement> commitedUsageOptions;

    @FindBy(xpath = "//div[11]/md-select-menu/md-content/md-option[@value=\"1\"]")
    private WebElement commitedUsageOptionOne;

    @FindBy(xpath = "//button[contains(text(), \"Add to Estimate\")]")
    private WebElement addToEstimateButton;

    @FindBy(css = "#email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = "//md-select[contains(@aria-label, \"VM Class\")]")
    private WebElement vmClass;

    @FindBy(xpath = "//div[4]/md-select-menu/md-content/md-option")
    private List<WebElement> vmClassOptions;

    @FindBy(xpath = "//div[4]/md-select-menu/md-content/md-option[1]")
    private WebElement vmClassRegularOption;

    public CalculatorPage(WebDriver driver, Logger logger) {
        super(driver);
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage enterTermToEngineField(Product product) {
        ExplicitWaiters.waitForFrame(driver, mainFrame);
        ExplicitWaiters.waitForFrame(driver, frameInMain);
        ExplicitWaiters.waitForToBeClickable(driver, searchEngineField);
        searchEngineField.click();
        searchEngineField.sendKeys(product.getValue());
        searchEngineField.sendKeys(Keys.ARROW_DOWN);
        searchEngineField.sendKeys(Keys.ENTER);
        logger.info("Sort of product entered");
        return this;
    }

    public CalculatorPage enterNumberOfInstances(String numberOfInstances) {
        numberOfInstancesField.sendKeys(numberOfInstances);
        logger.info("Number of instances entered");
        return this;
    }

    public CalculatorPage chooseOperatingSystems(OperatingSystems term) {
        operatingSystems.click();
        ExplicitWaiters.waitForToBeClickable(driver, operatingSystemsLastOption);
        SearchInListUtil.findOptionAndClickToIt(operatingSystemsOptions, term.getValue());
        logger.info("Operating system selected");
        return this;
    }

    public CalculatorPage chooseVMClass(VMClass term) {
        ExplicitWaiters.waitForToBeClickable(driver, vmClass);
        vmClass.click();
        ExplicitWaiters.waitForToBeClickable(driver, vmClassRegularOption);
        SearchInListUtil.findOptionAndClickToIt(vmClassOptions, term.getValue());
        logger.info("Virtual machine selected");
        return this;
    }

    public CalculatorPage chooseSeries(Series term) {
        series.click();
        ExplicitWaiters.waitForToBeClickable(driver, n1SeriesOption);
        SearchInListUtil.findOptionAndClickToIt(seriesOptions, term.name());
        logger.info("Series selected");
        return this;
    }

    public CalculatorPage chooseInstanceType(String term) {
        ExplicitWaiters.waitForToBeClickable(driver, instanceType);
        instanceType.click();
        ExplicitWaiters.waitForToBeClickable(driver, instanceFirstType);
        SearchInListUtil.findOptionAndClickToIt(instanceTypeOptions, term);
        logger.info("Instance type selected");
        return this;
    }

    public CalculatorPage addGPUs(NumberOfGPU number, GPUTypes type) {
        ExplicitWaiters.waitForToBeClickable(driver, addGPUs);
        addGPUs.click();
        ExplicitWaiters.waitForToBeClickable(driver, numberOfGPUs);
        numberOfGPUs.click();
        ExplicitWaiters.waitForToBeClickable(driver, numberOfGPUsOption);
        SearchInListUtil.findOptionAndClickToIt(numberOfGPUsOptions, number.getValue());
        gpuType.click();
        ExplicitWaiters.waitForToBeClickable(driver, gpuTypeTesla100Option);
        SearchInListUtil.findOptionAndClickToIt(gpuTypeOptions, type.name());
        logger.info("GPUs selected");
        return this;
    }

    public CalculatorPage chooseLocalSSD(LocalSSDs number) {
        localSSD.click();
        ExplicitWaiters.waitForToBeClickable(driver, localSSDOption2x375);
        SearchInListUtil.findOptionAndClickToIt(localSSDOptions, number.getValue());
        logger.info("Local SSD selected");
        return this;
    }

    public CalculatorPage chooseDataCenterLocation(DataCenterLocations location) {
        dataCenterLocation.click();
        ExplicitWaiters.waitForToBeClickable(driver, dataCenteAnyLocation);
        SearchInListUtil.findOptionAndClickToIt(dataCenterLocationOptions, location.getValue());
        logger.info("Data center lovation selected");
        return this;
    }

    public CalculatorPage chooseCommitedUsage(CommitedUsages term) {
        commitedUsage.click();
        ExplicitWaiters.waitForToBeClickable(driver, commitedUsageOptionOne);
        SearchInListUtil.findOptionAndClickToIt(commitedUsageOptions, term.getValue());
        logger.info("Commited usage selected");
        return this;
    }

    public EstimateCompletePage addToEstimate() {
        addToEstimateButton.click();
        ExplicitWaiters.waitForToBeClickable(driver, emailEstimate);
        logger.info("Estimate complete");
        return new EstimateCompletePage(driver, logger);
    }

    @Override
    protected AbstractPage openPage() {
        System.out.println("You don't need to open this page directly!");
        return null;
    }
}
