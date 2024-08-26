package myapps.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import myapps.utils.CommonMethods;
import myapps.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestPageSteps extends CommonMethods {


    // Test Case 1//
    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        openBrowserAndLaunchApplication();
    }


    @Then("I should see the email address input, password input, and login button")
    public void i_should_see_the_email_address_input_password_input_and_login_button() {
        assertTrue(testPage.emailTextField.isDisplayed());
        assertTrue(testPage.passwordTextfield.isDisplayed());
        assertTrue(testPage.signInButton.isDisplayed());

    }

    @When("I enter an email address and password")
    public void i_enter_an_email_address_and_password() {
        sendText(testPage.emailTextField, ConfigReader.getPropertyValue("email"));
        sendText(testPage.passwordTextfield, ConfigReader.getPropertyValue("password"));

    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        testPage.signInButton.click();
    }

    //________________________________________________________//
    //Test Case 2//


    @Then("there should be three values in the listgroup")
    public void there_should_be_three_values_in_the_listgroup() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@class='list-group']/li[contains(text(),'List')]"));
        int expectedNumberOfItems = 3;
        int actualNumberOfItems = items.size();

        TestCase.assertEquals("The number of items in the list group is not equal to 3", expectedNumberOfItems, actualNumberOfItems);
    }

    @Then("the second list item's value should be {string}")
    public void the_second_list_item_s_value_should_be(String string) {
        String actualValue = driver.findElement(By.xpath("//div[@id='test-2-div']//ul[@class='list-group']/li[2]")).getText().trim();
        assertTrue(actualValue.contains(string));


    }

    @Then("the second list item's badge value should be {int}")
    public void the_second_list_item_s_badge_value_should_be(Integer int1) {
        WebElement secondItem = driver.findElement(By.xpath("//div[@id='test-2-div']//ul[@class='list-group']/li[2]"));
        String actualBadgeValue = secondItem.findElement(By.tagName("span")).getText().trim();
        assertEquals("Badge value does not match", String.valueOf(int1));
    }

    //___________________________________________________________________//
    //Test Case 3

    @Then("{string} should be the default selected value in the test {int} div")
    public void should_be_the_default_selected_value_in_the_test_div(String string) {
        WebElement dropdown = driver.findElement(By.id("dropdownMenuButton"));
        assertEquals(string, dropdown.getText());
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String string) {
        WebElement dropdownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropdownMenu.click();
        WebElement option = driver.findElement(By.xpath("//a[text()='" + string + "']"));
        option.click();
    }


    //________________________________________________________//
//Test Case 4//
    @Then("the first button in the test should be enabled")
    public void theFirstButtonInTheTestShouldBeEnabled() {
        WebElement firstButton = driver.findElement(By.xpath("//div[@id='test-4-div']//button[@class='btn btn-lg btn-primary']"));
        assertTrue("First button is not enabled", firstButton.isEnabled());
    }

    @Then("the second button should be disabled")
    public void the_second_button_should_be_disabled() {
        WebElement secondButton = driver.findElement(By.xpath("//div[@id='test-4-div']//button[2]"));
        assertFalse("Second button is not disabled", secondButton.isEnabled());
    }


    //__________________________________________________________//
    //Test Case 5//
    @When("I wait for the button to appear in the test")
    public void iWaitForTheButtonToAppearInTheTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button")));

    }

    @When("I click the button")
    public void i_click_the_button() {
        WebElement button = driver.findElement(By.id("test5-button"));
        button.click();
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        WebElement alert = driver.findElement(By.id("test5-alert"));
        assertTrue(alert.isDisplayed());
    }

    @Then("the button should be disabled")
    public void the_button_should_be_disabled() {
        WebElement button = driver.findElement(By.id("test5-button"));
        assertFalse(button.isEnabled());
    }

    //----------------------------------------------------------//
//Test Case 6//

    private String cellValue;

    @When("I retrieve the value of the cell at coordinates \\({int}, {int})")
    public void i_retrieve_the_value_of_the_cell_at_coordinates(Integer row, Integer column) {
        WebElement cell = driver.findElement(By.xpath("//div[@id='test-6-div']//tr[" + (row + 1) + "]/td[" + (column + 1) + "]"));
        cellValue = cell.getText();
    }

    @Then("the value should be {string}")
    public void the_value_should_be(String string) {
        assertEquals(string, cellValue);
    }


}
