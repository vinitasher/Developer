/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

/**
 *
 * @author vasher
 */
public class CommonCharacters {
    static final int MAX_CHAR = 256;
    
    private int[] generateCharArray(String s){
        int[] charArr = new int[MAX_CHAR];
        if(s == null){
            return charArr;
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' ')
                charArr[s.charAt(i)] += 1; 
        }
        return charArr;
    } 
    
    public String findCommonCharacters(String s1, String s2){
        int[] s1Arr = generateCharArray(s1);
        int[] s2Arr = generateCharArray(s2);
        
        StringBuilder str = new StringBuilder();
        for(int i=0; i<MAX_CHAR; i++){
            int min = Math.min(s1Arr[i], s2Arr[i]);
            while(min > 0){
                str.append((char)(i));
                min--;
            }
        }
        return str.toString();
    }
    
    
    
    public static void main(String[] args){
        String s1 = StringUtil.sampleInput();
        String s2 = "geeksfor";
        CommonCharacters cc = new CommonCharacters();
        System.out.println(cc.findCommonCharacters(s1, s2));
        
    }
}
