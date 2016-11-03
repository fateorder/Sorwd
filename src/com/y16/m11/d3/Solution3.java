package com.y16.m11.d3;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution3 {

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        int temp = 0;
        for (int i = 2; i <= n; ++i) {
            temp = (temp + m) % i;
        }
        return temp;
    }
}
