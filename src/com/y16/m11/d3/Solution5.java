package com.y16.m11.d3;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution5 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(numbers[i] + "");
        }
        for (int j = 0; j < length; j++) {
            if (sb.indexOf(numbers[j] + "") != sb.lastIndexOf(numbers[j] + "")) {
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }
}
