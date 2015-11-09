package com.goeuro.api.dao.impl;

import com.goeuro.api.dao.LocationDao;
import com.goeuro.api.domain.Location;
import com.goeuro.api.domain.LocationDataWrapper;
import com.goeuro.api.util.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wamalalawrence on 15/11/04.
 * LocationDaoImpl - data layer implementaion
 */
public class LocationDaoImpl implements LocationDao {

    private List<Location> locations;

    /**
     * @apiNote:-
     * - instantiates static data from a file for now (resources/location-data.json)
     * - loads all json location objects
     * @throws IOException if data file is not found
     */
    public LocationDaoImpl() throws IOException
    {
//      TODO:- i would have used mongodb for database
        InputStream inputStream = LocationDaoImpl.class.getClassLoader().getResourceAsStream("location-data.json");
        if(inputStream != null)
        {
            locations = (List<Location>) Utils.getJsonObjects(inputStream);
        } else
        {
            throw new IOException("data file location not found");
        }
    }

    /**
     *
     * @param city
     * @return List<Location>
     * @throws IOException
     * @apiNote:- finds locations with the specified city name
     */
    public List<Location> getLocations(String city) throws IOException
    {
        List<Location> searchedLocations = new ArrayList<Location>();
        for(Location location : locations)
        {
            if(location.getName().equalsIgnoreCase(city))
            {
                searchedLocations.add(location);
            }
        }
        return searchedLocations;
    }
}
