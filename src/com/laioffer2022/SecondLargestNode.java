package com.laioffer2022;

public class SecondLargestNode {
    public static int cnt = 0;
    public static int res = Integer.MIN_VALUE;
    public int secondLargest(TreeNode root) {
        // Corner case
        if(root==null){
            return res;
        }
        revPreOrder(root);
        return res;
    }

    public void revPreOrder(TreeNode root){
        // Terminate condition
        if(root==null || cnt>2){
            return;
        }
        if(cnt==1){
            res = root.key;
            return;
        }
        revPreOrder(root.right);
        cnt++;
        revPreOrder(root.left);
    }
}
