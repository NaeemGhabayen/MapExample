package com.example.mapapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {

    public HashMap<String, String> parse(JSONObject jObject) {

        HashMap<String, String> dataList = new HashMap<>();


        try {
            String name = jObject.getString("name");

            String lattiude = jObject.getJSONObject("geometry")
                    .getJSONObject("location").getString("lat");
            String longtiude = jObject.getJSONObject("geometry")
                    .getJSONObject("location").getString("lng");

            dataList.put("name", name);
            dataList.put("lat", lattiude);
            dataList.put("lng", longtiude);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return dataList;
    }

    private List<HashMap<String, String>> parseJsonArray(JSONArray jsonArray) {
        List<HashMap<String, String>> datalist = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                HashMap<String, String> data = parse((JSONObject) jsonArray.get(i));
                datalist.add(data);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datalist;
    }

    public List<HashMap<String, String>> parsResult(JSONObject object) {
        JSONArray jsonArray = null;
        try {
            jsonArray = object.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parseJsonArray(jsonArray);
    }
}
