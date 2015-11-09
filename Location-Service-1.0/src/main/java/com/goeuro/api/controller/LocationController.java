package com.goeuro.api.controller;

/**
 * Created by wamalalawrence on 15/11/04.
 */

import com.goeuro.api.domain.Location;
import com.goeuro.api.exception.ResponseError;
import com.goeuro.api.service.LocationService;

import static com.goeuro.api.util.JsonTransformer.json;
import static com.goeuro.api.util.JsonTransformer.toJson;
import static spark.Spark.*;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;


/**
 * Created by wamalalawrence on 15/11/04.
 * LocationController
 * exposes rest api functions
 */

public class LocationController {


    public LocationController(final LocationService locationService) {

        get(LocationService.API_CONTEXT+"/:CITY_NAME", (req, res) -> {
            //process request
            String city = StringEscapeUtils.escapeHtml4(req.params(":CITY_NAME"));
            List<Location> locations = locationService.getLocations(city);
            if (locations != null) {
                return locations;
            }
            res.status(400);
            return new ResponseError("No location for city '%s' found", city);
        }, json());

        after((req, res) -> {
            res.type("application/json");
        });

        // TODO:- more rest functions to be add

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(toJson(new ResponseError(e)));
        });

    }
}
