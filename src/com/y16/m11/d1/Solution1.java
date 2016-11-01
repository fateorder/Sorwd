package com.y16.m11.d1;

import java.util.Stack;
import java.util.Collection;

/**
 * Created by a123 on 2016/11/1.
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution1 {

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        boolean isFirst = true;
        //中序遍历
        while (p != null && !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //头结点
            if (isFirst) {
                root = p;
                pre = root;
                isFirst = false;
            } else {
                //连接中序遍历中的相邻结点
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            //右子树已完
            p = p.right;
        }
        return root;
    }
}
