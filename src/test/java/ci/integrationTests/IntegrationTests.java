package ci.integrationTests;

import org.junit.Assert;
import org.junit.Test;
import ci.core.BaseSteps;
import ci.core.Configuration;
import ci.pages.SearchPage;

/**
 * Created by kirde on 18.07.2016.
 */
public class IntegrationTests {

    @Test
    public void testOpenCloseDriver() {
        BaseSteps bs = new BaseSteps();
        bs.beforeStory();
        Assert.assertNotNull(bs.driver);
        bs.afterStory();
    }

    @Test
    public void testOpenAnyUrl() {
        SearchPage sp;
        BaseSteps bs = new BaseSteps();
        String pageTitle = "Main";
        bs.beforeStory();
        sp = new SearchPage(bs.driver);
        sp.goToSelectedPage("http://english-club.tv");
        Assert.assertTrue(bs.driver.getTitle().equals(pageTitle));
        bs.afterStory();
    }

    @Test
    public void testReadFromPropertiesAndVisitSite() {
        SearchPage sp;
        String pageUrl = "google.com";
        BaseSteps bs = new BaseSteps();
        bs.beforeStory();
        sp = new SearchPage(bs.driver);
        sp.goToSelectedPage(Configuration.getInstance().getSeachUrl());
        Assert.assertTrue(bs.driver.getCurrentUrl().contains(pageUrl));
        bs.afterStory();
    }
}
