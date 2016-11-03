package com.y16.m11.d3;

import java.util.Stack;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution2 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                stack.push(sb.toString());
                sb = new StringBuilder();
            }
        }
        stack.push(sb.toString());
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


}
