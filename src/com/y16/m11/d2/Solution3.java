package com.y16.m11.d2;

/**
 * Created by a123 on 2016/11/2.
 */
public class Solution3 {

    public String LeftRotateString(String str, int k) {
        char[] chars = str.toCharArray();
        if (chars.length < k) return "";
        reserve(chars, 0, k - 1);
        reserve(chars, k, chars.length - 1);
        reserve(chars, 0, chars.length - 1);
        StringBuilder result = new StringBuilder(chars.length);
        for (char c : chars) {
            result.append(c);
        }
        return result.toString();
    }

    public void reserve(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
