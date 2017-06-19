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
public class SmallestLargestWord {
    String smallestWord;
    String largestWord;
    public void calculateSmallestLargestWord(String s){
        int minWordStartIndex = 0;
        int maxWordStartIndex = 0;
        int currentWordStartIndex = 0;
        int currentWordEndIndex = 0;
        int minWordLength = Integer.MAX_VALUE;
        int maxWordLength = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\r' || i == s.length()-1){
                currentWordEndIndex = i;
                if(i == s.length() - 1){
                    currentWordEndIndex++;
                }
                if(currentWordEndIndex - currentWordStartIndex > 0 && currentWordEndIndex - currentWordStartIndex > maxWordLength){
                    maxWordLength = currentWordEndIndex - currentWordStartIndex;
                    maxWordStartIndex = currentWordStartIndex;
                }
                if(currentWordEndIndex - currentWordStartIndex > 0 && currentWordEndIndex - currentWordStartIndex < minWordLength){
                    minWordLength = currentWordEndIndex - currentWordStartIndex;
                    minWordStartIndex = currentWordStartIndex;
                }
                currentWordStartIndex = i + 1;
            }
        }
        smallestWord = s.substring(minWordStartIndex, minWordLength + minWordStartIndex);
        largestWord = s.substring(maxWordStartIndex, maxWordStartIndex + maxWordLength);
    }
    
    public static void main(String[] args){
        SmallestLargestWord slw = new SmallestLargestWord();
        String s = StringUtil.sampleInput();
        slw.calculateSmallestLargestWord(s);
        System.out.println("LargestWord:"+slw.largestWord);
        System.out.println("SmallestWord:"+slw.smallestWord);
    }
    
}
