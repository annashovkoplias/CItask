package ci.steps;

import ci.core.Configuration;
import ci.pages.SearchPage;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ci.core.BaseSteps;

public class UITests extends BaseSteps {

    private SearchPage searchPage;

    @BeforeScenario
    public void beforeScenario() {
        searchPage = new SearchPage(driver);
    }

    @Given("as user")
    public void firstStep() {
        searchPage.goToSelectedPage(Configuration.getInstance().getSeachUrl());
    }

    @When("I make a search")
    public void secondStep() {
        searchPage.proceedSearch();
    }

    @Then("verify that results are present")
    public void thirdStep() {
        searchPage.verifyElementPresent(SearchPage.SEARCH_RESULTS);
    }
}
