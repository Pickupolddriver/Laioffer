package com.leetcode;


public class ClosetInBST {
    public int closestValue(TreeNode root, double target) {
        // Terminate condition
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (target == root.val) {
            return root.val;
        } else if (target < root.val) {
            if (root.left == null) {
                return root.val;
            }
            int closestRight = closestValue(root.left, target);
            ;
            if (Math.abs(root.val - target) < Math.abs(closestRight - target)) {
                return root.val;
            } else {
                return closestRight;
            }

        } else {
            if (root.right == null) {
                return root.val;
            }
            int closestLeft = closestValue(root.right, target);
            if (Math.abs(root.val - target) < Math.abs(closestLeft - target)) {
                return root.val;
            } else {
                return closestLeft;
            }
        }
    }
}
