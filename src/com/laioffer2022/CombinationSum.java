package com.laioffer2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> buffer = new ArrayList<Integer>();
        Arrays.sort(candidates);
        reverse(candidates);
        combination(candidates, 0, target, buffer, res);
        return res;
    }

    public void combination(int[] candidates, int currIdx, int target, List<Integer> buffer, List<List<Integer>> res) {
        // Terminate condition
        if (currIdx == candidates.length || target <= 0) {
            if (target == 0) {
                List<Integer> act = generateTmp(candidates, buffer);
                res.add(act);
            }
            return;
        }
        // Expanding Rule
        int maxCnt = target / candidates[currIdx];
        for (int i = 0; i <= maxCnt; i++) {
            buffer.add(i);
            combination(candidates, currIdx + 1, target - i * candidates[currIdx], buffer, res);
            buffer.remove(buffer.size() - 1);
        }
    }

    public List<Integer> generateTmp(int[] candidates, List<Integer> cnt) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < cnt.size(); i++) {
            for (int j = cnt.get(i); j > 0; j--) {
                res.add(candidates[i]);
            }
        }
        return res;
    }

    public void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
