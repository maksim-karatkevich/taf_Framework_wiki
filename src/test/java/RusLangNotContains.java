import com.epam.taf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testUtils.BaseTest;

@Listeners(ScreenshotExecutor.class)
public class RusLangNotContains extends BaseTest {

    @Test
    public void rusLangNotContainsOnBlock() {
        Assert.assertTrue(homePageSteps.findRusLangOnBlock());

    }
}
