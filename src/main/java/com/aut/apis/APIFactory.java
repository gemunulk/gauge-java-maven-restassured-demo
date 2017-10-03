package com.aut.apis;

import com.thoughtworks.gauge.BeforeSuite;

public class APIFactory{

    public static BaseAPI baseAPI;
    public static GoogleBooksAPI googleBooksAPI;


    @BeforeSuite
    public void init(){
        baseAPI = new BaseAPI();
        googleBooksAPI = new GoogleBooksAPI();
    }

}
