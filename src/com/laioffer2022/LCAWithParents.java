package com.laioffer2022;

public class LCAWithParents {

  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // This two nodes are not guarantee to be the in the same tree
    // Corner case
    if (one == null || two == null) {
      return null;
    }
    TreeNodeP oneT = one;
    TreeNodeP twoT = two;
    int lv1 = 0;
    int lv2 = 0;
    while (oneT.parent != null) {
      oneT = oneT.parent;
      lv1++;
    }
    while (twoT.parent != null) {
      twoT = twoT.parent;
      lv2++;
    }
    TreeNodeP tmp1 = one;
    TreeNodeP tmp2 = two;
    // Move them to the same level
    while (lv1 > lv2) {
      tmp1 = tmp1.parent;
      lv1--;
    }
    while (lv2 > lv1) {
      tmp2 = tmp2.parent;
      lv2--;
    }
    while (tmp1.parent != null && tmp1 != tmp2) {
      tmp1 = tmp1.parent;
      tmp2 = tmp2.parent;
    }
    // after check
    if (tmp1 == tmp2) {
      return tmp1;
    }
    return null;
  }
}
