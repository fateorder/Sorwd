package com.y16.m11.d1;

/**
 * Created by a123 on 2016/11/1.
 */
public class Solution3 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        else return comRoot(pRoot.left, pRoot.right);

    }

    boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}

