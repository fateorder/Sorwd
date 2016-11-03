package com.y16.m11.d3;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution9 {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
