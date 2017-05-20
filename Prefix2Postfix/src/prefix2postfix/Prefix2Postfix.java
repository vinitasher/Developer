package prefix2postfix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prefix2Postfix {

    public static void main(String[] args) {
        System.out.println(pre2post("+++1234"));
    }

    public static String pre2post(String pre) {
        Stack s = new Stack();
        Queue q = new LinkedList();
        Boolean lastDigitOrLetter = false;
        String post = "";
        for (int i = 0; i < pre.length(); i++) {
            if (Character.isLetter(pre.charAt(i)) || Character.isDigit(pre.charAt(i))) {
                q.add(pre.charAt(i));
                if (!lastDigitOrLetter) {
                    lastDigitOrLetter = true;
                } else {
                    int length = q.size();
                    while (!q.isEmpty()) {
                        post += q.poll();
                    }
                    for (int j = 0; j < length - 1; j++) {
                        post += s.pop();
                    }
//                    lastDigitOrLetter = false;
                }
            } else if (!Character.isLetter(pre.charAt(i)) && !Character.isDigit(pre.charAt(i))) {
                lastDigitOrLetter = false;
                s.push(pre.charAt(i));
            }
        }
        while (!q.isEmpty()) {
            post += q.remove();
        }
        while (!s.isEmpty()) {
            post += s.pop();
        }

        return post;
    }
}
