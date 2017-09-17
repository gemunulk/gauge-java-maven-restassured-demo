package com.aut.apis;

import com.thoughtworks.gauge.BeforeSuite;

public class APIFactory{

    public static GoogleBooksAPI googleBooksAPI;


    @BeforeSuite
    public void init(){
        googleBooksAPI = new GoogleBooksAPI();
    }

}
