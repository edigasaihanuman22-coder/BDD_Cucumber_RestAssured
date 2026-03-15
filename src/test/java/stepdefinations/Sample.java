package stepdefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Sample {

    int num1;
    int num2;
    int result;

    @Given("I have two numbers {int} and {int}")
    public void i_have_two_numbers(int a, int b) {
        num1 = a;
        num2 = b;
    }

    @When("I add the numbers")
    public void i_add_the_numbers() {
    	System.out.println("caucuting number");
        result = num1 + num2;
    	System.out.println(result);
    }
     

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        Assert.assertEquals(expected, result);
    }
}
