package com.laioffer2022;

public class LCAI {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // Corner case
    if (root == null || root.key == one.key || root.key == two.key) {
      return root;
    }
    // Expanding rule
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) {
      return root;
    }
    if (left != null) {
      return left;
    }
    return right;
  }
}
