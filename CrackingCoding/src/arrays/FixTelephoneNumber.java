/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author vasher
 */
public class FixTelephoneNumber {
    
    public void reformat(String[] phoneNumbers){
        int i=0;
        for(String str: phoneNumbers){
            StringBuilder sb = new StringBuilder();
            if(str.contains("-")){
                //String[] parts = str.split("-");
                //sb = sb.append(parts[1]).append("-").append(parts[0]).append("-").append(parts[2]);
                str = str.replaceFirst("(\\d{3})-(\\d{3})-(\\d+)", "$2-$1-$3");
            } 
            //blah blalh
            else {
                str = str.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$2-$1-$3");
                //sb = sb.append(str.substring(3, 6)).append("-").append(str.substring(0,3)).append("-").append(str.substring(6));
            }
            phoneNumbers[i++] = str;
        }
    }
    
    public static void main(String[] args){
        FixTelephoneNumber instance = new FixTelephoneNumber();
        String[] errorSoon = {"213-300-4671", "8172012396"};
        instance.reformat(errorSoon);
        for(String str: errorSoon){
            System.out.println(str);
        }
        
        
    }
    
}
