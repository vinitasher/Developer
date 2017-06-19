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
public class PrintLastNLines {
    
    public void printLines(String s, int k){
        int length = s.length();
        int i = length - 1;
        int endIndex = length - 1;
        while(i >= 0 && k>0){
            if(s.charAt(i) == '\n' && i != length-1 && !s.substring(i+1,endIndex).isEmpty()){
                k--;
                endIndex--;
            }
            i--;
        }
        if(i>0)
            System.out.println(s.substring(i));
        else 
            System.out.println(s);
    }
    
    
    public static void main(String[] args){
        PrintLastNLines lines = new PrintLastNLines();

		String line1 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7\nstr8\nstr9\nstr10\n"
				+ "str11\nstr12\nstr13\nstr14\nstr15\nstr16\nstr17\nstr18\nstr19\nstr20\n"
				+ "str21\nstr22\nstr23\nstr24\n\n\n\nstr25";

		String line2 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7";

		String line3 = "\n";

		String line4 = "";

		lines.printLines(line1, 10);
		lines.printLines(line2, 10);
		lines.printLines(line3, 10);
		lines.printLines(line4, 10);
    }
}
