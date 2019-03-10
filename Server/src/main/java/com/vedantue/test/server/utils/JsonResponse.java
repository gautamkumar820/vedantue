package com.vedantue.test.server.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonResponse {
    public static String constructResponse(String message) {
        JsonObject response = new JsonObject();
        response.addProperty("message", message);
        return response.toString();
    }

    public static String constructResponse(String status, String message) {
        JsonObject response = new JsonObject();
        response.addProperty("status", status);
        response.addProperty("message", message);
        return response.toString();
    }

    public static String encapsulate(String status, JsonElement data) {
        JsonObject response = new JsonObject();
        response.addProperty("status", status);
        response.add("data", data);
        return response.toString();
    }

    public static String encapsulate(String status, String message, JsonElement data) {
        JsonObject response = new JsonObject();
        response.addProperty("status", status);
        response.addProperty("message", message);
        response.add("data", data);
        return response.toString();
    }
}
