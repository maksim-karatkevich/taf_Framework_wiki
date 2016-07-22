import com.epam.taf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testUtils.BaseTest;
import testUtils.DataProviders;

@Listeners(ScreenshotExecutor.class)
public class InvalidDataSearchTest extends BaseTest {

    @Test(dataProvider= "incorrectData", dataProviderClass = DataProviders.class)
    public void invalidDataSearchTest(String language, String request, String response){
        Assert.assertEquals(homePageSteps
                .chooseLanguageOnDropdownMenu(language)
                .makeSearchRequest(request)
                .getNotFoundMassage(), response);

    }
}
