package com.goeuro.api.service;

import com.goeuro.api.domain.Location;

import java.io.IOException;
import java.util.List;

/**
 * Created by wamalalawrence on 15/11/04.
 * LocationService Interface
 */

public interface LocationService {

    public static final String API_CONTEXT = "/api.goeuro.com/api/v2/position/suggest/en";

    /**
     *
     * @param city
     * @return List<Location>
     * @throws IOException
     * @apiNote GET	rest url:- /v2/position/suggest/en/<CITY_NAME>	Get a specific location
     */
    public List<Location> getLocations(String city) throws IOException;
}