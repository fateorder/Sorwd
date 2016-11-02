package com.y16.m11.d2;

/**
 * Created by a123 on 2016/11/2.
 */
public class Solution2 {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public void main(String[] args) {
        this.Add(5, 7);
    }
}
