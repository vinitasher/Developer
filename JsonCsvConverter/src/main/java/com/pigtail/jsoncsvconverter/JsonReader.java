/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pigtail.jsoncsvconverter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vasher
 */
public class JsonReader {
    
    static List<String> headers;
    static Map<String, Set> data;

    public static JsonObject readJson(String fileName) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        Object obj = parser.parse(new FileReader(fileName));

        JsonObject jsonObject = (JsonObject) obj;
        return jsonObject;
    }
    
    public static void processJson(JsonObject json){
        for(Map.Entry<?, ?> entry: json.entrySet()){
            String key = entry.getKey().toString();
            HashSet locations = new HashSet<Integer>();
            JsonArray value = (JsonArray) entry.getValue();
            for(JsonElement element: value){
                int index = headers.indexOf(element.getAsString());
                if(index == -1){
                    headers.add(element.getAsString());
                    index = headers.indexOf(element.getAsString());
                }
                locations.add(index);
                data.put(key, locations);
            }
            System.out.println(key + "" +value);
        }
    }
    
    public static void jsonToCsv(FileWriter w) throws IOException{
        List<String> topLine = new ArrayList<String>();
        topLine.add(" ");
        topLine.addAll(headers);
        writeLine(w, topLine);
        
        for(String entry: data.keySet()){
            List<String> line = new ArrayList<String>();
            line.add(entry);
            Set locations = data.get(entry);
            for(int i=0; i<headers.size(); i++){
                if(locations.contains(i)){
                    line.add("1");
                } else {
                    line.add("0");
                }
            }
            writeLine(w, line);
        }
    }
    
    public static void writeLine(FileWriter w, List<String> values) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String value : values) {
            if (!first) {
                sb.append(",");
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        headers = new ArrayList<>();
        data = new HashMap<String, Set>();
        processJson(readJson("Example.json"));
        String csvFile = "output.csv";
        FileWriter writer = new FileWriter(csvFile);
        jsonToCsv(writer);
        writer.flush();
        writer.close();
    }

}
