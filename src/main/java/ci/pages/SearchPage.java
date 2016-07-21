package ci.pages;

import ci.core.Configuration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kyrylo_Delehoidin on 2/1/2016.
 */
public class SearchPage {
    private static final String SEARCH_FIELD = ".//*[@id='sfdiv']";
    public static final String SEARCH_RESULTS = ".//*[@id='center_col']";


    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSelectedPage(String url) {
        driver.get(url);
    }

    public void proceedSearch() {
        driver.findElement(By.xpath(SEARCH_FIELD)).click();
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Configuration.getInstance().getSearchQuery());
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Keys.RETURN);
    }

    public void verifyElementPresent(String xpath) {
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
    }
}