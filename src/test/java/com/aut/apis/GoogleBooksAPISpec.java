package com.aut.apis;


import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class GoogleBooksAPISpec{

    //private RequestSpecification request;
    //private Response response;
    private ValidatableResponse jsonResponse;

    @Step("Given a book exists with an ISBN of <table>")
    public void implementation1(Table table) {

        HashMap<String, String> paramsHash = new HashMap<>();
        paramsHash = APIFactory.googleBooksAPI.convertTableToAHashMap(table);

        RequestSpecification request = given().params(paramsHash);
        APIFactory.googleBooksAPI.setRequest(request);
    }

    @Step("When a user makes a GET request to <apiEndPoint> API")
    public void implementation2(String apiEndPoint) {
        //response = request.when().get(System.getenv(apiEndPoint));
        Response response = APIFactory.googleBooksAPI.getRequest().when().get(System.getenv(apiEndPoint));
        APIFactory.googleBooksAPI.setResponse(response);
        Gauge.writeMessage(response.prettyPrint());
    }

    @Step("Then the status code from GOOGLE_BOOKS should be <statusCode>")
    public void statusCodeShouldBe(int statusCode) {
        //jsonResponse = response.then().statusCode(statusCode);
        jsonResponse = APIFactory.googleBooksAPI.getResponse().then().statusCode(statusCode);
        APIFactory.googleBooksAPI.setValidatableResponse(jsonResponse);
    }

    @Step("And response from GOOGLE_BOOKS includes the following <table>")
    public void implementation4(Table table) {
        jsonResponse = APIFactory.googleBooksAPI.getValidatableResponse();
        APIFactory.googleBooksAPI.validateResponseEqualTo(jsonResponse, table);
    }

    @Step("And response from GOOGLE_BOOKS includes the following in any order <table>")
    public void implementation5(Table table) {
        jsonResponse = APIFactory.googleBooksAPI.getValidatableResponse();
        APIFactory.googleBooksAPI.validateResponseContainsInAnyOrder(jsonResponse, table);
    }
}
