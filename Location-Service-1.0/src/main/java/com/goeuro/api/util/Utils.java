package com.goeuro.api.util;

import com.goeuro.api.domain.Location;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by wamalalawrence on 15/11/04.
 * @apiNote this is a utilities class with some handy static functions
 */
public class Utils {

    /**
     *
     * @param inputStream
     * @return String
     * @throws IOException
     */
    public static String readFile(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        String line;
        while( (line = bufferedReader.readLine()) != null ) {
            out.append(line);
        }
        bufferedReader.close();
        return out.toString();
    }

    /**
     *
     * @param inputStream
     * @return Collection<Location>
     * @throws IOException
     */
    public static Collection<Location> getJsonObjects(InputStream inputStream) throws IOException
    {
        String json = readFile(inputStream);
        Type collectionType = new TypeToken<Collection<Location>>(){}.getType();
        Collection<Location> collection = new Gson().fromJson(json, collectionType);
        return collection;
    }

    public static Collection<Location> getJsonObjects(String jsonStr) throws IOException
    {
        Type collectionType = new TypeToken<Collection<Location>>(){}.getType();
        Collection<Location> collection = new Gson().fromJson(jsonStr, collectionType);
        return collection;
    }

}
