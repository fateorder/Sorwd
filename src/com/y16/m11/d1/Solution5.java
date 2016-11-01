package com.y16.m11.d1;

import java.util.ArrayList;

/**
 * Created by a123 on 2016/11/1.
 */
public class Solution5 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) return al;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; ++j) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }


}
