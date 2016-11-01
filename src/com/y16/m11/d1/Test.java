package com.y16.m11.d1;

/**
 * Created by a123 on 2016/11/1.
 */
public class Test {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] A = {1, 2, 3, 4};
        int[] B = solution4.multiply(A);
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + "    ");
            System.out.println(B[i]);
        }
    }
}


