package com.y16.m11.d1;

/**
 * Created by a123 on 2016/11/1.
 */
public class Solution4 {


    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length ; ++i) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int j = A.length - 1; j >= 0; --j) {
            B[j] *= temp;
            temp *= A[j];

        }

        return B;
    }
}
