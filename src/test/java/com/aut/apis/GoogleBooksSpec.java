package com.aut.apis;


import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class GoogleBooksSpec{

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

        // Adding values to the Data store
        APIFactory.baseAPI.scenarioStore.put(apiEndPoint, response);

        Gauge.writeMessage(response.prettyPrint());

    }

}
