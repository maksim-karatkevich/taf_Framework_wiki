package testUtils;

import com.epam.taf.driver.FactoryDriver;
import com.epam.taf.steps.HomePageSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageSteps homePageSteps;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        this.driver = FactoryDriver.getInstance();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.homePageSteps = new HomePageSteps(driver);
        this.homePageSteps.openHomePage();
    }

    @AfterMethod
    public void tearDown() {
        FactoryDriver.closeDriver();
        this.driver = null;
        this.homePageSteps = null;
    }

}
