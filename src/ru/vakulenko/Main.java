package ru.vakulenko;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Arrays.asList("(()", ")()())", ")(()())", ")(", "())(()())(()", ")))()(())(()(()()((())()())()())((()))))(((()()(()()")
                .forEach(i -> System.out.println(getValidBrackets(i)));
    }

    public static String getValidBrackets(final String str) {
        Stack<Integer> bracketsStack = new Stack<>();
        StringBuilder resultSB = new StringBuilder(str);
        resultSB.trimToSize();
        for (int i = 0; i < resultSB.length(); ) {
            char ch = resultSB.charAt(i);
            if (ch == '(') {
                bracketsStack.push(i);
                i++;
            } else if (ch == ')' && !bracketsStack.empty()) {
                bracketsStack.pop();
                i++;
            } else {
                resultSB.deleteCharAt(i);
            }
        }

        if (!bracketsStack.empty()) {
            int size = bracketsStack.size();
            for (int i = 0; i < size; i++) {
                resultSB.deleteCharAt(bracketsStack.pop());
            }
        }

        if (resultSB.length() == 0) {
            return resultSB.append("0 - ").append(str).toString();
        }
        return resultSB.insert(0, resultSB.length() + " - ").toString();
    }
}
