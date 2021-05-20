package com.nitish.JsonReader.JsonReader.JsonReader;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class JsonReader {

    public static void main(String[] args) throws IOException {
        String jsonMappingFile = "src/main/resources/TestJson.json";
        JSONObject jsonObject = parseJSONFile(jsonMappingFile);
        jsonObject.keys().forEachRemaining(key -> {
            Object value = jsonObject.get(key);
            if(!(value instanceof JSONObject)) {
                handleSimpleMapping(key, value);
            } else {
                handleComplexMapping((JSONObject)value);
            }
        });
    }

    public static void handleSimpleMapping(Object key, Object value){
        System.out.println("**************************************************");
        System.out.println(key + " : " + value);
        System.out.println("**************************************************");
    }

    public static void handleComplexMapping(JSONObject valueJsonObj){
        for(Iterator<String> it = valueJsonObj.keys(); it.hasNext();) {
            String key = it.next();

            Object value = valueJsonObj.get(key);
            if(value instanceof JSONObject){
                System.out.println("**************************************************");
                System.out.println(key + " : " + value);
                System.out.println("**************************************************");
            } else {
                System.out.println("**************************************************");
                System.out.println(key + " : " + value);
                System.out.println("**************************************************");
            }
        }
    }

    public static JSONObject parseJSONFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return new JSONObject(content);
    }


}
