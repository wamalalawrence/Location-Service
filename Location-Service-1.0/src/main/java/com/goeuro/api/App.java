package com.goeuro.api;

/**
 * Created by wamalalawrence on 15/11/04.
 */

import com.goeuro.api.controller.LocationController;
import com.goeuro.api.service.LocationService;
import com.goeuro.api.service.impl.LocationServiceImpl;

import java.io.IOException;

import static spark.Spark.setPort;
import static spark.SparkBase.staticFileLocation;


/**
 * @apiNote
 * Location service API
 * Spark will start an embedded Jetty server that listens on Port 4567
 * to expose routes via http at given urls
 * e.g http://localhost:4567/v2/position/suggest/en/Berlin
 *
 */
public class App 
{
    public App() {
//        staticFileLocation("/public"); // Static files
    }

    // main
    public static void main( String[] args ) throws IOException {
        LocationService locationService = new LocationServiceImpl();
        new LocationController(locationService);
    }
}
