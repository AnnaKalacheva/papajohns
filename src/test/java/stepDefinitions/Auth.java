package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth {
    private WebDriver driver;

    public Auth() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on menu page$")
    public void iAmOnMenuPage() {
        this.driver.get("https://test-new2.papajohns.ru/");
    }

    @When("^I select region$")
    public void iSelectRegion() {
        WebElement button = driver.findElement(By.xpath("//span[@class='hpPxP']"));
        button.click();
    }

    @And("^I open Sign in pop-up$")
    public void iOpenSignInPopUp() {
        WebElement button = driver.findElement(By.xpath("//button[@class='fZjsf _36X8O']"));
        button.click();
    }

    @And("^I enter Telephone: \"([^\"]*)\"$")
    public void iEnterTelephone(String telephone) {
        WebElement telInput = driver.findElement(By.xpath("//input[@id='phone']"));
        telInput.sendKeys(telephone);
    }

    @And("^I enter Password: \"([^\"]*)\"$")
    public void iEnterPassword(String password)  {
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys(password);
    }

    @And("^I click sign in$")
    public void iClickSignIn() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='fZjsf _3lr8i']"));
        submitButton.click();
    }

    @Then("^I see authorized profile$")
    public void iSeeAuthorizedProfile() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_1LrnK']")));

//        Actions builder = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("//div[@class='_3C7a5']"));
//        builder.moveToElement(element).perform();
    }

}
