/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pigtail.pigtailspark;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author vasher
 */
public class PigTailTranslator {
    HashMap<String, String> map = new HashMap<String, String>();
    int key_length = 3;
    char[] symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    
  public String get(String shortURI) {
      return shortURI;
      
  }

  public String set(String longURL) {
      return longURL;
  }

    private String generatekey(String longURL) {
      Random r = new Random();
      StringBuilder keystr = new StringBuilder();
      for(int i=0; i < key_length; i++){
        keystr.append(symbols[r.nextInt(symbols.length-1)]);
        }
      return keystr.toString();
    }
}
