package com.aut.apis;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BaseSpec{

    ValidatableResponse jsonResponse;


    @Step("Then the status code from <apiName> should be <statusCode>")
    public void statusCodeShouldBe(String apiName, int statusCode) {

        // Fetching Values from Data store
        Response response = (Response) APIFactory.baseAPI.scenarioStore.get(apiName);
        jsonResponse = response.then().statusCode(statusCode);
    }

    @Step("And response includes the following <table>")
    public void responseIncludes(Table table) {
        APIFactory.baseAPI.validateResponseEqualTo(jsonResponse, table);
    }

    @Step("And response includes the following in any order <table>")
    public void responseIncludesInAnyOrder(Table table) {
        APIFactory.baseAPI.validateResponseContainsInAnyOrder(jsonResponse, table);
    }

}
