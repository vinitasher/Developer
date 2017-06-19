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
public class WildcardMatching {
    
    private boolean isMatch(String s, String p){
        int i=0, j=0;
        boolean star = false;
        boolean result = true;
        int oneWildCard = 0;
        while(i<s.length() && j<p.length()){
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
            if(c2 == '*'){
                star = true;
                j++;
                continue;
            } else if(c2 == '?'){
                //go to next char for both string, reset star
                i++;
                j++;
                oneWildCard++;
                continue;
            }
            if(c1 != c2){
                if(oneWildCard>0){
                    i++;
                    oneWildCard--;
                    continue;
                }
                if(star){
                    i++;
                    continue;
                }
                // if no * or ? present then unequal chars result in not a match
                result = false;
                break;
            } else {
                star = false;
                i++;
                j++;
            }
        }
        while(j<p.length()){
            if(p.charAt(j) != '*'){
                result = false;
            }
            j++;
        }
        if(i<s.length() && !star){
            result = false;
        }
        return result;
    }
    
    public static void main(String[] args){
        String s1 = StringUtil.readInputString();
        String s2 = StringUtil.readInputString();
//        String s1 = "abefcdgiescdfimde";
//        String s2 = "ab*cd?i*de";
        WildcardMatching wm = new WildcardMatching();
        boolean result = wm.isMatch(s1, s2);
        if(result){
            System.out.println("Its a match!");
        } else {
            System.out.println("Not a match!");
        }
    }
    
}
