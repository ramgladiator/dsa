package com.kk.stacks;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int currentNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                currentNum = 0;
                currentString = "";
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(currentString);
                }
                currentString = stringStack.pop() + temp.toString();
            } else {
                currentString += ch;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String encodedString = "3[a2[c]]";
        String decodedString = solution.decodeString(encodedString);
        System.out.println(decodedString); // Output: "accaccacc"
    }
}
