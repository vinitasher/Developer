/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pigtail.pigtailspark;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author vasher
 */
public class PigTailApi {
    public static void main(String[] args) {
    PigTailTranslator impl = new PigTailTranslator();

    // curl http://localhost:4567/a
    get("/:short", (request, response) -> {
      System.out.println("GET Request:"+request);
      return "GET";
    });

    // curl -d "{'url'='http://foo.tld'}" http://localhost:4567
    post("/", (request, response) -> {
      System.out.println("POST Request:"+request);
      return "POST";
    });
  }
}
