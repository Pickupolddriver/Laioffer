package com.leetcode;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> res = sol.combinationSum(candidates, target);
        for (List<Integer> x : res) {
            for (int num : x) {
                System.out.print(num + " , ");
            }
            System.out.println();
        }
    }
}
