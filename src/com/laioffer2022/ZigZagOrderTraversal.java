package com.laioffer2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagOrderTraversal {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // Corner case
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; i++) {
                if (level % 2 == 0) {
                    TreeNode tmp = deque.pollFirst();
                    res.add(tmp.key);
                    if (tmp.right != null) {
                        deque.addLast(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.addLast(tmp.left);
                    }
                } else {
                    TreeNode tmp = deque.pollLast();
                    res.add(tmp.key);
                    if (tmp.right != null) {
                        deque.addFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.addFirst(tmp.left);
                    }
                }
            }
            level++;
        }
        return res;
    }
}
