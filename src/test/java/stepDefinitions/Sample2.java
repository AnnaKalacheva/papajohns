package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public  class Sample2 {
    private WebDriver driver;

    public Sample2() {
        this.driver = Hooks.driver;
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }
}
