package com.y16.m11.d1;

import java.util.*;

/**
 * Created by a123 on 2016/11/1.
 */
public class Solution2 {



    private char[] seqs;
    private Integer[] book;
    private HashSet<String> result = new HashSet<String>();

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrange = new ArrayList<String>();
        if (str == null || str.isEmpty()) {
            return arrange;
        }
        char[] strs = str.toCharArray();
        seqs = new char[strs.length];
        book = new Integer[strs.length];
        for (int i = 0; i < book.length; ++i) {
            book[i] = 0;
        }
        dfs(strs, 0);
        arrange.addAll(result);
        Collections.sort(arrange);
        return arrange;
    }

    private void dfs(char[] arrs, int step) {
        if (arrs.length == step) {
            String str = "";
            for (int i = 0; i < seqs.length; ++i) {
                str += seqs[i];
            }
            System.out.println(str);
            result.add(str);
            return;
        }

        for (int i = 0; i < arrs.length; ++i) {
            if (book[i] == 0) {
                seqs[step] = arrs[i];
                book[i] = 1;
                dfs(arrs, step + 1);
                book[i] = 0;
            }
        }

    }
}
