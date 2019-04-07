/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vasher
 */
public class Scrabbler {

    private static final String FILENAME = "words.txt";
    private static final char WORD_END = '$';
    private HashMap<Character, HashMap> dictStartMap = new HashMap<>();
    private HashMap<Character, HashMap> dictEndMap = new HashMap<>();
    private HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();
    
    public void processInput(String input){
        char[] cArr = input.toCharArray();
        for(int i = 0; i < cArr.length; i++){
            if(!inputMap.containsKey(cArr[i])){
                inputMap.put(cArr[i], 1);
            } else {
                inputMap.put(cArr[i], ((int)inputMap.get(cArr[i]))+1);
            }
        }
    }
    
    public List<String> listAllWords(){
        List<String> result = new ArrayList<>();
        for(Map.Entry<Character, HashMap> entry: dictStartMap.entrySet()){
            
        }
    }
    
    public void processWord(char[] arr){
        int start = 0;
        int end = arr.length - 1;
        HashMap<Character, HashMap> startMap = dictStartMap, endMap = dictEndMap;
        if(arr.length > 0){
            while(start < arr.length && end >= 0){
                //start to end hashMap
                startMap = buildMap(startMap, arr[start]);
                start++;
                endMap = buildMap(endMap, arr[end]);
                end--;
            }
        }
    }
    
    public HashMap buildMap(HashMap<Character, HashMap> map, Character c){
        if(!map.containsKey(c)){
            map.put(c, new HashMap<>());
        }
        return map.get(c);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scrabbler sc = new Scrabbler();
        BufferedReader br = null;
        FileReader fr = null;
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = sCurrentLine + "$";
                sc.processWord(sCurrentLine.toCharArray());
            }
            System.out.println("HashMap built");
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

}
