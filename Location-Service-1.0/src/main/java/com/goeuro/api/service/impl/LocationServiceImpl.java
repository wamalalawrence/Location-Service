package com.goeuro.api.service.impl;

import com.goeuro.api.dao.LocationDao;
import com.goeuro.api.dao.impl.LocationDaoImpl;
import com.goeuro.api.domain.Location;
import com.goeuro.api.service.LocationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wamalalawrence on 15/11/04.
 * implementation of LocationService
 */
public class LocationServiceImpl implements LocationService {

    private LocationDao locationDao;

    public LocationServiceImpl() throws IOException {
        locationDao = new LocationDaoImpl();
    }

    public List<Location> getLocations(String city) throws IOException {
        return locationDao.getLocations(city);
    }

    //TODO:- more CRUD functions may be added here
}
