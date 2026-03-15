package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;
import reporting.ExtentTestManager;

import org.testng.Assert;

import context.TestContext;

public class RestAssured_sample {

    Response response;
    TestContext context;

    public RestAssured_sample(TestContext context) {
        this.context = context;
    }

    @Given("call API endpoint")
    public void call_API_Endpoint() {

        String baseURL = ConfigReader.getProperty("baseURL");
        String endpoint = "/products/1";
        ExtentTestManager.getTest().info("Full URL "+baseURL+endpoint);

        context.setResponse(
                RestAssured
                        .given()
                        .when()
                        .get(baseURL + endpoint)
        );
        ExtentTestManager.getTest().info(context.getResponse().getBody().asPrettyString());
        System.out.println(context.getResponse().getBody().asPrettyString());
    }  
    @Given("validating rating count should be {int}")
    public void validating_rating_count(int expected) {

        Response books_response = context.getResponse();
        int count = books_response.jsonPath().getInt("rating.count");
        System.out.println("Count is:  "+count);
        ExtentTestManager.getTest().info("Count "+count);
        Assert.assertEquals(expected, count);
        

    } 
    }
