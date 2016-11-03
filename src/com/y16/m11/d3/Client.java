package com.y16.m11.d3;


/**
 * Created by a123 on 2016/11/3.
 */
public class Client {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int n = 10;
        int j = 0;
        ListNode a = new ListNode(j);
        ListNode temp = a;
        for (int i = 0; i < n; ++i) {
            ListNode t = new ListNode(j);
            a.next = t;
            a = a.next;
            if (i % 2 == 0) {
                ++j;
            }
        }
        System.out.print(solution6.deleteDuplication(temp));
    }

}

