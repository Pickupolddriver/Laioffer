package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        reverseArray(candidates);
        permutate(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }

    public void permutate(List<List<Integer>> res, List<Integer> curr, int currIdx, int[] candidates, int target) {
        // Terminate condition
        if (currIdx == candidates.length - 1) {
            if (target % candidates[currIdx] == 0) {
                curr.add(target / candidates[currIdx]);
                res.add(generateList(candidates, curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        // Expanding Rule
        int maxCnt = target / candidates[currIdx];
        for (int i = 0; i <= maxCnt; i++) {
            curr.add(i);
            permutate(res, curr, currIdx + 1, candidates, target - i * candidates[currIdx]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<Integer> generateList(int[] candidates, List<Integer> cntList) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<candidates.length;i++){
            int curr = candidates[i];
            for(int j=0;j<cntList.get(i);j++){
                res.add(curr);
            }
        }
        return res;
    }

    public void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
