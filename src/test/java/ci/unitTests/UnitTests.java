package ci.unitTests;

import org.junit.Assert;
import org.junit.Test;
import ci.core.BaseSteps;
import ci.core.Configuration;

public class UnitTests {

    @Test
    public void testGetSearchQuery() {
        String expectedResult = "Hello world";
        Assert.assertTrue(Configuration.getInstance().getSearchQuery().equals(expectedResult));
    }


    @Test
    public void testGetSearchUrl() {
        String expectedResult = "https://google.com";
        Assert.assertTrue(Configuration.getInstance().getSeachUrl().equals(expectedResult));
    }

    @Test
    public void testCreatingDriver() {
        BaseSteps bs = new BaseSteps();
        bs.beforeStory();
        Assert.assertNotNull(bs.driver);
        bs.driver.close();
    }
}


