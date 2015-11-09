package com.goeuro.api.util;

/**
 * Created by wamalalawrence on 15/11/03.
 */

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {

        return JsonTransformer::toJson;
    }

}
