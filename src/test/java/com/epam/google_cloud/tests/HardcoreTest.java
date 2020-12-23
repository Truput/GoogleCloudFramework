package com.epam.google_cloud.tests;

import com.epam.google_cloud.driver.DriverSingltone;
import com.epam.google_cloud.models.CalculatorFormModel;
import com.epam.google_cloud.pages.CloudGoogleHome;
import com.epam.google_cloud.pages.CompleteEstimatePage;
import com.epam.google_cloud.pages.TemporaryEmailPage;
import com.epam.google_cloud.service.CalculatorFormCreator;
import com.epam.google_cloud.utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class HardcoreTest {
    private WebDriver driver;
    private static final String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    private final CalculatorFormModel calculatorForm = CalculatorFormCreator.withStandartOptions();
    private Logger logger = LogManager.getRootLogger();

    @BeforeMethod()
    public void browserSetup() {
        driver = DriverSingltone.getDriver();
    }

    @Test
    public void estimatedCostInEmailMatchWithCalculator() {
        CompleteEstimatePage completeEstimatePage = new CloudGoogleHome(driver, logger)
                .openPage()
                .searchByTerm(SEARCH_TERM)
                .openResultLink()
                .enterTermToEngineField(calculatorForm.getProduct())
                .enterNumberOfInstances(calculatorForm.getNumberOfInstances())
                .chooseOperatingSystems(calculatorForm.getOperatingSystem())
                .chooseVMClass(calculatorForm.getVmClass())
                .chooseSeries(calculatorForm.getSeries())
                .chooseInstanceType(calculatorForm.getMachineType().getValue())
                .addGPUs(calculatorForm.getNumberOfGPUs(), calculatorForm.getGpuType())
                .chooseLocalSSD(calculatorForm.getLocalSSDNumber())
                .chooseDataCenterLocation(calculatorForm.getDataCenterLocation())
                .chooseCommitedUsage(calculatorForm.getCommitedUsage())
                .addToEstimate();
        double estimatedCostInCalculator = completeEstimatePage.getTotalEstimatedCost();
        completeEstimatePage.clickEmailEstimateButton();
        TemporaryEmailPage temporaryEmailPage = completeEstimatePage.createNewTabAndSwitch();
        temporaryEmailPage.openPage().copyGeneratedEmail().switchToTab();
        completeEstimatePage.inputEmail().sendEmail().switchToTab();
        temporaryEmailPage.openEmail();
        double estimatedCostInEmail = temporaryEmailPage.getEstimatedCost();
        assertThat(estimatedCostInEmail, is(equalTo(estimatedCostInCalculator)));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverSingltone.closeBrowser();
    }
}
