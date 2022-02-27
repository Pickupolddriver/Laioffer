package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        findAllSubset(res, nums, curr, 0);
        return res;
    }

    public void findAllSubset(List<List<Integer>> res, int[] nums, List<Integer> curr, int idx) {
        // Terminate condition
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        // Expanding Rule
        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i] != nums[i - 1]) {
                curr.add(nums[i]);
                findAllSubset(res, nums, curr, idx);
                curr.remove(curr.size() - 1);
            }
            findAllSubset(res, nums, curr, idx);
        }
    }
}
