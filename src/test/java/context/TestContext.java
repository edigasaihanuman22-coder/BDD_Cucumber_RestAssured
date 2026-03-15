package context;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestContext {

    private Response response;

    // Getter
    public Response getResponse() {
        return response;
    }

    // Setter
    public void setResponse(Response response) {
        this.response = response;
    }
}