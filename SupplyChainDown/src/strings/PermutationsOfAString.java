package strings;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {
    public List<String> permute(String str) {
        List<String> output = new ArrayList<>();
        char[] cArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cArr.length; i++){
            permuteHelper(cArr, i, sb, output);
        }
        return output;
    }

    public void permuteHelper(char[] cArr, int start, StringBuilder sb, List<String> output){
        if(start == cArr.length) start = 0;
        if(sb.length() == cArr.length){
            output.add(new StringBuffer(sb).toString());
            return;
        }
        for(int i=start; i < cArr.length; i++){
            sb.append(cArr[i]);
            permuteHelper(cArr, i + 1, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsOfAString instance = new PermutationsOfAString();
        System.out.println(instance.permute("abc"));
    }
}
