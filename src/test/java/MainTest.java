import com.epam.taf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import testUtils.BaseTest;
import testUtils.DataProviders;

@Listeners(ScreenshotExecutor.class)
public class MainTest extends BaseTest {


    @Test(dataProvider = "correctSearchData", dataProviderClass = DataProviders.class)
    public void testSearchRequest(String language, String request) {
        String articleTitle = homePageSteps
                .chooseLanguageOnDropdownMenu(language)
                .makeSearchRequest(request)
                .getArticleTitle();
        Assert.assertEquals(articleTitle, request, "Expected result is not equal to the actual");

    }
}
