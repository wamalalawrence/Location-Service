package com.goeuro.api.dao;

import com.goeuro.api.domain.Location;

import java.io.IOException;
import java.util.List;

/**
 * Created by wamalalawrence on 15/11/04.
 */
public interface LocationDao {

    public List<Location> getLocations(String city) throws IOException;
}
