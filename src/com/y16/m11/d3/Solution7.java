package com.y16.m11.d3;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution7 {

    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) return 0;
        char[] a = str.toCharArray();
        int flag = 0;
        int sum = 0;
        if (a[0] == '-') flag = 1;
        for (int i = flag; i < a.length; i++) {
            if (a[i] == '+') continue;
            if (a[i] < 48 || a[i] > 57) return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return (flag == 0) ? sum : -1 * sum;
    }
}
