package com.y16.m11.d3;

import java.util.ArrayList;

/**
 * Created by a123 on 2016/11/3.
 */
public class Solution1 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            }
        }
        return list;
    }
}
